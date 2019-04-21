/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.service;

import com.aplikasiPOS.model.Menu;
import com.aplikasiPOS.model.Person;
import com.aplikasiPOS.model.Product;
import com.aplikasiPOS.model.Role;
import java.util.List;

/**
 *
 * @author Krizz2ND
 */
public interface SecurityService {

    public Person save(Person person);
    public Person delete(Person person);
    public Person getPerson(Long id);
    public List<Person> getPersons();
    public List<Person> getAll();
    

    public Menu save(Menu menu);
    public Menu delete(Menu menu);
    public Menu getMenu(Long id);
    public List<Menu> getMenus();

    public Role save(Role role);
    public Role delete(Role role);
    public Role getRole(Long id);
    public List<Role> getRoles();
    
    
    public Product save(Product product);
    public Product delete(Product product);
    public Product getProduct(Long id);
    public List<Product> getProducts();
    
    public List<Object[]> getCustom(String query);
}
