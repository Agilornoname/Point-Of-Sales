/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.serviceImpl;

import com.aplikasiPOS.Report.DailySalesReport;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Krizz2ND
 */


@Component("CC")
@Transactional(readOnly = true)
public class ReportServiceImpl {

    @Autowired
    private SessionFactory sessionFactory;

    private static final Logger log = Logger.getLogger(ReportServiceImpl.class);

    public List<DailySalesReport> getDailySalesReport() {
        List<DailySalesReport> list = sessionFactory.openSession()
                .createQuery("select p.name as productName, pp.quantity as quantity, pp.subTotal as subTotal from Product p,PurchaseDetail pp")
                .setResultTransformer(Transformers.aliasToBean(DailySalesReport.class))
                .list();
        return list;
    }
}
