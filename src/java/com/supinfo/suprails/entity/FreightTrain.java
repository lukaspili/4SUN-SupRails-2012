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
@DiscriminatorValue(value="freight")
public class FreightTrain extends Train implements Serializable {
    
    private Long maxWeight;

    public Long getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(Long maxWeight) {
        this.maxWeight = maxWeight;
    }
}
