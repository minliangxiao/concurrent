package Basic.threadapi;

import lombok.extern.slf4j.Slf4j;

/**
 * yield事列
 */
@Slf4j(topic = "c.ThreadYield")
public class ThreadYield {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            int count = 0;
            for (; ; ) {
                System.out.println("----->1  " + count++);
            }
        },"t1");
        Thread t2 = new Thread(() -> {
            int count = 0;
            for (;  ; ) {
                /*yield() 能让当前线程进入就绪状态*/
//                Thread.yield();
                System.out.println("           ---------->2  " +count++);
            }
        },"t2");
        /*设置优先级*/
        t1.setPriority(Thread.MAX_PRIORITY);
        t2.setPriority(Thread.MIN_PRIORITY);
        t1.start();
        t2.start();
    }
}
