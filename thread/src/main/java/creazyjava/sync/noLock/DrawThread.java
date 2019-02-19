package creazyjava.sync.noLock;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2016, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 *
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class DrawThread extends Thread {
    private Account account;
    private double drawAmount;

    public DrawThread(String name, Account account
            , double drawAmount) {
        super(name);
        this.account = account;
        this.drawAmount = drawAmount;
    }

    public void run() {
        if (account.getBalance() >= drawAmount) {
            System.out.println(getName()
                    + "ȡǮ�ɹ����³���Ʊ:" + drawAmount);
            try {
                Thread.sleep(1);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
            account.setBalance(account.getBalance() - drawAmount);
            System.out.println("\t���Ϊ: " + account.getBalance());
        } else {
            System.out.println(getName() + "ȡǮʧ�ܣ����㣡");
        }
    }
}
