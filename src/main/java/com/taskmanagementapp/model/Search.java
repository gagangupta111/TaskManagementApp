package com.taskmanagementapp.model;

import java.util.Date;

public class Search implements java.io.Serializable {

    private Date creationTimeStamp;
    private Date taskEndDate;
    private String createdBy;
    // before 0 means "search after the date" and before 1 means search before date!
    private long before;

    public Search() {
    }

    public Search(Date creationTimeStamp, Date taskEndDate, String createdBy, long before) {
        this.creationTimeStamp = creationTimeStamp;
        this.taskEndDate = taskEndDate;
        this.createdBy = createdBy;
        this.before = before;
    }

    public Date getCreationTimeStamp() {
        return creationTimeStamp;
    }

    public void setCreationTimeStamp(Date creationTimeStamp) {
        this.creationTimeStamp = creationTimeStamp;
    }

    public Date getTaskEndDate() {
        return taskEndDate;
    }

    public void setTaskEndDate(Date taskEndDate) {
        this.taskEndDate = taskEndDate;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public long getBefore() {
        return before;
    }

    public void setBefore(long before) {
        this.before = before;
    }

    @Override
    public String toString() {
        return "Search{" +
                "creationTimeStamp=" + creationTimeStamp +
                ", taskEndDate=" + taskEndDate +
                ", createdBy='" + createdBy + '\'' +
                ", before=" + before +
                '}';
    }
}
