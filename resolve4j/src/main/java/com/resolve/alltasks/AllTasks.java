package com.resolve.alltasks;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Proxy(lazy=false)
public class AllTasks {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    @Column
    private String task;
    private int totalExp;
    private int strengthExp;
    private int intelligenceExp;
    private int constitutionExp;
    private int dexterityExp;
    private int frequency; //per week
    private int timeLimit; //days
    private int timesCompleted;
    private int timesMissed;
    private LocalDateTime lastAssigned;

    public AllTasks() {
    }

    public AllTasks(long id, String task, int strengthExp, int intelligenceExp, int constitutionExp, int dexterityExp, int frequency, int timeLimit, int timesCompleted, int timesMissed, LocalDateTime lastAssigned) {
        this.id = id;
        this.task = task;
        this.strengthExp = strengthExp;
        this.intelligenceExp = intelligenceExp;
        this.constitutionExp = constitutionExp;
        this.dexterityExp = dexterityExp;
        this.frequency = frequency;
        this.timeLimit = timeLimit;
        this.timesCompleted = timesCompleted;
        this.timesMissed = timesMissed;
        this.lastAssigned = lastAssigned;
    }

    public int getStrengthExp() {
        return strengthExp;
    }

    public void setStrengthExp(int strengthExp) {
        this.strengthExp = strengthExp;
    }

    public int getIntelligenceExp() {
        return intelligenceExp;
    }

    public void setIntelligenceExp(int intelligenceExp) {
        this.intelligenceExp = intelligenceExp;
    }

    public int getConstitutionExp() {
        return constitutionExp;
    }

    public void setConstitutionExp(int constitutionExp) {
        this.constitutionExp = constitutionExp;
    }

    public int getDexterityExp() {
        return dexterityExp;
    }

    public void setDexterityExp(int dexterityExp) {
        this.dexterityExp = dexterityExp;
    }

    public LocalDateTime getLastAssigned() {
        return lastAssigned;
    }

    public void setLastAssigned(LocalDateTime lastAssigned) {
        this.lastAssigned = lastAssigned;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTask() {
        return task;
    }

    public void setTask(String task) {
        this.task = task;
    }

    public int getExp() {
        return totalExp;
    }

    public void setExp(int exp) {
        this.totalExp = exp;
    }

    public int getFrequency() {
        return frequency;
    }

    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public int getTimesCompleted() {
        return timesCompleted;
    }

    public void setTimesCompleted(int timesCompleted) {
        this.timesCompleted = timesCompleted;
    }

    public int getTimesMissed() {
        return timesMissed;
    }

    public void setTimesMissed(int timesMissed) {
        this.timesMissed = timesMissed;
    }
}
