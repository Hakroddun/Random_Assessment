package com.blackswan.assessment.task.list;

import com.blackswan.assessment.entity.Task;

import java.util.List;

public class ListTaskTransaction
{
    private ListTaskGatewayInterface gateway;

    public List<Task> listTasks(int userID)
    {
       return gateway.listTasks(userID);
    }

    public void setGateway(ListTaskGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
