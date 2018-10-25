package com.blackswan.assessment.user.retrieve;

import com.blackswan.assessment.entity.User;


public class RetrieveUserTransaction
{
    RetrieveUserGatewayInterface gateway;

    public User retrieveUser(int userID)
    {
        return gateway.retrieveUser(userID);
    }

    public void setGateway(RetrieveUserGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
