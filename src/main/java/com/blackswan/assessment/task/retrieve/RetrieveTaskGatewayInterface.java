package com.blackswan.assessment.task.retrieve;

import com.blackswan.assessment.entity.Task;

public interface RetrieveTaskGatewayInterface
{
    Task retrieveTask(int userID, int taskID);
}
