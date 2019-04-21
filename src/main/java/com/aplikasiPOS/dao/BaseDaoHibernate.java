/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

/**
 *
 * @author Krizz2ND
 * @param <T>
 */
public class BaseDaoHibernate<T> {

    @SuppressWarnings("unchecked")
    protected Class<T> dc;

    @Autowired
    protected SessionFactory sf;

    @SuppressWarnings("unchecked")
    public BaseDaoHibernate() {
        this.dc = (Class) ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        System.out.println(dc);
    }

    public T save(T domain) {
        sf.getCurrentSession().saveOrUpdate(domain);
        return domain;
    }

    @SuppressWarnings("unchecked")
    public T getById(Long id) {
        return (T) sf.getCurrentSession().get(dc, id);
    }

    public T delete(T domain) {
        sf.getCurrentSession().delete(domain);
        return domain;
    }

    @SuppressWarnings("unchecked")
    public Long count() {
        List list = sf.getCurrentSession().createQuery(
                "select count(*) from " + dc.getName() + " x").list();
        Long count = (Long) list.get(0);
        return count;
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll() {
        return sf.getCurrentSession().createQuery("from "
                + dc.getName())
                .list();
    }

    @SuppressWarnings("unchecked")
    public List<T> getAll(int start, int num) {
        return sf.getCurrentSession().createQuery("from "
                + dc.getName())
                .setFirstResult(start).setMaxResults(num)
                .list();
    }

}
