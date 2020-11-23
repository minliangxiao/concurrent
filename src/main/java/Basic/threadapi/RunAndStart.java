package Basic.threadapi;

import lombok.extern.slf4j.Slf4j;

@Slf4j(topic = "c.RunAndStart")
public class RunAndStart {
    public static void main(String[] args) {
        Thread t1 = new Thread() {
            @Override
            public void run() {
                log.debug("running");
            }
        };
        t1.setName("t1");
        t1.run();
        /*注意start()不能被多次调用  Thread.getState()能够获取线程的状态*/
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
    }
}
