package com.lyf.shengchanxiaofei;

public class ThreadCaseDemo3{  
    public static void main(String args[]) throws Exception{  
        Phone info = new Phone(); // 实例化Info对象  
        Producer pro = new Producer(info) ; // 生产者  
        Consumer con = new Consumer(info) ; // 消费者  
        new Thread(pro).start() ;  
        //启动了生产者线程后，再启动消费者线程  
        Thread.sleep(500) ; 
        new Thread(con).start() ;  
    }  
}  