package com.resolve;

import com.resolve.assignedtasks.AssignedTasks;
import com.resolve.user.User;
import com.resolve.user.UserRepo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;


@Component
public class UserManager {
    private static final Logger log = LogManager.getRootLogger();

    @Autowired
    Utilities utilities;

    @Autowired
    UserRepo repo;

        public void completeTask(User user0, AssignedTasks task0){
            User user = utilities.getUser(user0.getId());
            AssignedTasks task = utilities.getAssignedTask(task0.getId());
            setExp(user, task,1);
            checkForLevelUp(user, task);
            checkForStrengthLevelUp(user, task);
            checkForIntelligenceLevelUp(user, task);
            checkForConstitutionLevelUp(user, task);
            checkForDexterityLevelUp(user, task);
            user.setTasksCompleted(user.getTasksCompleted()+1);
            repo.save(user);
        }


        public void missedDeadline(User user0, AssignedTasks task0){
            User user = utilities.getUser(user0.getId());
            AssignedTasks task = utilities.getAssignedTask(task0.getId());
            setExp(user, task, -.5);
            checkForZeroExp(user, task);
            checkForStrengthZeroExp(user, task);
            checkForIntelligenceZeroExp(user, task);
            checkForConstitutionZeroExp(user, task);
            checkForDexterityZeroExp(user, task);
            user.setTasksMissed(user.getTasksMissed()+1);
            repo.save(user);
        }

//    public void completeMissedTask(User user0, AssignedTasks task0){
//        User user = utilities.getUser(user0.getId());
//        AssignedTasks task = utilities.getAssignedTask(task0.getId());
//        user.setTotalExp(user.getTotalExp() + (int)(task.getExp()*.5));
//        user.setTasksCompleted(user.getTasksCompleted()+1);
//        if((user.getTotalExpForNextLevelUp() - user.getExpThisLevel()) > (int)(task.getExp()*.5)) {
//            user.setExpThisLevel(user.getExpThisLevel() + (int)(task.getExp()*.5));
//        } else {
//            int remainder = user.getTotalExpForNextLevelUp()-user.getExpThisLevel();
//            user.setLevel(user.getLevel()+1);
//            user.setTotalExpForNextLevelUp(roundExp((int)(user.getTotalExpForNextLevelUp()*1.2)));
//            user.setExpThisLevel((user.getExpThisLevel())-((int)(task.getExp()*.5)-remainder));
//            log.info("Level Up! You are now Level " + user.getLevel());
//        }
//        repo.save(user);
//    }

    public void setExp(User user, AssignedTasks task, double mod){
        user.setTotalExp(user.getTotalExp()+(int)(task.getExp()*mod));
        user.setStrengthExp(user.getStrengthExp()+(int)(task.getStrengthExp()*mod));
        user.setIntelligenceExp(user.getIntelligenceExp()+(int)(task.getIntelligenceExp()*mod));
        user.setConstitutionExp(user.getConstitutionExp() + (int)(task.getConstitutionExp()*mod));
        user.setDexterityExp(user.getDexterityExp()+(int)(task.getDexterityExp()*mod));

    }

    public void checkForLevelUp(User user, AssignedTasks task){
        if((user.getTotalExpForNextLevelUp() - user.getExpThisLevel()) > task.getExp()) {
            user.setExpThisLevel(user.getExpThisLevel() + task.getExp());
        } else {
            int remainder = user.getTotalExpForNextLevelUp()-user.getExpThisLevel();
            user.setLevel(user.getLevel()+1);
            user.setExpThisLevel(task.getExp()-remainder);
            user.setTotalExpForNextLevelUp(roundExp((int)(user.getTotalExpForNextLevelUp()*1.2)));
            log.info("Level Up! You are now Level " + user.getLevel());
        }
    }

    public void checkForZeroExp(User user, AssignedTasks task){
        if((user.getExpThisLevel()) > (int)(task.getExp()*.5)) {
            user.setExpThisLevel(user.getExpThisLevel() - (int)(task.getExp()*.5));
        } else {
            user.setExpThisLevel(0);
        }
    }

    public void checkForStrengthLevelUp(User user, AssignedTasks task){
        if((user.getStrengthExpForNextLevelUp() - user.getStrengthExpThisLevel()) > task.getStrengthExp()) {
            user.setStrengthExpThisLevel(user.getStrengthExpThisLevel() + task.getStrengthExp());
        } else {
            int remainder = user.getStrengthExpForNextLevelUp()-user.getStrengthExpThisLevel();
            user.setStrengthLevel(user.getStrengthLevel()+1);
            user.setStrengthExpThisLevel(task.getStrengthExp()-remainder);
            user.setStrengthExpForNextLevelUp(roundExp((int)(user.getStrengthExpForNextLevelUp()*1.2)));
            log.info("Strength Level Up! You are now Level " + user.getStrengthLevel());
        }
    }

    public void checkForStrengthZeroExp(User user, AssignedTasks task){
        if((user.getStrengthExpThisLevel()) > (int)(task.getStrengthExp()*.5)) {
            user.setStrengthExpThisLevel(user.getStrengthExpThisLevel() - (int)(task.getStrengthExp()*.5));
        } else {
            user.setStrengthExpThisLevel(0);
        }
    }

    public void checkForIntelligenceLevelUp(User user, AssignedTasks task){
        if((user.getIntelligenceExpForNextLevelUp() - user.getIntelligenceExpThisLevel()) > task.getIntelligenceExp()) {
            user.setIntelligenceExpThisLevel(user.getIntelligenceExpThisLevel() + task.getIntelligenceExp());
        } else {
            int remainder = user.getIntelligenceExpForNextLevelUp()-user.getIntelligenceExpThisLevel();
            user.setIntelligenceLevel(user.getIntelligenceLevel()+1);
            user.setIntelligenceExpThisLevel(task.getIntelligenceExp()-remainder);
            user.setIntelligenceExpForNextLevelUp(roundExp((int)(user.getIntelligenceExpForNextLevelUp()*1.2)));
            log.info("Intelligence Level Up! You are now Level " + user.getIntelligenceLevel());
        }
    }

    public void checkForIntelligenceZeroExp(User user, AssignedTasks task){
        if((user.getIntelligenceExpThisLevel()) > (int)(task.getIntelligenceExp()*.5)) {
            user.setIntelligenceExpThisLevel(user.getIntelligenceExpThisLevel() - (int)(task.getIntelligenceExp()*.5));
        } else {
            user.setIntelligenceExpThisLevel(0);
        }
    }

    public void checkForConstitutionLevelUp(User user, AssignedTasks task){
        if((user.getConstitutionExpForNextLevelUp() - user.getConstitutionExpThisLevel()) > task.getConstitutionExp()) {
            user.setConstitutionExpThisLevel(user.getConstitutionExpThisLevel() + task.getConstitutionExp());
        } else {
            int remainder = user.getConstitutionExpForNextLevelUp()-user.getConstitutionExpThisLevel();
            user.setConstitutionLevel(user.getConstitutionLevel()+1);
            user.setConstitutionExpThisLevel(task.getConstitutionExp()-remainder);
            user.setConstitutionExpForNextLevelUp(roundExp((int)(user.getConstitutionExpForNextLevelUp()*1.2)));
            log.info("Constitution Level Up! You are now Level " + user.getConstitutionLevel());
        }
    }

    public void checkForConstitutionZeroExp(User user, AssignedTasks task){
        if((user.getConstitutionExpThisLevel()) > (int)(task.getConstitutionExp()*.5)) {
            user.setConstitutionExpThisLevel(user.getConstitutionExpThisLevel() - (int)(task.getConstitutionExp()*.5));
        } else {
            user.setConstitutionExpThisLevel(0);
        }
    }

    public void checkForDexterityLevelUp(User user, AssignedTasks task){
        if((user.getDexterityExpForNextLevelUp() - user.getDexterityExpThisLevel()) > task.getDexterityExp()) {
            user.setDexterityExpThisLevel(user.getDexterityExpThisLevel() + task.getDexterityExp());
        } else {
            int remainder = user.getDexterityExpForNextLevelUp()-user.getDexterityExpThisLevel();
            user.setDexterityLevel(user.getDexterityLevel()+1);
            user.setDexterityExpThisLevel(task.getDexterityExp()-remainder);
            user.setDexterityExpForNextLevelUp(roundExp((int)(user.getDexterityExpForNextLevelUp()*1.2)));
            log.info("Dexterity Level Up! You are now Level " + user.getDexterityLevel());
        }
    }

    public void checkForDexterityZeroExp(User user, AssignedTasks task){
        if((user.getDexterityExpThisLevel()) > (int)(task.getDexterityExp()*.5)) {
            user.setDexterityExpThisLevel(user.getDexterityExpThisLevel() - (int)(task.getDexterityExp()*.5));
        } else {
            user.setDexterityExpThisLevel(0);
        }
    }

    public int roundExp(int num){
        return ((num+25)/25)*25;
    }


}
