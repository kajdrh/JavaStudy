package com.test.exam05;

class A{

    private int a;
    private int b;
    static int c; //컴파일시 코드 및 데이터 영역이 생성되고 프로그램 종료시까지 데이터가 유지된다.

    A(){
        System.out.println("A 클래스가 생성");
        aa();
    }  //컴파일시 자동으로 생성

    A(int a, int b){
        this.a = a;
        this.b = b;
        c = bb(a, b);
    }

    void aa(){
        System.out.println("A클래스의 aa메소드");
    }

    int bb(int i, int j){
        return i+j;
    }
}

abstract class C{//부모 클래스

    int a;
    int b;

    void cc(){
        System.out.println("C클래스");
    }

    abstract void cc1();
}

class D extends C{//자식 클래스

    int d;
    int e;

    /*@Override //Annotation --> 컴파일러에게 오버라이딩이라고 안내해주는 역할
    void cc(){
        System.out.println("C클래스 cc메소드");
    }*/

    @Override
    void cc1() {
        System.out.println("D클래스 cc1메소드");
    }

    void dd(){
        System.out.println("D클래스 dd메소드");
    }
}

interface E{//설계도
    void ee1();
    void ee2();
}

class F implements E{

    @Override
    public void ee1() {
        System.out.println("ee1 메소드");
    }

    @Override
    public void ee2() {
        System.out.println("ee2 메소드");
    }
    
}

class G{

    static class GG{
        int i = 0;
        void gg(){
            System.out.println("GG내부 클래스");
        }
    }
}

public class Exam05 {
    public static void main(String[] args) {
        
        A a = new A();
        a.aa();
        System.out.println(a.bb(1, 2));

        A aa = new A(3, 4);

        System.out.println(aa.c);
        System.out.println(a.c);

        D d = new D();
        d.cc1();

        F f = new F();
        f.ee1();
        f.ee2();

        new A();
        G.GG g = new G.GG();
        g.gg();
    }
}