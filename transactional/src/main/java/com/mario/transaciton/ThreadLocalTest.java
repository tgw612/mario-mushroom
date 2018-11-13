package com.mario.transaciton;

public class ThreadLocalTest {
    private static ThreadLocal<Integer> seqNum = ThreadLocal.withInitial(() -> 0);

    public int getNextNum() {
        seqNum.set(1 + seqNum.get());
        return seqNum.get();
    }

    public static void main(String[] args) {
        ThreadLocalTest sn =new ThreadLocalTest();

        TestClient t1=new TestClient(sn);
        TestClient t2=new TestClient(sn);
        TestClient t3=new TestClient(sn);

        t1.start();
        t2.start();
        t3.start();
    }

    private static class TestClient extends Thread{
        private ThreadLocalTest sn;


        public TestClient(ThreadLocalTest sn) {
            this.sn = sn;
        }

        public void run(){
            for (int i = 0; i < 3; i++) {
                System.out.println(Thread.currentThread().getName()+"--getValue:["+sn.getNextNum()+"]");
            }
        }
    }
}
