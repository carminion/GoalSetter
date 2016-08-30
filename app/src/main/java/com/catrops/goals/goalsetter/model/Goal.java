package com.catrops.goals.goalsetter.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by catrops on 8/12/16.
 */
public class Goal extends RealmObject {

    @PrimaryKey
    private int id;
    private String name;
    private String outcome;
    private String obstacle;
    private String plan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOutcome() {
        return outcome;
    }

    public void setOutcome(String outcome) {
        this.outcome = outcome;
    }

    public String getObstacle() {
        return obstacle;
    }

    public void setObstacle(String obstacle) {
        this.obstacle = obstacle;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
