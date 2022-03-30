package com.test.mapper;

import java.util.List;
import com.test.entity.Member;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface BoardMapper {
	@Select("select userid, username, age from tbl_test order by userid desc")
	public List<Member> selectMemberList();

	@Insert("insert into tbl_test (userid, username, age) values (\'${userid}\', \'${username}\',\'${age}\')")
	public void insertMember(@Param("userid") String userid,
			@Param("username") String username, @Param("age") int age);
}