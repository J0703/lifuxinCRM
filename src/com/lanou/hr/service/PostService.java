package com.lanou.hr.service;

import com.lanou.hr.domain.Post;
import com.lanou.hr.util.PageBean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public interface PostService {
    // 查询所有职务
    List<Post> findAll();

    // 在下拉列表中添加职务
    void add(Post post);

    // 通过id查询
    Post findById(String postId);

    // 通过id查询
    Post get(Class<Post> postClass,Serializable id);

    // 更新
    void  update(Post post1);

    List<Post> find(String hql, Map<String, Object> params);

    PageBean<Post> findByPage(int pageNum,int pageSize);
}
