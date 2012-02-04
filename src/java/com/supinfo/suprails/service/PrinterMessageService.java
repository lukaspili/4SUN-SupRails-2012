/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.service;

import com.supinfo.suprails.entity.CustomerOrder;
import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.*;

/**
 *
 * @author lukas
 */
@Stateless
public class PrinterMessageService {
    
    @Resource(mappedName="jms/suprailsConnectionFactory")
    private ConnectionFactory connectionFactory;
    
    @Resource(mappedName="jms/suprailsQueue")
    private Destination destination;
    
    
    public void printCustomerOrder(CustomerOrder customerOrder) {
        
        Connection connection = null;
        
        try {
            connection = connectionFactory.createConnection();
            
            Session session = connection.createSession(false, 
                    Session.AUTO_ACKNOWLEDGE);
            
            MessageProducer producer = session.createProducer(destination);
            
            TextMessage message = session.createTextMessage(
                    "Order for " + customerOrder.getCustomer().getFirstname() + " " + customerOrder.getCustomer().getLastname());
            
            producer.send(message);
            
        } catch (JMSException ex) {
            System.out.println(ex.getMessage());
        } finally {
            if(null != connection) {
                try {
                    connection.close();
                } catch (JMSException ex) {
                    System.out.println(ex.getMessage());
                }
            }
        }
        
    }
}
