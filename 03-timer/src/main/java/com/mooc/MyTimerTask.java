package com.mooc;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.TimerTask;

/**
 * 需定时调度的业务逻辑类
 * @Author       LQ
 * @CreateDate   2020/7/4 11:31
 * @Version      1.0
 */
public class MyTimerTask extends TimerTask {

    private String name;

    public MyTimerTask(String name){
        this.name=name;
    }

    @Override
    public void run() {
        // 以yyyy-MM-dd HH:mm:ss的格式打印当前执行时间
        // 如2016-11-11 00:00:00
        Calendar calendar = Calendar.getInstance();
        // 定义日期格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println("Task:");
        System.out.println("Current exec time is : " + simpleDateFormat.format(calendar.getTime()));

        // 打印当前 name 的内容
        System.out.println("Current exec name is : " + name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
