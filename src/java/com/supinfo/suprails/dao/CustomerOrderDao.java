/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.dao;

import com.supinfo.suprails.entity.CustomerOrder;
import javax.ejb.Local;

/**
 *
 * @author lukas
 */
@Local
public interface CustomerOrderDao {
    
    public CustomerOrder create(CustomerOrder customerOrder);
    
}
