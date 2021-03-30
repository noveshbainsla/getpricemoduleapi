package com.skillovilla.getpricemodule.domainobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Table(name = "COUNTRY")
@Getter @Setter
@NamedNativeQuery(name = "Country.findByCountryCode",
        query = "SELECT * FROM country WHERE COUNTRY_CODE =:countryCode", resultClass = Country.class)
public class Country implements Serializable {
    @Id
    private Long id;
    private String countryCode;
    private String currencyCode;
}
