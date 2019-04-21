/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aplikasiPOS.dao;

import com.aplikasiPOS.model.Person;
import org.springframework.stereotype.Component;

/**
 *
 * @author Krizz2ND
 */
@Component
//ngasih tau spring klo ada yang ditandai @autowired berarti harus dikasih object 
//tapi spring harus punya
public class PersonDao extends BaseDaoHibernate<Person> {
}
