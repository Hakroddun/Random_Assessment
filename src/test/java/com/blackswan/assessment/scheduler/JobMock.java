package com.blackswan.assessment.scheduler;

import com.blackswan.assessment.scheculedJob.JobInterface;

public class JobMock implements JobInterface
{
    private boolean taskExecuted = false;

    @Override
    public void execute()
    {
        taskExecuted = true;
    }

    public boolean isTaskExecuted()
    {
        return taskExecuted;
    }
}
