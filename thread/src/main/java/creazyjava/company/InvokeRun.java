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
public class InvokeRun extends Thread {
    private int i;

    // ��дrun������run�����ķ���������߳�ִ����
    public void run() {
        for (; i < 100; i++) {
            // ֱ�ӵ���run����ʱ��Thread��this.getName���ص��Ǹö������֣�
            // �����ǵ�ǰ�̵߳����֡�
            // ʹ��Thread.currentThread().getName()���ǻ�ȡ��ǰ�߳�����
            System.out.println(Thread.currentThread().getName()
                    + " " + i);   // ��
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            // ����Thread��currentThread������ȡ��ǰ�߳�
            System.out.println(Thread.currentThread().getName()
                    + " " + i);
            if (i == 20) {
                // ֱ�ӵ����̶߳����run������
                // ϵͳ����̶߳��󵱳���ͨ����run����������ͨ������
                // �����������д��벢�������������̣߳���������ִ������run����
                new InvokeRun().run();
                new InvokeRun().run();
            }
        }
    }
}
