package Basic.threadapi;

import lombok.extern.slf4j.Slf4j;

import static java.lang.Thread.sleep;

/**
 * 线程join()方法的实例，join是一个很实用的方法，能够实现线程同步它直接的功能是等待线程运行结束
 */
@Slf4j(topic = "c.ThreadJoin")
public class ThreadJoin {
    static int r=0;

    public static void main(String[] args) throws InterruptedException{
        test1();

    }
    public static void test1() throws InterruptedException {
        log.debug("开始");
        Thread t1 = new Thread(() -> {
            log.debug("{}开始" + Thread.currentThread().getName());
            try {
                sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("{}结束",Thread.currentThread().getName());
            r=10;
        }, "t1");
        t1.start();
        /*join() 就是等待线程结束*/
        t1.join();
        log.debug("结果为：{}" ,r);
        log.debug("结束");
    }
}
