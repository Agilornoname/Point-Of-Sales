/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.serviceImpl;

import com.aplikasiPOS.Report.DailySalesReport;
import com.aplikasiPOS.service.ReportService;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.log4j.Logger;
import org.hibernate.SessionFactory;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Krizz2ND
 */
@Service("ReportService")
@Transactional(readOnly = true)
public class ReportServiceImpl implements ReportService {

    @Autowired
    private SessionFactory sessionFactory;

    JasperReport jasperReport;

    private static final Logger log = Logger.getLogger(ReportServiceImpl.class);

    public JasperPrint getDailySalesReport(Date date) {
        try {
            List<DailySalesReport> list = sessionFactory.openSession()
                    .createQuery("select s.product.name as productName,"
                            + " sum(s.quantity) as quantity, "
                            + " sum(s.subtotal) as subTotal from SalesDetail s "
                            + " where day(s.sales.salesDate) = day(:date) "
                            + " group by s.product.name order by s.product.name")
                    .setParameter("date", date)
                    .setResultTransformer(Transformers.aliasToBean(DailySalesReport.class))
                    .list();

            InputStream input = new FileInputStream("C:/Users/Krizz2ND/Documents/NetBeansProjects/Belajar/src/main/java/reports/TransaksiReport.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(input);
            jasperReport = JasperCompileManager.compileReport(jasperDesign);

            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("date", date);
            return JasperFillManager.fillReport(jasperReport, parameters, new JRBeanCollectionDataSource(list));
        } catch (JRException ex) {
            System.out.println(ex);
            return null;
        } catch (FileNotFoundException ex) {
            java.util.logging.Logger.getLogger(ReportServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
