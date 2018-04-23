package com.lyf.duoxiancheng;

public class ThreadDieSock implements Runnable {
    private int flag = 1;
    private Object obj1 = new Object(), obj2 = new Object();

    public void run() {
        if (flag == 1) {
            synchronized (obj1) {
                System.out.println("���Ѿ�����obj1����Ϣ5�������obj2ȥ��");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj2) {
                    System.out.println("����obj2");
                }
                
            }
        }
        if (flag == 0) {
            synchronized (obj2) {
                System.out.println("���Ѿ�����obj2����Ϣ0.5�������obj1ȥ��");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    System.out.println("����obj1");
                }
            }
        }
    }

    public static void main(String[] args) {
        ThreadDieSock run01 = new ThreadDieSock();
        ThreadDieSock run02 = new ThreadDieSock();
        run01.flag = 1;
        run02.flag = 0;
        Thread thread01 = new Thread(run01);
        Thread thread02 = new Thread(run02);
        System.out.println("�߳̿�ʼඣ�");
        thread01.start();
        thread02.start();
    }
}