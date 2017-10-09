package com.taskmanagementapp.bo;

import com.taskmanagementapp.dao.TMADao;
import com.taskmanagementapp.model.TMAModel;

public class TMABoImpl implements TMABo{

    TMADao tmaDao;

    public void setTmaDao(TMADao tmaDao) {
        this.tmaDao = tmaDao;
    }

    public void addModel(TMAModel tmaModel) {
        tmaDao.addFeedBackForm(tmaModel);
    }

    public String thanksForFeedbackForm() {
        return "thanks";
    }
}
