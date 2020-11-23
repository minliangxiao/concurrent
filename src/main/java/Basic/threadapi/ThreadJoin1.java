package Basic.threadapi;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * join方法的加强案例，两个线程之间的同步
 *
 * 如果join(时间) 则参数时间表示最大等待的秒数，如果在这段时间内线程没有结束则不会在等待
 */
@Slf4j(topic = "c.ThreadJoin1")
public class ThreadJoin1 {
    static int r1 = 0;
    static int r2 = 0;

    public static void main(String[] args) throws InterruptedException {
        test2();
    }
    private static void test2() throws InterruptedException {
        Thread t1 = new Thread(() -> {
            try {
                sleep(1);
                r1 = 10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");

        Thread t2 = new Thread(() -> {
            try {
                sleep(2);
                r2 = 20;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t1.start();
        t2.start();
        long start = System.currentTimeMillis();
        log.debug("join begin ");
        t1.join();
        log.debug("t1  join end");
        t2.join();
        log.debug("t2 join end");
        long end = System.currentTimeMillis();
        log.debug("r1: {}  r2: {} cost: {}",r1,r2,end -start);
    }
}
