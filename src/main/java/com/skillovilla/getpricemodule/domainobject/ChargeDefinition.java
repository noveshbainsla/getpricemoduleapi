package com.skillovilla.getpricemodule.domainobject;


import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "CHARGE_DEFINITION_MST")
@DynamicUpdate
@Getter @Setter @Builder @AllArgsConstructor @NoArgsConstructor
public class ChargeDefinition implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String chargeCode;

    @NotNull
    private String chargeDescription;

    @NotNull
    private Boolean rateBased;

    private BigDecimal rate;

    private BigDecimal amount;

    private String fromCurrency;
    private String toCurrency;
    private String countryCode;
    private String stateCode;
}
