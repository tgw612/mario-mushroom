package concurrent;

import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * Created by tgw61 on 2017/7/20.
 */
public class MultiThread {
    public static void main(String[] args) {
        ThreadMXBean mx = ManagementFactory.getThreadMXBean();
        ThreadInfo[] infos = mx.dumpAllThreads(false, false);
        for (ThreadInfo info : infos) {
            System.out.println("[" + info.getThreadId() + "]" + info.getThreadName());
        }
    }
}
