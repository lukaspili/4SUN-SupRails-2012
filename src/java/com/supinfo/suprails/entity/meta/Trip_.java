/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supinfo.suprails.entity.meta;

import com.supinfo.suprails.entity.TrainStation;
import com.supinfo.suprails.entity.Trip;
import java.math.BigDecimal;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

/**
 *
 * @author lukas
 */
@StaticMetamodel(Trip.class)
public class Trip_ {
    
    public static volatile SingularAttribute<Trip, Long> id;
    public static volatile SingularAttribute<Trip, BigDecimal> price;
    public static volatile SingularAttribute<Trip, TrainStation> departureStation;
    public static volatile SingularAttribute<Trip, TrainStation> arrivalStation;
}
