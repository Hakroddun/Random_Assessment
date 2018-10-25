package com.blackswan.assessment.user.list;

import com.blackswan.assessment.entity.User;

import java.util.List;

public class ListUserTransaction
{
    private ListUserGatewayInterface gateway;

    public List<User> listUsers()
    {
       return gateway.listUsers();
    }

    public void setGateway(ListUserGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
