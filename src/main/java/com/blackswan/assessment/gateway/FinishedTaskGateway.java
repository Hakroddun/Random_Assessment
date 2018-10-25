package com.blackswan.assessment.gateway;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.scheculedJob.FinishedTaskGatewayInterface;

import java.util.List;

public class FinishedTaskGateway implements FinishedTaskGatewayInterface
{
    @Override
    public List<Task> getFinishedTasks()
    {
        return null;
    }

    @Override
    public void updateFinishedTasks(List<Task> tasksToUpdate)
    {

    }
}
