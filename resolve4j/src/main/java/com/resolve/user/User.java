package com.resolve.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    public String name;
    public int level;
    public int totalExp;
    public int expThisLevel;
    public int totalExpForNextLevelUp;
    public int strengthLevel;
    public int strengthExp;
    public int strengthExpThisLevel;
    public int strengthExpForNextLevelUp;
    public int dexterityLevel;
    public int dexterityExp;
    public int dexterityExpThisLevel;
    public int dexterityExpForNextLevelUp;
    public int intelligenceLevel;
    public int intelligenceExp;
    public int intelligenceExpThisLevel;
    public int intelligenceExpForNextLevelUp;
    public int constitutionLevel;
    public int constitutionExp;
    public int constitutionExpThisLevel;
    public int constitutionExpForNextLevelUp;
    public int tasksCompleted;
    public int tasksMissed;

    public User() {
    }

    public User(long id, String name, int level, int totalExp, int expThisLevel, int totalExpForNextLevelUp, int strengthLevel, int strengthExp, int strengthExpThisLevel, int strengthExpForNextLevelUp, int dexterityLevel, int dexterityExp, int dexterityExpThisLevel, int dexterityExpForNextLevelUp, int intelligenceLevel, int intelligenceExp, int intelligenceExpThisLevel, int intelligenceExpForNextLevelUp, int constitutionLevel, int constitutionExp, int constitutionExpThisLevel, int constitutionExpForNextLevelUp, int tasksCompleted, int tasksMissed) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.totalExp = totalExp;
        this.expThisLevel = expThisLevel;
        this.totalExpForNextLevelUp = totalExpForNextLevelUp;
        this.strengthLevel = strengthLevel;
        this.strengthExp = strengthExp;
        this.strengthExpThisLevel = strengthExpThisLevel;
        this.strengthExpForNextLevelUp = strengthExpForNextLevelUp;
        this.dexterityLevel = dexterityLevel;
        this.dexterityExp = dexterityExp;
        this.dexterityExpThisLevel = dexterityExpThisLevel;
        this.dexterityExpForNextLevelUp = dexterityExpForNextLevelUp;
        this.intelligenceLevel = intelligenceLevel;
        this.intelligenceExp = intelligenceExp;
        this.intelligenceExpThisLevel = intelligenceExpThisLevel;
        this.intelligenceExpForNextLevelUp = intelligenceExpForNextLevelUp;
        this.constitutionLevel = constitutionLevel;
        this.constitutionExp = constitutionExp;
        this.constitutionExpThisLevel = constitutionExpThisLevel;
        this.constitutionExpForNextLevelUp = constitutionExpForNextLevelUp;
        this.tasksCompleted = tasksCompleted;
        this.tasksMissed = tasksMissed;
    }

    public int getStrengthLevel() {
        return strengthLevel;
    }

    public void setStrengthLevel(int strengthLevel) {
        this.strengthLevel = strengthLevel;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public int getTotalExp() {
        return totalExp;
    }

    public void setTotalExp(int totalExp) {
        this.totalExp = totalExp;
    }

    public int getExpThisLevel() {
        return expThisLevel;
    }

    public void setExpThisLevel(int expThisLevel) {
        this.expThisLevel = expThisLevel;
    }

    public int getTotalExpForNextLevelUp() {
        return totalExpForNextLevelUp;
    }

    public void setTotalExpForNextLevelUp(int totalExpForNextLevelUp) {
        this.totalExpForNextLevelUp = totalExpForNextLevelUp;
    }

    public int getStrengthExp() {
        return strengthExp;
    }

    public void setStrengthExp(int strengthExp) {
        this.strengthExp = strengthExp;
    }

    public int getStrengthExpThisLevel() {
        return strengthExpThisLevel;
    }

    public void setStrengthExpThisLevel(int strengthExpThisLevel) {
        this.strengthExpThisLevel = strengthExpThisLevel;
    }

    public int getStrengthExpForNextLevelUp() {
        return strengthExpForNextLevelUp;
    }

    public void setStrengthExpForNextLevelUp(int strengthExpForNextLevelUp) {
        this.strengthExpForNextLevelUp = strengthExpForNextLevelUp;
    }

    public int getDexterityLevel() {
        return dexterityLevel;
    }

    public void setDexterityLevel(int dexterityLevel) {
        this.dexterityLevel = dexterityLevel;
    }

    public int getDexterityExp() {
        return dexterityExp;
    }

    public void setDexterityExp(int dexterityExp) {
        this.dexterityExp = dexterityExp;
    }

    public int getDexterityExpThisLevel() {
        return dexterityExpThisLevel;
    }

    public void setDexterityExpThisLevel(int dexterityExpThisLevel) {
        this.dexterityExpThisLevel = dexterityExpThisLevel;
    }

    public int getDexterityExpForNextLevelUp() {
        return dexterityExpForNextLevelUp;
    }

    public void setDexterityExpForNextLevelUp(int dexterityExpForNextLevelUp) {
        this.dexterityExpForNextLevelUp = dexterityExpForNextLevelUp;
    }

    public int getIntelligenceLevel() {
        return intelligenceLevel;
    }

    public void setIntelligenceLevel(int intelligenceLevel) {
        this.intelligenceLevel = intelligenceLevel;
    }

    public int getIntelligenceExp() {
        return intelligenceExp;
    }

    public void setIntelligenceExp(int intelligenceExp) {
        this.intelligenceExp = intelligenceExp;
    }

    public int getIntelligenceExpThisLevel() {
        return intelligenceExpThisLevel;
    }

    public void setIntelligenceExpThisLevel(int intelligenceExpThisLevel) {
        this.intelligenceExpThisLevel = intelligenceExpThisLevel;
    }

    public int getIntelligenceExpForNextLevelUp() {
        return intelligenceExpForNextLevelUp;
    }

    public void setIntelligenceExpForNextLevelUp(int intelligenceExpForNextLevelUp) {
        this.intelligenceExpForNextLevelUp = intelligenceExpForNextLevelUp;
    }

    public int getConstitutionLevel() {
        return constitutionLevel;
    }

    public void setConstitutionLevel(int constitutionLevel) {
        this.constitutionLevel = constitutionLevel;
    }

    public int getConstitutionExp() {
        return constitutionExp;
    }

    public void setConstitutionExp(int constitutionExp) {
        this.constitutionExp = constitutionExp;
    }

    public int getConstitutionExpThisLevel() {
        return constitutionExpThisLevel;
    }

    public void setConstitutionExpThisLevel(int constitutionExpThisLevel) {
        this.constitutionExpThisLevel = constitutionExpThisLevel;
    }

    public int getConstitutionExpForNextLevelUp() {
        return constitutionExpForNextLevelUp;
    }

    public void setConstitutionExpForNextLevelUp(int constitutionExpForNextLevelUp) {
        this.constitutionExpForNextLevelUp = constitutionExpForNextLevelUp;
    }

    public int getTasksCompleted() {
        return tasksCompleted;
    }

    public void setTasksCompleted(int tasksCompleted) {
        this.tasksCompleted = tasksCompleted;
    }

    public int getTasksMissed() {
        return tasksMissed;
    }

    public void setTasksMissed(int tasksMissed) {
        this.tasksMissed = tasksMissed;
    }
}
