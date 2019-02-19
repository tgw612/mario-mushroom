package creazyjava.sync.synchron;

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
public class Account {
    private String accountNo;
    private double balance;
    private boolean flag = false;

    public Account() {
    }

    public Account(String accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountNo() {
        return this.accountNo;
    }

    public double getBalance() {
        return this.balance;
    }

    public synchronized void draw(double drawAmount) {
        try {
            if (!flag) {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " ȡǮ:" + drawAmount);
                balance -= drawAmount;
                System.out.println("�˻����Ϊ��" + balance);
                flag = false;
                notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public synchronized void deposit(double depositAmount) {
        try {
            if (flag)
            {
                wait();
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " ���:" + depositAmount);
                balance += depositAmount;
                System.out.println("�˻����Ϊ��" + balance);
                flag = true;
                notifyAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
    }

    public int hashCode() {
        return accountNo.hashCode();
    }

    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj != null
                && obj.getClass() == Account.class) {
            Account target = (Account) obj;
            return target.getAccountNo().equals(accountNo);
        }
        return false;
    }
}