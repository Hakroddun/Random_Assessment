package com.blackswan.assessment.scheculedJob;

import com.blackswan.assessment.entity.Task;

import java.util.List;

public interface FinishedTaskGatewayInterface
{
    List<Task> getFinishedTasks();
    void updateFinishedTasks(List<Task> tasksToUpdate);
}
