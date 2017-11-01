package com.lanou.hr.intercepter;


import com.lanou.hr.domain.Staff;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.MethodFilterInterceptor;
import org.apache.struts2.ServletActionContext;


/**
 * Created by dllo on 17/10/30.
 */
public class HrIntercepter extends MethodFilterInterceptor {


    @Override
    protected String doIntercept(ActionInvocation actionInvocation) throws Exception {
        System.out.println("执行拦截器了");
        Staff staff = (Staff) ActionContext.getContext().getApplication().get("staff");
        if (!staff.getPost().getDepartment().getDepName().equals("人事部")) {
            return "error";
        }
        return actionInvocation.invoke();
    }
}

