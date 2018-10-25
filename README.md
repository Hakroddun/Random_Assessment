# BlackSwan_Assessment
Assessment for bs-mid-to-senior-java-dev position at blackswan.

Assumptions:
The API's for create/update/delete does not have to send back an object with data once done.
The API calls supplied would be the only data that would have to be updated.
The Task object being sent back or printed out would have to contain all data.
The system might have to modified in the future, so certain methods would have only a method call ie. certain transactions.

Below follows a list of calls that can be run in Intelij Terminal (they have been modified to work):
Create user  
curl -i -H "Content-Type: application/json" -X POST -d "{\"username\":\"jsmith\",\"first_name\" : \"John\", \"last_name\" : \"Smith\"}" http://localhost:8080/api/user

Update user  
curl -i -H "Content-Type: application/json" -X PUT -d "{\"first_name\" : \"John\", \"last_name\" : \"Doe\"}" http://localhost:8080/api/user/{id}

List all users  
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user

Get User info  
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/{id}

Create Task  
curl -i -H "Content-Type: application/json" -X POST -d "{\"name\":\"My task\",\"description\" : \"Description of task\", \"date_time\" : \"2016-05-25 14:25:00\"}" http://localhost:8080/api/user/{user_id}/task

Update Task  
curl -i -H "Content-Type: application/json" -X PUT -d "{\"name\":\"My updated task\"}" http://localhost:8080/api/user/{user_id}/task/{task_id}

Delete Task  
curl -i -H "Content-Type: application/json" -X DELETE http://localhost:8080/api/user/{user_id}/task/{task_id}

Get Task Info  
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/{user_id}/task/{task_id}

List all tasks for a user  
curl -i -H "Accept: application/json" -H "Content-Type: application/json" -X GET http://localhost:8080/api/user/{user_id}/task
