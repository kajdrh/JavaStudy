package com.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

class Member {

    private String userId;
    private String userName;
    private int age;

    Member(String userId, String userName, int age) {

        this.userId = userId;
        this.userName = userName;
        this.age = age;
    }

    static class Builder {

        private String userId;
        private String userName;
        private int age;

        public Builder userId(String userId) {

            this.userId = userId;
            return this;
        }
        public Builder userName(String userName) {

            this.userName = userName;
            return this;
        }
        public Builder age(int age) {

            this.age = age;
            return this;
        }

        public Member build() {

            if(userId == null || userName == null || age == 0)
                throw new IllegalStateException("멤버클래스가 생성이 안됩니다.");
        
            return new Member(userId, userName, age);
        }


    } // Builder class의 끝

    public String getUserId() { return userId; }
    public String getUserName() { return userName; }
    public int getAge() { return age; }
}


public class JDBCTest {
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        
        String uri = "jdbc:mariadb://127.0.0.1:3306/webdev";
        String userId = "webmaster";
        String userPw = "admin";
        String query = "select * from tbl_test";

        Connection con;
        Statement stmt;
        ResultSet rs;

        Class.forName("org.mariadb.jdbc.Driver");
        con = DriverManager.getConnection(uri, userId, userPw);
        stmt = con.createStatement();
        rs = stmt.executeQuery(query);

        List<Member> list = new ArrayList<>();

        while(rs.next()) {

            // list.add(new Member(rs.getString("userId"), rs.getString("userName"), rs.getInt("age")));
            list.add(new Member.Builder()
                .userId(rs.getString("userId"))
                .userName(rs.getString("userName"))
                .age(rs.getInt("age"))
                .build()
            );
        }

        for(Member member: list) {

            System.out.println("아이디 = " + member.getUserId() 
            + ", 이름 = " + member.getUserName() 
            + ", 나이 = " + member.getAge());
        }

        if(rs != null) 
            rs.close();
        if(stmt != null)
            stmt.close();
        if(con != null)
            con.close();
    }
}
