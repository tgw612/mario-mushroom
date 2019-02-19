package creazyjava.sync.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    private final Lock lock = new ReentrantLock();
    private final Condition cond = lock.newCondition();
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

    public void draw(double drawAmount) {
        lock.lock();
        try {
            if (!flag) {
                cond.await();
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " ȡǮ:" + drawAmount);
                balance -= drawAmount;
                System.out.println("�˻����Ϊ��" + balance);
                flag = false;
                cond.signalAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            lock.unlock();
        }
    }

    public void deposit(double depositAmount) {
        lock.lock();
        try {
            if (flag)
            {
                cond.await();
            } else {
                System.out.println(Thread.currentThread().getName()
                        + " ���:" + depositAmount);
                balance += depositAmount;
                System.out.println("�˻����Ϊ��" + balance);
                flag = true;
                cond.signalAll();
            }
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        finally {
            lock.unlock();
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