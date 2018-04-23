package com.lyf.duoxiancheng;

import java.util.Date;

public class DuoxianCheng1 implements Runnable{
	private String x;
	private int y;
	
	public DuoxianCheng1(String x,int y){
		this.x=x;
		this.y=y;
	}

	@Override
	public void run() {
		while(true) {
            try {
                System.out.println(x + ":" + new 
                    Date(System.currentTimeMillis()));
                Thread.sleep(y);
            } catch(Exception e) {
                System.out.println(e);
            }
        }
	}
	
	public static void main(String[] args){
		DuoxianCheng1 d1 = new DuoxianCheng1("中国", 1000);
		DuoxianCheng1 d2 = new DuoxianCheng1("日本", 3000);
		Thread td1 = new Thread(d1);
		Thread td2 = new Thread(d2);
		td1.start();
		td2.start();
	}
}












