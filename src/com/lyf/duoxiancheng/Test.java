package com.lyf.duoxiancheng;

public class Test {
	public synchronized  void print1(){
		System.out.println("��ӡ1111111111");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public synchronized  void print2(){
		System.out.println("��ӡ22222222222");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
