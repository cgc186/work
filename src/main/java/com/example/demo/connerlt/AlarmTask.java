package com.example.demo.connerlt;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
@EnableScheduling
public class AlarmTask {

    /**
     * 定义执行线程启动的开关
     * @throws InterruptedException
     */
    @Scheduled(cron = "0/5 * * * * *")
    public void run()throws InterruptedException{
        //休眠6s,再执行
        Thread.sleep(6000);
        System.out.print(Thread.currentThread().getName()+"======>使用时间:"+(System.currentTimeMillis()/1000));
    }
    /**
     *  对上一次执行时间之后再执行的时间
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 5000)
    public void run1()throws InterruptedException{
        Thread.sleep(7000);
        System.out.print(Thread.currentThread().getName()+"======>使用时间:"+(System.currentTimeMillis()/1000));
    }

    private static final SimpleDateFormat format=new SimpleDateFormat("HH:mm:ss");
    //每次执行完2s后再执行
    @Scheduled(fixedDelayString = "3000")
    public void run2() throws InterruptedException{
        //Thread.sleep(5000);
        System.out.println("fixedDelayString的时间为:"+format.format(new Date()));
    }
    //延时1s,每隔2s
    @Scheduled(fixedRateString = "2000",initialDelay = 1000)
    public void run3() throws InterruptedException{
        System.out.println("每隔2s并且延时1s,再执行:" + format.format(new Date()));
    }

}
