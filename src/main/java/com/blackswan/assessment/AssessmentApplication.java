package com.blackswan.assessment;

import com.blackswan.assessment.gateway.FinishedTaskGateway;
import com.blackswan.assessment.scheculedJob.Scheduler;
import com.blackswan.assessment.scheculedJob.TaskChecker;
import com.blackswan.assessment.util.DatabaseHelper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AssessmentApplication
{

	public static void main(String[] args)
    {
		SpringApplication.run(AssessmentApplication.class, args);
		SetupDatabase();
        StartSchedulerJob();
	}

    private static void SetupDatabase()
    {
        DatabaseHelper.createTables();

        //Populates the Tables with Dummy data
        DatabaseHelper.populateTables();
    }

    private static void StartSchedulerJob()
    {
        //Creates a scheduler that runs at certain intervals.
        Scheduler scheduler = new Scheduler();
        //Creates the task that will be run at intervals to change check task for a pending status, confirm that the date_time has passed
        //and then print out the task and then update the database to show that the task status is done.
        TaskChecker task = new TaskChecker();
        FinishedTaskGateway gateway = new FinishedTaskGateway();
        task.setGateway(gateway);
        scheduler.setTaskToRun(task);
        scheduler.startScheduler(300);
    }
}
