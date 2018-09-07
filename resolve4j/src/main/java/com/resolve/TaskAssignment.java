package com.resolve;

//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.scheduling.annotation.Scheduled;
//import org.springframework.stereotype.Component;
//
//import java.time.LocalDateTime;
//
//
//@Component
//public class TaskAssignment {
//
//    @Autowired
//    AllTasksRepo all;
//
//    @Autowired
//    TaskManager manager;
//
//
//    @Scheduled(fixedRate = 3600000)
//    public void scheduleTasks(){
//        for(AllTasks task : all.findAll()){
//            if(task.getLastAssigned().plusDays(task.getFrequency()).isBefore(LocalDateTime.now())){
//                manager.assignTask(task);
//            }
//        }
//    }
//
//}
