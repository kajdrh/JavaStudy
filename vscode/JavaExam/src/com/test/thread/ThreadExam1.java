package com.test.thread;

class ExamClass implements Runnable {

    @Override
    public void run() {
        for(int i=0; i<30; i++) {
            
            try {
                Thread.sleep(1000);
                System.out.println("Thread1이 실행");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class ThreadExam1 {

    public static void main(String[] args) {
        
        Thread thread = new Thread(new ExamClass());
        thread.start();

        for(int i=0; i<30; i++){
            try {
                Thread.sleep(1000);
                System.out.println("Thread2가 실행");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    } 
}
