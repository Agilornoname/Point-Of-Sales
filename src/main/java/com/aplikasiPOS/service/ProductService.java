/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.service;

import com.aplikasiPOS.model.Product;
import java.util.List;

/**
 *
 * @author Krizz2ND
 */
public interface ProductService {

    Product save(Product product);

    Product delete(Product product);

    Product getProduct(Long id);

    List<Product> getProduct();

    List<Product> getProduct(int start, int num);
}
