package gaoSir.sameNum;
public class Run {

	public static void main(String[] args) {
		/**
		 * why ???
		 */
		MyThread run = new MyThread();

		Thread t1 = new Thread(run);
		Thread t2 = new Thread(run);
		Thread t3 = new Thread(run);
		Thread t4 = new Thread(run);
		Thread t5 = new Thread(run);

		/**
		 * 秘密在这里,start的次序会影响最终次序
		 */
		t1.start();
		t2.start();
		t3.start();
		t4.start();
		t5.start();

	}

}
