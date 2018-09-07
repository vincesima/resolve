package com.resolve.assignedtasks;

import com.resolve.TaskManager;
import com.resolve.UserManager;
import com.resolve.Utilities;
import com.resolve.alltasks.AllTasks;
import com.resolve.alltasks.AllTasksRepo;
import com.resolve.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin(origins = {"http://vincesima.com", "http://www.vincesima.com", "http://localhost:8100"})
public class AssignedTasksController {
    @Autowired
    TaskManager taskManager;

    @Autowired
    UserManager userManager;

    @Autowired
    Utilities utilities;

    @Autowired
    AssignedTasksRepo repo;

    @Autowired
    AllTasksRepo atRepo;




        @GetMapping(path = "/assignedtasks")
        public List<AssignedTasks> getAll(){
            return repo.findAll();
        }

        @GetMapping(path = "/assignedtasks/open")
        public List<AssignedTasks> getOpen(){
            ArrayList<AssignedTasks> list = new ArrayList<>();
            for(AssignedTasks task : repo.findAll()){
                if(task.getStatus().equals("OPEN")){
                    list.add(task);
                }
            }
            return list;
        }

        @GetMapping(path = "/assignedtasks/closed")
        public List<AssignedTasks> getComplete(){
            ArrayList<AssignedTasks> list = new ArrayList<>();
            for(AssignedTasks task : repo.findAll()){
                if(task.getStatus().equals("Complete")){
                    list.add(task);
                }
            }
            return list;
        }

        @PostMapping(path = "/assignedtasks", consumes = "application/json", produces = "application/json")
        public void addTask(@RequestBody AssignedTasks task) {
            repo.save(task);
        }

        @PostMapping(path = "/assignedtasks/complete/{id}")
        public void completeTask(@PathVariable Long id){
        User user = utilities.getUser(1);
        AssignedTasks task = repo.getOne(id);
        AllTasks reassign = null;
        for(AllTasks task0 : atRepo.findAll()){
            if(task0.getTask().equals(task.getTask())){
                reassign = task0;
            }
        }
        taskManager.completeTask(task);
        taskManager.assignTask(reassign);
        userManager.completeTask(user, task);
        }

        @PostMapping(path = "/assignedtasks/reassign/{id}")
        public void reassignTask(@PathVariable Long id){
        User user = utilities.getUser(1);
        AssignedTasks task = repo.getOne(id);
        taskManager.completeTask(task);
        userManager.completeTask(user, task);
    }

        @PostMapping(path = "/assignedtasks/expire/{id}")
        public void expireTask(@PathVariable Long id){
        User user = utilities.getUser(1);
        AssignedTasks task = repo.getOne(id);
        taskManager.missedDeadline(task);
        userManager.missedDeadline(user, task);
    }

    }

