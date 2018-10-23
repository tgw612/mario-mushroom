package concurrent;

/**
 * Created by tgw61 on 2017/7/20.
 */
public class Daemon {
    public static void main(String[] args) {
        Thread thread=new Thread(new DaemonRunner(),"DaemonRunner");
        thread.setDaemon(true);
        thread.start();
    }

    private static class DaemonRunner implements Runnable {
        @Override
        public void run() {
            try {
                Thread.currentThread().sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                System.out.println("DaemonThread finally run");
            }
        }
    }
}
