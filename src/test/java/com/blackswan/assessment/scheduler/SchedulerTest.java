package com.blackswan.assessment.scheduler;

import com.blackswan.assessment.scheculedJob.Scheduler;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

public class SchedulerTest
{
    @Test
    public void RunScheduledJob() throws InterruptedException, IOException
    {
        Scheduler scheduler = new Scheduler();
        JobMock taskMock = new JobMock();
        scheduler.setTaskToRun(taskMock);
        scheduler.startScheduler(1);
        Thread.sleep(1000);
        Assert.assertTrue(taskMock.isTaskExecuted());
    }
}
