package com.lyf.duoxiancheng;
/**
 * ��һ���̷߳���һ�����е�ͬ����̬����ʱ����ȡ�ĵ���CLASS�౾�����������̲߳��ܷ��ʸ��������ͬ����̬����
 * ��һ���̷߳���һ��ʵ����ͬ������ʱ����ȡ�ĵ���CLASS�౾�����������̲߳��ܷ��ʸ�ʵ��������ͬ������
 * ��һ���̷߳��ʸ���Ĳ�ͬʵ����ͬ������ʱ�������߳̿��Է�������ͬ������
 * ��ͬ�����������Է���
 *
 */
public class Synchronized {
	Test test1 = new Test();
	Test test2 = new Test();
	public synchronized  void add1(){
		System.out.println("����ʹ�÷�1");
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public synchronized  void add2(){
		System.out.println("����ʹ�÷�2");
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
		//�ڲ��ഴ�����ȴ������ⲿ��
		Synchronized s = new Synchronized();
		Synchronized1 s1 = s.new Synchronized1();
		Synchronized2 s2 = s.new Synchronized2();
		
		Thread t1 = new Thread(s1);
		Thread t2 = new Thread(s2);
		
		t1.start();
		t2.start();
	}
}













