package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {
    private SessionFactory sessionFactory;

    // 查询所有的部门
    @Override
    public List<T> findAll(String hql) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        List<T> tList = query.list();
        return tList;
    }

    // 增加方法
    @Override
    public void save(T t) {
        Session session = currentSession();
        session.save(t);

    }

    // 更新方法
    @Override
    public void update(T t) {
        Session session = currentSession();
        session.update(t);

    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<T> list = query.list();
        return list.get(0);
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        Session session = currentSession();
        T t = (T) session.get(c, id);
        return t;
    }

    @Override
    public T findById(Serializable id, Class<T> tClass) {
        return null;
    }


    public List<T> find(String hql, Map<String, Object> params) {
        Session session = currentSession();
        Query query = session.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<T> tList = query.list();
        return tList;
    }
}
