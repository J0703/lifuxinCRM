package com.lanou.hr.dao.impl;
import com.lanou.hr.dao.StaffDao;
import com.lanou.hr.domain.Staff;
import com.lanou.hr.util.PageHibernateCallback;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;



/**
 * Created by dllo on 17/10/26.
 */
public class StaffDaoImpl extends BaseDaoImpl<Staff> implements StaffDao {


    @Override
    public int getTotalRecondStaff(String hql, List<Object> params) {
        StringBuilder stringBuilder = new StringBuilder(hql);
        Object staffName = params.get(0);
        Object depID = params.get(1);
        Object postId = params.get(2);
        List<Object> lists = new ArrayList<>();
        if (staffName.toString().trim().length() > 0){
            stringBuilder.append(" and staffName like ?");
            lists.add(staffName);
        }
        if (!depID.equals("-1")){
            stringBuilder.append(" and depID like ?");
            lists.add(depID);
        }
        if (!postId.equals("-1")){
            stringBuilder.append(" and postId like ?");
            lists.add(postId);
        }
        List<Long> find = (List<Long>) this.getHibernateTemplate().find(stringBuilder.toString(),lists.toArray());
        if (find != null){
            return find.get(0).intValue();
        }

        return 0;
    }

    @Override
    public List<Staff> findByCD(String sql1, List<Object> params, int startIndex, int pageSize) {

        StringBuffer sb = new StringBuffer();
        Object staffName = params.get(0);
        Object depID = params.get(1);
        Object postId = params.get(2);
        List<Object> lists = new ArrayList<>();
        if (staffName.toString().trim().length() > 0){
            sb.append(" and staffName like ?");
            lists.add(staffName);
        }
        if (!depID.equals("-1")){
            sb.append(" and depID like ?");
            lists.add(depID);
        }
        if (!postId.equals("-1")){
            sb.append(" and postId like ?");
            lists.add(postId);
        }

        return this.getHibernateTemplate().execute(new PageHibernateCallback<Staff>(sb.toString(), lists.toArray(), startIndex, pageSize));
    }




}
