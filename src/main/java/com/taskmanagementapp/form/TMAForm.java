package com.taskmanagementapp.form;

import com.taskmanagementapp.model.ErrorBean;
import org.apache.struts.action.ActionErrors;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class TMAForm extends ActionForm {

    private String taskName;
    private Date taskEndDate;
    private String description;
    private String createdBy;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    @Override
    public ActionErrors validate(ActionMapping mapping,
                                 HttpServletRequest request) {

        ActionErrors errors = new ActionErrors();
        ErrorBean errorBean = new ErrorBean();

        if( getTaskName() == null || ("".equals(getTaskName()))) {
            errorBean.setError1("Needed");
            errors.add("TaskName", new ActionMessage("required"));
        }

        if( getCreatedBy() == null || ("".equals(getCreatedBy()))) {
            errorBean.setError2("Needed");
            errors.add("createdBy", new ActionMessage("required"));
        }

        if( getDescription() == null || ("".equals(getDescription()))) {
            errorBean.setError1("Needed");
            errors.add("Desc", new ActionMessage("required"));
        }

        request.getSession().setAttribute("errorBean", errorBean);
        return errors;
    }

    @Override
    public void reset(ActionMapping mapping, HttpServletRequest request) {

        // reset properties
        taskName = "";
        taskEndDate = new Date();
        description = "";
        createdBy = "";

    }

}
