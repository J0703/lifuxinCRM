package com.lanou.teach.action;

import com.lanou.teach.dao.ClassesDao;
import com.lanou.teach.domain.Classes;
import com.lanou.teach.service.ClassesService;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Created by dllo on 17/10/31.
 */
@Controller("classesAction")
@Scope("prototype")
public class ClassesAction extends ActionSupport implements ModelDriven<Classes> {
    private Classes classes;
    @Qualifier("classesService")
    @Autowired
    private ClassesService classesService;
    private String classID;


    public String addClasses(){
        Classes classes = classesService.findSingle(Classes.class,classID);

        return SUCCESS;
    }




    @Override
    public Classes getModel() {
        classes = new Classes();
        return classes;
    }

    public String getClassID() {
        return classID;
    }

    public void setClassID(String classID) {
        this.classID = classID;
    }
}
