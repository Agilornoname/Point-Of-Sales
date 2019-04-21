/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.serviceImpl;

import com.aplikasiPOS.dao.CustomDao;
import com.aplikasiPOS.dao.MenuDao;
import com.aplikasiPOS.dao.PersonDao;
import com.aplikasiPOS.dao.ProductDao;
import com.aplikasiPOS.dao.RoleDao;
import com.aplikasiPOS.model.Menu;
import com.aplikasiPOS.model.Person;
import com.aplikasiPOS.model.Product;
import com.aplikasiPOS.model.Role;
import com.aplikasiPOS.service.SecurityService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Krizz2ND
 */
@Service("securityService")
@Transactional(readOnly = true)
public class SecurityServiceImpl implements SecurityService {

    @Autowired
    private PersonDao personDao;
    @Autowired
    private MenuDao menuDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ProductDao productDao;
    @Autowired
    private CustomDao customDao;

    @Transactional
    public Person save(Person person) {
        return personDao.save(person);
    }

    @Transactional
    public Person delete(Person person) {
        return personDao.delete(person);
    }

    public Person getPerson(Long id) {
        return personDao.getById(id);
    }

    public List<Person> getPersons() {
        return personDao.getAll();
    }

    @Transactional
    public Menu save(Menu menu) {
        return menuDao.save(menu);
    }

    @Transactional
    public Menu delete(Menu menu) {
        return menuDao.delete(menu);
    }

    public Menu getMenu(Long id) {
        return menuDao.getById(id);
    }

    public List<Menu> getMenus() {
        return menuDao.getAll();
    }

    @Transactional
    public Role save(Role role) {
        return roleDao.save(role);
    }

    @Transactional
    public Role delete(Role role) {
        return roleDao.delete(role);
    }

    public Role getRole(Long id) {
        return roleDao.getById(id);
    }

    public List<Role> getRoles() {
        return roleDao.getAll();
    }

    @Transactional
    public Product save(Product product) {
        return productDao.save(product);
    }

    @Transactional
    public Product delete(Product product) {
        return productDao.delete(product);
    }

    public Product getProduct(Long id) {
        return productDao.getById(id);
    }

    public List<Product> getProducts() {
        return productDao.getAll();
    }

    @Override
    public List<Person> getAll() {
        return personDao.getAll();
    }

    @Override
    public List<Object[]> getCustom(String query) {
        return customDao.getCustom(query);
    }
}
