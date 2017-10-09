package com.taskmanagementapp.model;

import java.util.Date;


public class TMAModel implements java.io.Serializable {

    private Date creationTimeStamp;
    private long taskID;

    private String taskName;
    private Date taskEndDate;
    private String description;
    private String createdBy;

    public TMAModel() {
    }

    public TMAModel(Date creationTimeStamp, long taskID, String taskName, Date taskEndDate, String description, String createdBy) {
        this.creationTimeStamp = creationTimeStamp;
        this.taskID = taskID;
        this.taskName = taskName;
        this.taskEndDate = taskEndDate;
        this.description = description;
        this.createdBy = createdBy;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public void setCreationTimeStamp(Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public long getTaskID() {
        return taskID;
    }

    public void setTaskID(long taskID) {
        this.taskID = taskID;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
