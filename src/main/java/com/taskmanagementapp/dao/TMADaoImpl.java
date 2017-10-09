package com.taskmanagementapp.dao;

import java.io.File;
import java.util.Date;

import com.taskmanagementapp.model.TMAModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class TMADaoImpl extends HibernateDaoSupport implements TMADao{


    public void addFeedBackForm(TMAModel tmaModel) {
        tmaModel.setCreationTimeStamp(new Date());
        getHibernateTemplate().save(tmaModel);
    }

    public String thanksForFeedbackForm() {
        return "thanks!";
    }
}
