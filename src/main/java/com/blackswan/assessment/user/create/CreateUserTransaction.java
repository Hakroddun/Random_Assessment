package com.blackswan.assessment.user.create;

import com.blackswan.assessment.entity.User;

public class CreateUserTransaction
{
    CreateUserGatewayInterface gateway;

    public void createUser(User userDetails)
    {
        gateway.createUser(userDetails);
    }

    public void setGateway(CreateUserGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
