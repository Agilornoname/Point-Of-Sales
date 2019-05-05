/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.main;

import com.aplikasiPOS.service.ProductService;
import com.aplikasiPOS.service.ReportService;
import com.aplikasiPOS.service.SalesService;
import com.aplikasiPOS.service.SecurityService;
import com.aplikasiPOS.ui.Login;
import com.aplikasiPOS.ui.MainMenu;
import com.aplikasiPOS.ui.RoleAndMenu;
import com.aplikasiPOS.ui.SalesPanel;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author Krizz2ND
 */
public class Main {

    private static SecurityService securityService;
    private static ProductService productService;
    private static SalesService salesService;

    private static Login frameLogin;
    private static MainMenu frameMenu;
    private static RoleAndMenu frameRoleAndMenu;
    private static SalesPanel frameSalesPanel;
    private static ReportService reportService;

    public static SalesPanel getFrameSalesPanel() {
        return frameSalesPanel;
    }

    public static SecurityService getSecurityService() {
        return securityService;
    }

    public static Login getFrameLogin() {
        return frameLogin;
    }

    public static MainMenu getFrameMenu() {
        return frameMenu;
    }

    public static RoleAndMenu getFrameRoleAndMenu() {
        return frameRoleAndMenu;
    }

    public static ProductService getProductService() {
        return productService;
    }

    public static SalesService getSalesService() {
        return salesService;
    }

    public static ReportService getReportService() {
        return reportService;
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
                securityService = (SecurityService) applicationContext.getBean("securityService");
                salesService = (SalesService) applicationContext.getBean("salesService");
                productService = (ProductService) applicationContext.getBean("productService");
                reportService = (ReportService) applicationContext.getBean("ReportService");
                frameLogin = new Login();
                frameMenu = new MainMenu();
                frameLogin.setLocationRelativeTo(null);
                frameLogin.setVisible(true);
            }
        });
    }
}
