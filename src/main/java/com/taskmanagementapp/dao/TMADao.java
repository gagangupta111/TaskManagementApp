package com.taskmanagementapp.dao;

import com.taskmanagementapp.model.TMAModel;

public interface TMADao {

    void addFeedBackForm(TMAModel tmaModel);
    String thanksForFeedbackForm();

}
