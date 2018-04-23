package com.lyf.duoxiancheng;


public class MyThreadPrinter2 implements Runnable {     
    
    private String name;     
    private Object prev;     
    private Object self;     
    
    private MyThreadPrinter2(String name, Object prev, Object self) {     
        this.name = name;     
        this.prev = prev;     
        this.self = self;     
    }     
    /**
     *  wait() ��  notify/notifyAll()��synchronized����ʹ
     *  ���߳�ִ��wait()ʱ����ѵ�ǰ�����ͷţ�Ȼ���ó�CPU������ȴ�״̬��
 	 *	��ִ��notify/notifyAll����ʱ���ỽ��һ�����ڵȴ��� ������ ���̣߳�
   	 *	Ȼ���������ִ�У�ֱ��ִ�����˳���������ס������synchronized���εĴ���飩�����ͷ�����
     */
    @Override    
    public void run() {     
        int count = 10;     
        while (count > 0) {     
            synchronized (prev) {     
                synchronized (self) {
                	if(name.equals("C")){
                		System.out.print(name+" "); 
                	}else{
                		System.out.print(name); 
                	}
                    count--;    
                      
                    self.notify();     
                }     
                try {     
                    prev.wait();     
                } catch (InterruptedException e) {     
                    e.printStackTrace();     
                }     
            }     
    
        }     
    }     
    
    public static void main(String[] args) throws Exception {     
        Object a = new Object();     
        Object b = new Object();     
        Object c = new Object();     
        MyThreadPrinter2 pa = new MyThreadPrinter2("A", c, a);//��ӡ��A��������Ҫa������߳�pbȥִ�д�ӡB�����ͷ�c    
        MyThreadPrinter2 pb = new MyThreadPrinter2("B", a, b);//��ӡ��B��������Ҫb������߳�pcȥִ�д�ӡC�����ͷ�a      
        MyThreadPrinter2 pc = new MyThreadPrinter2("C", b, c);//��ӡ��C��������Ҫc������߳�paȥִ�д�ӡA�����ͷ�b      
             
        new Thread(pa).start();  
        Thread.sleep(100);  //ȷ����˳��A��B��Cִ��  
        new Thread(pb).start();  
        Thread.sleep(100);    
        new Thread(pc).start();     
        Thread.sleep(100);    
        }     
}    
