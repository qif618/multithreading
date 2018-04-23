package com.lyf.duoxiancheng;
/**
 * 当一个线程访问一个类中的同步静态方法时，获取的但是CLASS类本身锁，其他线程不能访问该类的其他同步静态方法
 * 当一个线程访问一个实例中同步方法时，获取的但是CLASS类本身锁，其他线程不能访问该实例中其他同步方法
 * 当一个线程访问该类的不同实例的同步方法时，其他线程可以访问其他同步方法
 * 非同步方法都可以访问
 *
 */
public class Synchronized {
	Test test1 = new Test();
	Test test2 = new Test();
	public synchronized  void add1(){
		System.out.println("我在使用法1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized  void add2(){
		System.out.println("我在使用法2");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	class Synchronized1 implements Runnable{
		
		@Override
		public void run() {
			//test1.print1();
			add1();
		}
		
	}
	
	class Synchronized2 implements Runnable{

		@Override
		public void run() {
			//test2.print2();
			add2();
		}
		
	}
	
	public static void main(String[] args){
		//内部类创建需先创建其外部类
		Synchronized s = new Synchronized();
		Synchronized1 s1 = s.new Synchronized1();
		Synchronized2 s2 = s.new Synchronized2();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
	}
}













