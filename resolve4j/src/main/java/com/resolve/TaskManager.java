package com.resolve;

import com.resolve.alltasks.AllTasks;
import com.resolve.assignedtasks.AssignedTasks;
import com.resolve.alltasks.AllTasksRepo;
import com.resolve.assignedtasks.AssignedTasksRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskManager {
    private static final Logger log = LogManager.getRootLogger();


    @Autowired
    AssignedTasksRepo repo2;

    @Autowired
    AllTasksRepo repo;

    @Autowired
    Utilities utilities;


    public void assignTask(AllTasks task){
        repo2.save(new AssignedTasks("OPEN", task.getTask(),task.getExp(), task.getStrengthExp(), task.getIntelligenceExp(), task.getConstitutionExp(), task.getDexterityExp(), LocalDateTime.now(), LocalDateTime.now().plusDays((long)task.getTimeLimit()), null));
        AllTasks update = utilities.getAllTask(task.getId());
        update.setLastAssigned(LocalDateTime.now());
        repo.save(update);
        log.info("Assigned task " + task.getTask());

    }

    public void completeTask(AssignedTasks task){
        AssignedTasks update = repo2.getOne(task.getId());
        update.setStatus("Complete");
        update.setCompleted(LocalDateTime.now());
        repo2.save(update);
        log.info("Task " + task.getTask() + " completed. " + task.getExp() + " exp awarded.");

    }

    public void missedDeadline(AssignedTasks task){
        AssignedTasks update = repo2.getOne(task.getId());
        update.setStatus("Missed");
        update.setCompleted(null);
        repo2.save(update);
        log.info("Expired task " + task.getTask() + ". " + (int)(task.getExp()*.5) + " exp lost!");
    }

//     public void completeMissedAssigned(AssignedTasks task){
//        AssignedTasks update = repo2.getOne(task.getId());
//        update.setStatus("Completed/Missed");
//        update.setCompleted(LocalDateTime.now());
//        repo2.save(update);
//        log.info("Missed Task " + task.getTask() + " completed. " + (int)(task.getExp()*.5) + " exp awarded.");
//    }

}
