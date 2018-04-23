package com.lyf.shengchanxiaofei;

class Consumer implements Runnable{  
    private Phone phone = null ;  
    public Consumer(Phone phone){  
        this.phone = phone ;  
    }  
    public void run(){  
        for(int i=0;i<10;i++){  
            try {
				this.phone.get() ;
			} catch (Exception e) {
				e.printStackTrace();
			}  
        }  
    }  
} 