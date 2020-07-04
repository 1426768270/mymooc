package com.mooc.quartz.one;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 自定义任务
 * @Author       LQ
 * @CreateDate   2020/7/4 17:16
 * @Version      1.0
 */
public class HelloJob implements Job {


    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        // 打印当前的执行时间，格式为2017-01-01 00:00:00
        Date date = new Date();
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("---------------Tast---------------");
        System.out.println("Current Exec Time Is : " + sf.format(date));

        // 编写具体的业务逻辑
        System.out.println("Hello World!");
    }
}
