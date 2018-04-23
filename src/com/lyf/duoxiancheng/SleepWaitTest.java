package com.lyf.duoxiancheng;


public class SleepWaitTest {
	private int a = 1;
	
	public synchronized int add() throws InterruptedException{
		a = a +1;
		Thread.sleep(5000);
		return a;
	}
	public synchronized void syso() throws InterruptedException{
		System.out.println("什么鬼");
	}
	class SleepWait1 implements Runnable{
		private Object o;    
		private SleepWait1(Object o){
			this.o = o;
		}
		@Override
		public void run() {
			try {
				System.out.println(add());
			} catch (InterruptedException e) {
				
				e.printStackTrace();
			}
		}
		
	}
	
	class SleepWait2 implements Runnable{
		private Object o;    
		private SleepWait2(Object o){
			this.o = o;
		}
		
		@Override
		public void run() {
			try {
				syso();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args){
		//内部类创建需先创建其外部类
		SleepWaitTest s = new SleepWaitTest();
		SleepWait1 s1 = s.new SleepWait1("s2");
		SleepWait2 s2 = s.new SleepWait2("s1");
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
	}
}
