package com.blackswan.assessment.user.update;

import com.blackswan.assessment.entity.User;

public class UpdateUserTransaction
{
    UpdateUserGatewayInterface gateway;

    public void updateUser(int userID, User userDetails)
    {
        userDetails.id = userID;
        gateway.updateUser(userDetails);
    }

    public void setGateway(UpdateUserGatewayInterface gateway)
    {
        this.gateway = gateway;
    }
}
