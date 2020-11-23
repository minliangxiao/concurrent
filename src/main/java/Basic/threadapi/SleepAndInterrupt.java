package Basic.threadapi;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 建议使用TimeUnit代替Thread.sleep方法
 */
@Slf4j(topic = "c.SleepAndInterrupt")
public class SleepAndInterrupt {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread("t1") {
            @Override
            public void run() {
                log.debug("enter  sleep.....");
                try {
                    /*用TimeUnit代替sleep方法可读性要好一些*/
                    TimeUnit.SECONDS.sleep(2);
                } catch (InterruptedException e) {
                    log.debug("wake up。。。");
                    e.printStackTrace();
                }
            }
        };
        t1.start();

        Thread.sleep(1000);
        log.debug("interrupt。。。。。");
        /*interrupt方法能够使得 sleep()的线程抛出一个interrupt异常*/
        t1.interrupt();
    }
}
