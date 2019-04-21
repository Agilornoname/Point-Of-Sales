/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.serviceImpl;

import com.aplikasiPOS.dao.ProductDao;
import com.aplikasiPOS.model.Product;
import com.aplikasiPOS.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Krizz2ND
 */
@Service("productService")
@Transactional(readOnly = true)
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductDao productDao;

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Override
    public Product delete(Product product) {
        return productDao.delete(product);
    }

    @Override
    public Product getProduct(Long id) {
        return productDao.getById(id);
    }

    @Override
    public List<Product> getProduct() {
        return productDao.getAll();
    }

    @Override
    public List<Product> getProduct(int start, int num) {
        return productDao.getAll(start, num);
    }
}
