package com.lanou.hr.dao.impl;

import com.lanou.hr.dao.BaseDao;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> implements BaseDao<T> {
    private SessionFactory sessionFactory;

    // 查询所有的部门
    @Override
    public List<T> findAll(String hql) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        List<T> tList = query.list();
        return tList;
    }

    // 增加方法
    @Override
    public T save(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.save(t);
        return t;
    }

    // 更新方法
    @Override
    public T update(T t) {
        Session session = sessionFactory.getCurrentSession();
        session.update(t);
        return t;
    }

    @Override
    public T findSingle(String hql, Map<String, Object> params) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery(hql);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        List<T> list = query.list();
        return list.get(0);
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        Session session = sessionFactory.getCurrentSession();
        T t = (T) session.get(c, id);
        return t;
    }


    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
