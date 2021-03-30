package com.skillovilla.getpricemodule.domainobject;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("PriceType")
public class PriceType extends GenericParameter {
    public static final String ONE_TIME = "OT";
    public static final  String MONTHLY = "M";
    public static final  String FREE = "F";
}
