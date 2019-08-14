package com.xiafei.performance.testing.logs.log4j;

import com.xiafei.performance.testing.logs.writer.LogWriter;

/**
 * <P>Description: . </P>
 * <P>CALLED BY:   齐霞飞 </P>
 * <P>UPDATE BY:   齐霞飞 </P>
 * <P>CREATE AT: 2019/1/10 17:19</P>
 * <P>UPDATE AT: 2019/1/10 17:19</P>
 *
 * @author 齐霞飞
 * @version 1.0
 * @since java 1.8.0
 */
public class Starter {

    public static void main(String[] args) throws InterruptedException {
        LogWriter logWriter = new LogWriter();
        int threads = 100;
        int everyThreadTimes = 10000;
        System.out.println("log4j同步打印" + (threads * everyThreadTimes) + "条日志");
        for (int i = 0; i < 10; i++) {

            long elpase = logWriter.write(threads, everyThreadTimes);
            System.out.println((i + 1) + "、" + elpase);
        }
    }
}
