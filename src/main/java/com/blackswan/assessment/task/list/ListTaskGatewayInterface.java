package com.blackswan.assessment.task.list;

import com.blackswan.assessment.entity.Task;

import java.util.List;

public interface ListTaskGatewayInterface
{
    List<Task> listTasks(int userID);
}
