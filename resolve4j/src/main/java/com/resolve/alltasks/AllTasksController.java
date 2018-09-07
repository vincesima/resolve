package com.resolve.alltasks;

import com.resolve.TaskManager;
import com.resolve.Utilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://vincesima.com", "http://www.vincesima.com", "http://localhost:8100"})
public class AllTasksController {

    @Autowired
    Utilities utilities;

    @Autowired
    TaskManager manager;

    @Autowired
    AllTasksRepo repo;


    @GetMapping(path = "/alltasks")
    public List<AllTasks> getAll(){
        return repo.findAll();
    }

    @PostMapping(path = "/alltasks/assign/{id}")
    public void assignTask(@PathVariable Long id){
        AllTasks task = repo.getOne(id);
        manager.assignTask(task);
    }

    @PostMapping(path = "/alltasks", consumes = "application/json", produces = "application/json")
    public void addTask(@RequestBody AllTasks task) {
        repo.save(task);
    }

    @DeleteMapping(path = "/alltasks/{id}")
    public void deleteTask(@PathVariable Long id){
        repo.deleteById(id);
    }
}
