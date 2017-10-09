package com.tmaapi.rest;

import com.taskmanagementapp.model.Search;
import com.taskmanagementapp.model.TMAModel;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import java.io.File;
import java.util.List;

public class HibernateService {

    private String path  = "com/tma/hibernate/hibernate.xml";
    private ClassLoader classLoader = getClass().getClassLoader();
    private File file = new File(classLoader.getResource(path).getFile());
    private Configuration cfg=new Configuration();
    private SessionFactory factory=null;

    public List getAll() {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        List<TMAModel> list = session.createCriteria(TMAModel.class).list();

        t.commit();
        session.close();
        System.out.println("successfully retrieved all ! ");
        return list;

    }


    public void add(TMAModel tmaModel) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        session.persist(tmaModel);
        t.commit();
        session.close();
        System.out.println("successfully saved ! ");

    }

    public void update(TMAModel tmaModel) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        session.update(tmaModel);
        t.commit();
        session.close();
        System.out.println("successfully updated ! ");

    }

    public void delete(TMAModel tmaModel) {

        if (tmaModel == null){
            System.out.println("null model ! ");
            return;
        }

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        session.delete(tmaModel);
        t.commit();
        session.close();
        System.out.println("successfully deleted ! ");

    }

    public TMAModel get(long id) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session = factory.openSession();
        Transaction t = session.beginTransaction();

        TMAModel tmaModel = new TMAModel();
        try {
            session.load(tmaModel, id);
        }catch (Exception e){
            tmaModel = null;
        }
        t.commit();
        session.close();
        System.out.println("successfully retrieved ! ");
        return tmaModel;

    }

    public List searchByCreatedBy(Search search) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        Criteria cr = session.createCriteria(TMAModel.class);
        cr.add(Restrictions.eq("createdBy", search.getCreatedBy()));
        List results = cr.list();

        t.commit();
        session.close();
        System.out.println("successfully saved ! ");
        return results;

    }

    public List searchByCreationTimeStamp(Search search) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        long before  = search.getBefore();

        Criteria cr = session.createCriteria(TMAModel.class);

        if (before == 0){
            cr.add(Restrictions.lt("creationTimeStamp", search.getCreationTimeStamp()));
        }else {
            cr.add(Restrictions.ge("creationTimeStamp", search.getCreationTimeStamp()));
        }

        List results = cr.list();

        t.commit();
        session.close();
        System.out.println("successfully saved ! ");
        return results;

    }

    public List searchByTaskEndDate(Search search) {

        if (factory == null){
            cfg.configure(path);
            factory=cfg.buildSessionFactory();
        }

        Session session=factory.openSession();
        Transaction t=session.beginTransaction();

        long before  = search.getBefore();
        Criteria cr = session.createCriteria(TMAModel.class);

        if (before == 0){
            cr.add(Restrictions.lt("taskEndDate", search.getTaskEndDate()));
        }else {
            cr.add(Restrictions.ge("taskEndDate", search.getTaskEndDate()));
        }

        List results = cr.list();

        t.commit();
        session.close();
        System.out.println("successfully saved ! ");
        return results;

    }


}
