package com.taskmanagementapp.action;

import com.taskmanagementapp.bo.TMABo;
import com.taskmanagementapp.form.TMAForm;
import com.taskmanagementapp.model.TMAModel;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.springframework.web.struts.ActionSupport;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class addTMAAction extends ActionSupport {

    public ActionForward execute(ActionMapping mapping, ActionForm form,
                                 HttpServletRequest request, HttpServletResponse response)
            throws Exception {

        request.getSession().setAttribute("errorBean", null);
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        TMABo tmaBo =
                (TMABo) getWebApplicationContext().getBean("TMABo");

        TMAForm tmaForm = (TMAForm) form;
        TMAModel tmaModel = new TMAModel();

        BeanUtils.copyProperties(tmaModel, tmaForm);
        request.getSession().setAttribute("name", tmaModel.getCreatedBy());
        tmaBo.addModel(tmaModel);

        return mapping.findForward("success");

    }

}
