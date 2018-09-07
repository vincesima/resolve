package com.resolve;


import com.resolve.alltasks.AllTasks;
import com.resolve.assignedtasks.AssignedTasks;
import com.resolve.book.Book;
import com.resolve.book.BookRepo;
import com.resolve.user.User;
import com.resolve.alltasks.AllTasksRepo;
import com.resolve.assignedtasks.AssignedTasksRepo;
import com.resolve.user.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Utilities {

    @Autowired
    UserRepo userRepo;

    @Autowired
    AllTasksRepo allTasksRepo;

    @Autowired
    AssignedTasksRepo assignedTasksRepo;

    @Autowired
    BookRepo bookRepo;

    public User getUser(long id){
        User found = null;
        for(User user : userRepo.findAll()){
            if(user.getId() == id){
                found =  user;
            }
        }
        return found;
    }

    public AssignedTasks getAssignedTask(long id){
        AssignedTasks found = null;
        for(AssignedTasks task : assignedTasksRepo.findAll()){
            if(task.getId() == id){
                found =  task;
            }
        }
        return found;
    }

    public AllTasks getAllTask(long id){
        AllTasks found = null;
        for(AllTasks task : allTasksRepo.findAll()){
            if(task.getId() == id){
                found =  task;
            }
        }
        return found;
    }

    public Book getBook(long id){
        Book found = null;
        for(Book book : bookRepo.findAll()){
            if(book.getId() == id){
                found = book;
            }
        }
        return found;
    }

}
