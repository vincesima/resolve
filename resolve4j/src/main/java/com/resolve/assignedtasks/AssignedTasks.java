package com.resolve.assignedtasks;

import org.hibernate.annotations.Proxy;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Proxy(lazy = false)
public class AssignedTasks {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String status;
    private String task;
    private int totalExp;
    private int strengthExp;
    private int intelligenceExp;
    private int constitutionExp;
    private int dexterityExp;
    private LocalDateTime assigned;
    private LocalDateTime deadline;
    private LocalDateTime completed;

    public AssignedTasks() {
    }

    public AssignedTasks(String status, String task, int totalExp, int strengthExp, int intelligenceExp, int constitutionExp, int dexterityExp, LocalDateTime assigned, LocalDateTime deadline, LocalDateTime completed) {
        this.status = status;
        this.task = task;
        this.strengthExp = strengthExp;
        this.intelligenceExp = intelligenceExp;
        this.constitutionExp = constitutionExp;
        this.dexterityExp = dexterityExp;
        this.assigned = assigned;
        this.deadline = deadline;
        this.completed = completed;
        this.totalExp = totalExp;
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

    public LocalDateTime getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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
        this.totalExp = totalExp;
    }

    public LocalDateTime getAssigned() {
        return assigned;
    }

    public void setAssigned(LocalDateTime assigned) {
        this.assigned = assigned;
    }

    public LocalDateTime getCompleted() {
        return completed;
    }

    public void setCompleted(LocalDateTime completed) {
        this.completed = completed;
    }

}
