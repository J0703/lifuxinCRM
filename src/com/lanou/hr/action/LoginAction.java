package com.lanou.hr.action;

import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.StaffService;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by dllo on 17/10/30.
 */
@Controller("longinAction")
@Scope("prototype")
public class LoginAction extends ActionSupport{
    @Qualifier("staffService")
    @Autowired
    private StaffService staffService;
    private String loginName;
    private String loginPwd;
    private String oldPassword;
    private String newPassword;
    private String reNewPassword;

    // 登录
    public String login(){
        Map<String,Object> params = new HashMap<>();
        params.put("loginName",loginName);
        System.out.println(params);
        if (staffService.findSingle(params) == null){
            addActionError("用户不存在!");
            return INPUT;
        }
        params.put("loginPwd",loginPwd);
        Staff staff = staffService.login(params);
        ActionContext.getContext().getApplication().put("staff",staff);
        if (staff == null){
            addActionError("你输入的密码有误!");
            return INPUT;
        }
        return SUCCESS;
    }


    // 修改密码
    public String updatePwd(){
        Staff staff = (Staff) ActionContext.getContext().getApplication().get("staff");
        if (StringUtils.isBlank(oldPassword) && StringUtils.isBlank(newPassword)&&StringUtils.isBlank(reNewPassword)){
            addActionError("输入的密码不能为空,重新输入");
            return INPUT;
        }
        System.out.println("oldPassword"+oldPassword);
        System.out.println("loginPassword"+staff.getLoginPwd());
        if (!oldPassword.equals(staff.getLoginPwd())){
            addActionError("你真的笨,密码都记不住!");
            return INPUT;
        }
        if (!newPassword.equals(reNewPassword)){
            addActionError("确认失败,请重新输入吧!");
            return INPUT;
        }
        if (newPassword.length() < 3){
            addActionError("新密码应该在3位以上");
            return INPUT;
        }
        staff.setLoginPwd(newPassword);
        staffService.update(staff);
        addFieldError("msg","修改密码成功!!");
        return SUCCESS;
    }


    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd;
    }

    public String getOldPassword() {
        return oldPassword;
    }

    public void setOldPassword(String oldPassword) {
        this.oldPassword = oldPassword;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getReNewPassword() {
        return reNewPassword;
    }

    public void setReNewPassword(String reNewPassword) {
        this.reNewPassword = reNewPassword;
    }
}
