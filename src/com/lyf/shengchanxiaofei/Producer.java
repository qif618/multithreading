package com.lyf.shengchanxiaofei;

class Producer implements Runnable{ // 通过Runnable实现多线程  
    private Phone phone = null ;     
    public Producer(Phone info){  
        this.phone = info ;  
    }  
    public void run(){  
        for(int i=0;i<10;i++){  
                try {
					this.phone.set("手机--"+String.valueOf(i)) ;
				} catch (Exception e) {
					e.printStackTrace();
				}   
        }  
    }  
}  
