package com.lyf.shengchanxiaofei;

class Phone{ 
    private String name;
    private boolean flag = true ;
    
    public synchronized void set(String name) throws Exception{  
        while(!flag){  
        	super.wait() ; //�Ѷ������ſ����������߳�ȥ����get����
        }  
        System.out.println("����һ���ֻ�");
        this.setName(name) ;    // ��������  
        Thread.sleep(300) ;  
        flag  = false ; // �ı��־λ����ʾ����ȡ��  
        super.notify();//�����������߳�ȥִ�У���Ҫ�ȵ��������߳��ͷ���  
    }  
    public synchronized void get() throws Exception{  
        while(flag){  
        	 super.wait() ;  //�Ѷ������ſ������������߳�ȥ����set����,�������ѷſ�����ʱ����ȴ�
        	//Ҫ��������ִ���ִ꣬���·��ļ���ȡֵ
        }  
        System.out.println("ȡ��һ���ֻ���" +  this.getName());
        flag  = true ;  // �ı��־λ����ʾ��������  
        super.notify(); //�����������߳�ȥִ�У���Ҫ�ȵ��������߳��ͷ���   
    }  
    public void setName(String name){  
        this.name = name ;  
    }  
    public String getName(){  
        return this.name ;  
    }  
}  