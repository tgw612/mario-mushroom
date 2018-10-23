package creazyjava.company;

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
public class JoinThread extends Thread {
    // �ṩһ���в����Ĺ��������������ø��̵߳�����
    public JoinThread(String name) {
        super(name);
    }

    // ��дrun()�����������߳�ִ����
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName() + "  " + i);
        }
    }

    public static void main(String[] args) throws Exception {
        // �������߳�
        new JoinThread("���߳�").start();
        for (int i = 0; i < 100; i++) {
            if (i == 20) {
                JoinThread jt = new JoinThread("��Join���߳�");
                jt.start();
                // main�̵߳�����jt�̵߳�join()������main�̱߳����jtִ�н����Ż�����ִ��
                jt.join();
            }
            System.out.println(Thread.currentThread().getName()
                    + "  " + i);
        }
    }
}
