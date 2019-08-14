package com.xiafei.performance.testing.logs.writer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/10 17:04</P>
 * <P>UPDATE AT: 2019/1/10 17:04</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
public class LogWriter {

    private static final Logger log = LoggerFactory.getLogger(LogWriter.class);

    public long write(int threads,final int everyThreadTimes) throws InterruptedException {
        long start = System.currentTimeMillis();
        final CountDownLatch latch = new CountDownLatch(threads);
        for (int i = 0; i < threads; i++) {
            new Thread(new Runnable() {

                public void run() {
                    for (int i = 0; i < everyThreadTimes; i++) {
                        log.info("一段不长不短的话，带上点儿格式化={}", "格式化就是我");
                    }
                    latch.countDown();
                }
            }).start();
        }

        latch.await();
        return System.currentTimeMillis() - start;
    }


}
