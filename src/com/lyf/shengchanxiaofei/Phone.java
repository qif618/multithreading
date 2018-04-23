package com.lyf.shengchanxiaofei;

class Phone{ 
    private String name;
    private boolean flag = true ;
    
    public synchronized void set(String name) throws Exception{  
        while(!flag){  
        	super.wait() ; //把对象锁放开给消费者线程去调用get方法
        }  
        System.out.println("生产一个手机");
        this.setName(name) ;    // 设置名称  
        Thread.sleep(300) ;  
        flag  = false ; // 改变标志位，表示可以取走  
        super.notify();//唤醒消费者线程去执行，但要等到生产者线程释放锁  
    }  
    public synchronized void get() throws Exception{  
        while(flag){  
        	 super.wait() ;  //把对象锁放开，让生产者线程去调用set方法,当把锁已放开，此时进入等待
        	//要等生产者执行完，执行下方的继续取值
        }  
        System.out.println("取到一个手机：" +  this.getName());
        flag  = true ;  // 改变标志位，表示可以生产  
        super.notify(); //唤醒生产者线程去执行，但要等到消费者线程释放锁   
    }  
    public void setName(String name){  
        this.name = name ;  
    }  
    public String getName(){  
        return this.name ;  
    }  
}  