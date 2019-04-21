/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.Report;

import com.aplikasiPOS.main.Main;
import com.aplikasiPOS.service.ProductService;
import com.aplikasiPOS.service.ReportService;
import com.aplikasiPOS.service.SalesService;
import com.aplikasiPOS.service.SecurityService;
import com.aplikasiPOS.serviceImpl.ReportServiceImpl;
import java.util.Date;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Krizz2ND
 */
public class test {

    private static SecurityService securityService;
    private static ProductService productService;
    private static SalesService salesService;
    private static ReportServiceImpl reportService;

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        securityService = (SecurityService) applicationContext.getBean("securityService");
        String sql = "select p.name from Product p";
        List q = securityService.getCustom(sql);
        for (int i = 0; i < q.size(); i++) {
            System.out.println(q.get(i));
        }
    }
}
