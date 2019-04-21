/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.service;

import com.aplikasiPOS.model.Sales;
import java.util.List;

/**
 *
 * @author Krizz2ND
 */
public interface SalesService {

    Sales save(Sales sales);

    Sales delete(Sales sales);

    Sales getSales(Long id);

    List<Sales> getSales();

    List<Sales> getSales(int start, int num);
}
