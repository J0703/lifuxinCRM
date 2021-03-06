package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.service.DepartmentService;
import com.lanou.hr.service.PostService;
import com.lanou.hr.service.StaffService;
import com.lanou.hr.util.PageBean;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
@Controller("postAction")
@Scope("prototype")
public class PostAction extends ActionSupport {
    @Qualifier("postService")
    @Autowired
    private PostService postService;
    @Qualifier("departmentService")
    @Autowired
    private DepartmentService departmentService;
    private String postId;
    private String postName;
    private String depID;
    private List<Post> posts;
    private Post post;

    // 分页
    private int pageNum;
    private int pageSize = 5;

    // 查询所有部门
    public String findPost() {
        posts = postService.findAll();
        return SUCCESS;
    }

    // 根据id查找对象
    public String getSinglePost() {
        Serializable id = postId;
        post = postService.get(Post.class, id);
        return SUCCESS;
    }


    // 在下拉列表中添加职务
    public String add() {
        Department department = departmentService.get(Department.class, depID);
        if (StringUtils.isBlank(postId)) {
            if (StringUtils.isBlank(postName)) {
                addActionError("职务名不能为空");
                return INPUT;
            }
            Post post = new Post();
            post.setPostName(postName);
            post.setDepartment(department);
            postService.add(post);
        } else {
            Post post = new Post();
            post.setPostId(postId);
            post.setPostName(postName);
            post.setDepartment(department);
            postService.update(post);
        }
        return SUCCESS;
    }

    /**
     * 添加职务的验证
     */
    public void validateAdd() {
        if (StringUtils.isBlank(postName)){
            addActionError("部门,职务名不能为空");
        }
    }

    /**
     * 根据id查询post
     * @return
     */
    public String showPost() {
        String hql = "from Post where depID =:depID";
        Map<String, Object> params = new HashMap<>();
        params.put("depID", depID);
        posts = postService.find(hql, params);
        return SUCCESS;
    }

    // 分页查询Post
    public String findBypage() {
        if (pageNum == 0) {
            pageNum = 1;
        }
        PageBean<Post> pageBean = postService.findByPage(pageNum, pageSize);
        ActionContext.getContext().put("pageBean", pageBean);
        return SUCCESS;
    }


    public String getPostId() {
        return postId;
    }

    public void setPostId(String postId) {
        this.postId = postId;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public String getDepID() {
        return depID;
    }

    public void setDepID(String depID) {
        this.depID = depID;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
}
