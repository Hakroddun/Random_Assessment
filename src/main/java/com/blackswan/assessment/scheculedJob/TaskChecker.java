package com.blackswan.assessment.scheculedJob;

import com.blackswan.assessment.entity.Task;

import java.util.List;

public class TaskChecker implements JobInterface
{
    private FinishedTaskGatewayInterface gateway;

    @Override
    public void execute()
    {
        List<Task> finishedTasks = gateway.getFinishedTasks();
        for (Task finishedTask : finishedTasks)
        {
            System.out.println(finishedTask.toString());
        }
        gateway.updateFinishedTasks(finishedTasks);
    }

    public void setGateway(FinishedTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
