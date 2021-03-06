package com.lanou.hr.util;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

/**
 * Created by dllo on 17/10/28.
 */
public class PageHibernateCallback<T> implements HibernateCallback<List<T>> {

    private String hql;
    private Object[] params;
    private int startIndex;
    private int pageSize;

    public PageHibernateCallback(String hql, Object[] params, int startIndex, int pageSize) {
        this.hql = hql;
        this.params = params;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }

    public PageHibernateCallback(String hql, int startIndex, int pageSize) {
        this.hql = hql;
        this.startIndex = startIndex;
        this.pageSize = pageSize;
    }


    @Override
    public List<T> doInHibernate(Session session) throws HibernateException {
        Query query = session.createQuery(hql);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        query.setFirstResult(startIndex);
        query.setMaxResults(pageSize);

        return query.list();
    }
}
