package com.lanou.hr.dao.impl;


import com.lanou.hr.dao.BaseDao;
import com.lanou.hr.util.PageHibernateCallback;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by dllo on 17/10/25.
 */
public class BaseDaoImpl<T> extends HibernateDaoSupport implements BaseDao<T> {

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
        // 这个地方一定要加判断,否则即使查不到也会返回
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public T get(Class<T> c, Serializable id) {
        Session session = currentSession();
        T t = (T) session.get(c, id);
        // 高级查询
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
        if (tList.size() > 0) {
            return tList;
        }
        return null;
    }

    @Override
    public List<T> find(String hql, Object[] params) {
        List<T> list = (List<T>) getHibernateTemplate().find(hql, params);
        return list;
    }

    @Override
    public int getTotalRecord(String hql) {
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(hql);
        if (find != null) {
            return find.get(0).intValue();
        }
        return 0;
    }

    @Override
    public List<T> findALL(String hql, int startIndex, int pageSize) {
        return this.getHibernateTemplate().execute(new PageHibernateCallback<T>(hql, startIndex, pageSize));
    }


}
