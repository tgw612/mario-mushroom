package creazyjava.sync.forkJoin;

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
class Account {
    private ThreadLocal<String> name = new ThreadLocal<>();

    public Account(String str) {
        this.name.set(str);
        System.out.println("---" + this.name.get());
    }

    public String getName() {
        return name.get();
    }

    public void setName(String str) {
        this.name.set(str);
    }
}

class MyTest extends Thread {
    private Account account;

    public MyTest(Account account, String name) {
        super(name);
        this.account = account;
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            if (i == 6) {
                account.setName(getName());
            }
            System.out.println(account.getName()
                    + " �˻���iֵ��" + i);
        }
    }
}

public class ThreadLocalTest {
    public static void main(String[] args) {
        Account at = new Account("��ʼ��");
        new MyTest(at, "�̼߳�").start();
        new MyTest(at, "�߳���").start();
    }
}
