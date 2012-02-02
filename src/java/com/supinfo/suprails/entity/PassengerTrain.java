/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import java.io.Serializable;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 *
 * @author lukas
 */
@Entity
@DiscriminatorValue(value="passenger")
public class PassengerTrain extends Train implements Serializable {
    
    private Integer seatQuantity;

    public Integer getSeatQuantity() {
        return seatQuantity;
    }

    public void setSeatQuantity(Integer seatQuantity) {
        this.seatQuantity = seatQuantity;
    }
}
