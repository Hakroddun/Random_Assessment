package com.blackswan.assessment.scheculedJob;

import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Scheduler
{
    JobInterface taskToRun;
    public void startScheduler(int frequencyToRunSchedule)
    {
        TimerTask scheduledTaskTimer = new TimerTask()
        {
            public void run()
            {
                taskToRun.execute();
            }

        };
        ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
        service.scheduleAtFixedRate(scheduledTaskTimer, 0, frequencyToRunSchedule, TimeUnit.SECONDS);
    }

    public JobInterface getTaskToRun()
    {
        return taskToRun;
    }

    public void setTaskToRun(JobInterface taskToRun)
    {
        this.taskToRun = taskToRun;
    }
}
