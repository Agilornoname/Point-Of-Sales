/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.dao;

import java.util.List;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Krizz2ND
 */
@Component
public class CustomDao {

    @Autowired
    protected SessionFactory sf;
    
    public List<Object[]> getCustom (String query){
        List q = sf.getCurrentSession().createQuery(query).list();
        return q;
    }
}
