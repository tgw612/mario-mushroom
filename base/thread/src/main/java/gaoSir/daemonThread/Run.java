package gaoSir.daemonThread;


public class Run {

  public static void main(String[] args) {
    try {
      MyThread thread = new MyThread();
      thread.setDaemon(true);
      thread.start();
      Thread.sleep(5000);
      System.out.println("���뿪thread����Ҳ���ٴ�ӡ�ˣ�Ҳ����ֹͣ�ˣ�");
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
