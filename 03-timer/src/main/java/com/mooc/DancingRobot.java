package com.mooc;

import java.text.SimpleDateFormat;
import java.util.TimerTask;

/**
 * 跳舞机器人
 * @Author       LQ
 * @CreateDate   2020/7/4 13:26
 * @Version      1.0
 */
public class DancingRobot extends TimerTask {
    @Override
    public void run() {
        // 获取最近的一次任务执行的时间并将其格式化
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.print("Schduled exec time is : " + sf.format(scheduledExecutionTime()));

        System.out.println("Dancing happily!");
    }
}
