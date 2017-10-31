package com.lanou.hr.service.impl;

import com.lanou.hr.dao.PostDao;
import com.lanou.hr.domain.Post;
import com.lanou.hr.service.PostService;
import com.lanou.hr.util.PageBean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/26.
 */
public class PostServiceImpl implements PostService {

    private PostDao postDao;
    // 查询所有
    @Override
    public List<Post> findAll() {
        String hql = "from Post";
        return postDao.findAll(hql);
    }

    // 添加职务
    @Override
    public void add(Post post) {
        postDao.save(post);
    }

    @Override
    public Post findById(String postId) {
        String hql = "from Post where postId=:id";
        Map<String,Object> params = new HashMap<>();
        params.put("id",postId);
        return postDao.findSingle(hql,params);
    }

    @Override
    public Post get(Class<Post> postClass, Serializable id) {
        return postDao.get(postClass,id);
    }

    @Override
    public void update(Post post1) {
        postDao.update(post1);
    }

    @Override
    public List<Post> find(String hql, Map<String, Object> params) {
        return postDao.find(hql,params);
    }

    @Override
    public PageBean<Post> findByPage(int pageNum, int pageSize) {
        String hql = "select count(*) from Post";
        String hql1 = "from Post where 1=1";
        int totalRecord = postDao.getTotalRecord(hql);
        PageBean<Post> pageBean = new PageBean<>(pageNum,pageSize,totalRecord);
        List<Post> data = postDao.findALL(hql1,pageBean.getStartIndex(),pageBean.getPageSize());
        pageBean.setData(data);
        return pageBean;
    }


    public PostDao getPostDao() {
        return postDao;
    }

    public void setPostDao(PostDao postDao) {
        this.postDao = postDao;
    }
}
