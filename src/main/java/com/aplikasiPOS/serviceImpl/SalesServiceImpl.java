/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.serviceImpl;

import com.aplikasiPOS.dao.salesDao;
import com.aplikasiPOS.model.Sales;
import com.aplikasiPOS.service.SalesService;
import java.util.Date;
import java.util.List;
import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Krizz2ND
 */
@Service(value = "salesService")
@Transactional(readOnly = true)
public class SalesServiceImpl implements SalesService {

    @Autowired
    private salesDao salesDao;

    @Transactional
    public Sales save(Sales sales) {
        //agar yang digunakan adalah Date server bukan date client kalau
        //dijalankan dengan arsitektur three tier
        sales.setSalesDate(new Date());
        return salesDao.save(sales);
    }

    @Transactional
    public Sales delete(Sales sales) {
        return salesDao.delete(sales);
    }

    public Sales getSales(Long id) {
        Sales s = salesDao.getById(id);
        Hibernate.initialize(s.getSalesDetails());
        return s;
    }

    public List<Sales> getSales() {
        return salesDao.getAll();
    }

    public List<Sales> getSales(int start, int num) {
        return salesDao.getAll(start, num);
    }
}
