package com.lyf.shengchanxiaofei;

public class ThreadCaseDemo3{  
    public static void main(String args[]) throws Exception{  
        Phone info = new Phone(); // ʵ����Info����  
        Producer pro = new Producer(info) ; // ������  
        Consumer con = new Consumer(info) ; // ������  
        new Thread(pro).start() ;  
        //�������������̺߳��������������߳�  
        Thread.sleep(500) ; 
        new Thread(con).start() ;  
    }  
}  