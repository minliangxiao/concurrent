package Basic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * futureTask的使用案例
 */
@Slf4j(topic = "c.FutureTaskTest")
public class FutureTaskTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(new Callable() {
            public Object call() throws Exception {
                log.debug("runing..");
                Thread.sleep(1000);
                return 100;
            }
        });
        Thread t =new Thread(task,"t1");
        t.start();
        // FutureTask对象的get() 方法是阻塞等待返回对象
        log.debug("{}",task.get());
    }
}
