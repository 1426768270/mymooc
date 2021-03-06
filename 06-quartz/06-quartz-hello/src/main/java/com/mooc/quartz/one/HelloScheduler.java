package com.mooc.quartz.one;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 任务调度类
 * @Author       LQ
 * @CreateDate   2020/7/4 17:17
 * @Version      1.0
 */
public class HelloScheduler {

    public static void main(String[] args) throws SchedulerException {

        // 创建一个 JobDetail 实例，将该实例与 HelloJob 实例绑定
        JobDetail jobDetail=JobBuilder.newJob(HelloJob.class)
                .withIdentity("myjob","jobgroup1")// 定义标识符
                .build();

        System.out.println("jobDetail's name : " + jobDetail.getKey().getName());
        System.out.println("jobDetail's group : " + jobDetail.getKey().getGroup());
        System.out.println("jobDetail's jobClass : " + jobDetail.getJobClass().getName());

        // 创建一个 Trigger 实例，定义该 job 立即执行，并且每隔两秒重复执行一次，直到永远
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger","trigroup1")// 定义标识符
                .startNow()// 定义立即执行
                .withSchedule(SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(2)
                        .repeatForever())// 定义执行频度
                .build();

        // 创建 Scheduler 实例
        SchedulerFactory sfact = new StdSchedulerFactory();
        Scheduler scheduler = sfact.getScheduler();

        // 绑定 JobDetail 和 trigger
        scheduler.scheduleJob(jobDetail, trigger);

        // 执行任务
        scheduler.start();

        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Current Time Is : " + sf.format(date));

    }
}
