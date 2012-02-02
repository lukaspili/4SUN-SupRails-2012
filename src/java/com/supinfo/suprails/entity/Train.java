/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author lukas
 */
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type")
public abstract class Train implements Serializable {
    
    public enum Traction {
        ELECTRIC, DIESEL
    }
    
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    
    private Long maxSpeed;
    
    @Enumerated(EnumType.STRING)
    private Traction traction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(Long maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    public Traction getTraction() {
        return traction;
    }

    public void setTraction(Traction traction) {
        this.traction = traction;
    }
    
    
}
