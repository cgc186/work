package com.example.demo01.connerlt;

import com.example.demo01.dao.StuDao;
import com.google.gson.JsonElement;
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
    @Scheduled(cron ="0/5 * * * * *")  //每隔五分钟执行一次 秒 分 时 天 月
    public void run() throws InterruptedException {
        Thread.sleep(6000);
        System.out.println(Thread.currentThread().getName()
                +" ======>使用时间:"
                +(System.currentTimeMillis()/1000));
        //调用StuDao获得JSON信息,然后进行输出
        StuDao st = new StuDao();
        JsonElement je = st.stuList();
        System.out.println(je);
    }

    /**
     * 对上一次执行时间之后再执行的时间
     * @throws InterruptedException
     */
    @Scheduled(fixedRate = 5000)
    public void run1() throws InterruptedException {
        Thread.sleep(7000);
        System.out.println(Thread.currentThread().getName()
                +" ======>使用时间:"
                +(System.currentTimeMillis()/1000));
    }


    private static final SimpleDateFormat format =
            new SimpleDateFormat("HH:mm:ss");

    //每次执行完两秒后在执行
    @Scheduled(fixedDelayString = "2000")
    public void run2() throws InterruptedException {
        Thread.sleep(5000);
        System.out.println("fixedDelayString的时间为:"
                + format.format(new Date()));
    }

    //每次执行完两秒后在执行
    @Scheduled(fixedRateString  = "2000",initialDelay = 1000)
    public void run3() throws InterruptedException {
        System.out.println("每隔2秒并且延时1秒，再执行:"
                + format.format(new Date()));
    }
}
