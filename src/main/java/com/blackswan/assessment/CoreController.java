package com.blackswan.assessment;

import com.blackswan.assessment.entity.Task;
import com.blackswan.assessment.entity.User;
import com.blackswan.assessment.gateway.task.CreateTaskGateway;
import com.blackswan.assessment.gateway.task.DeleteTaskGateway;
import com.blackswan.assessment.gateway.task.ListTaskGateway;
import com.blackswan.assessment.gateway.task.UpdateTaskGateway;
import com.blackswan.assessment.gateway.user.CreateUserGateway;
import com.blackswan.assessment.gateway.user.ListUserGateway;
import com.blackswan.assessment.gateway.user.RetrieveUserGateway;
import com.blackswan.assessment.gateway.user.UpdateUserGateway;
import com.blackswan.assessment.task.create.CreateTaskTransaction;
import com.blackswan.assessment.task.delete.DeleteTaskTransaction;
import com.blackswan.assessment.task.list.ListTaskTransaction;
import com.blackswan.assessment.task.update.UpdateTaskTransaction;
import com.blackswan.assessment.user.create.CreateUserTransaction;
import com.blackswan.assessment.user.list.ListUserTransaction;
import com.blackswan.assessment.user.retrieve.RetrieveUserTransaction;
import com.blackswan.assessment.user.update.UpdateUserTransaction;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CoreController
{
    //Create user
    @PostMapping(value = "/api/user", consumes = "application/json", produces = "application/json")
    public void createUser(@RequestBody User userData)
    {
        CreateUserGateway gateway = new CreateUserGateway();
        CreateUserTransaction transaction = new CreateUserTransaction();
        transaction.setGateway(gateway);
        transaction.createUser(userData);
    }

    //Update user
    @PutMapping(value = "/api/user/{user_id}", consumes = "application/json", produces = "application/json")
    public void updateUser(@PathVariable("user_id") int userID, @RequestBody User userData)
    {
        UpdateUserGateway gateway = new UpdateUserGateway();
        UpdateUserTransaction transaction = new UpdateUserTransaction();
        transaction.setGateway(gateway);
        transaction.updateUser(userID,userData);
    }

    //List users
    @GetMapping(value = "/api/user", produces = "application/json")
    public List<User> listUsers()
    {
        ListUserGateway gateway = new ListUserGateway();
        ListUserTransaction transaction = new ListUserTransaction();
        transaction.setGateway(gateway);
        return transaction.listUsers();
    }

    //Retrieve user
    @GetMapping(value = "/api/user/{user_id}", produces = "application/json")
    public User retrieveUser(@PathVariable("user_id") int userID)
    {
        RetrieveUserGateway gateway = new RetrieveUserGateway();
        RetrieveUserTransaction transaction = new RetrieveUserTransaction();
        transaction.setGateway(gateway);
        return transaction.retrieveUser(userID);
    }

    //Create task for a user
    @PostMapping(value = "/api/user/{user_id}/task", consumes = "application/json", produces = "application/json")
    public void createTask(@PathVariable("user_id") int userID, @RequestBody Task taskData)
    {
        CreateTaskGateway gateway = new CreateTaskGateway();
        CreateTaskTransaction transaction = new CreateTaskTransaction();
        transaction.setGateway(gateway);
        transaction.createTask(userID,taskData);
    }

    //Update task for a user
    @PutMapping(value = "/api/user/{user_id}/task/{task_id}", consumes = "application/json", produces = "application/json")
    public void updateTask(@PathVariable("user_id") int userID, @PathVariable("task_id") int taskID, @RequestBody Task taskData)
    {
        UpdateTaskGateway gateway = new UpdateTaskGateway();
        UpdateTaskTransaction transaction = new UpdateTaskTransaction();
        transaction.setGateway(gateway);
        transaction.updateTask(userID,taskID,taskData);
    }

    //Delete task for a user
    @DeleteMapping(value = "/api/user/{user_id}/task/{task_id}",  produces = "application/json")
    public void deleteTask(@PathVariable("user_id") int userID, @PathVariable("task_id") int taskID)
    {
        DeleteTaskGateway gateway = new DeleteTaskGateway();
        DeleteTaskTransaction transaction = new DeleteTaskTransaction();
        transaction.setGateway(gateway);
    }

    //Get info for a task
    @GetMapping(value = "/api/user/{user_id}/task/{task_id}", produces = "application/json")
    public Task retrieveTaskInfo(@PathVariable("user_id") int userID, @PathVariable("task_id") int taskID)
    {
        return null;
    }

    //Get all tasks for a user
    @GetMapping(value = "/api/user/{user_id}/task", produces = "application/json")
    public List<Task> listTasksOfUser(@PathVariable("user_id") int userID)
    {
        ListTaskGateway gateway = new ListTaskGateway();
        ListTaskTransaction transaction = new ListTaskTransaction();
        transaction.setGateway(gateway);
        return transaction.listTasks(userID);
    }

}
