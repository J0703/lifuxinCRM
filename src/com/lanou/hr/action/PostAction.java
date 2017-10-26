package com.lanou.hr.action;

import com.lanou.hr.domain.Department;
import com.lanou.hr.domain.Post;
import com.lanou.hr.service.DepartmentService;
import com.lanou.hr.service.PostService;
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

    // 查询所有部门
    public String findPost() {
        posts = postService.findAll();
        return SUCCESS;
    }

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
        }else {
            Post post = new Post();
            post.setPostId(postId);
            post.setPostName(postName);
            post.setDepartment(department);
            postService.update(post);
        }
        return SUCCESS;
    }


    public String showPost(){
        String hql = "from Post where depID =:depID";
        Map<String,Object> params = new HashMap<>();
        params.put("depID",depID);
        posts = postService.find(hql,params);
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
}
