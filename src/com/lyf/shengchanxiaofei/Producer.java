package com.lyf.shengchanxiaofei;

class Producer implements Runnable{ // ͨ��Runnableʵ�ֶ��߳�  
    private Phone phone = null ;     
    public Producer(Phone info){  
        this.phone = info ;  
    }  
    public void run(){  
        for(int i=0;i<10;i++){  
                try {
					this.phone.set("�ֻ�--"+String.valueOf(i)) ;
				} catch (Exception e) {
					e.printStackTrace();
				}   
        }  
    }  
}  
