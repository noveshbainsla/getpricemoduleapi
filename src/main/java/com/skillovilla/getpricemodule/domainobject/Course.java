package com.skillovilla.getpricemodule.domainobject;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "COURSE")
@DynamicUpdate
@Getter @Setter  @Builder  @NoArgsConstructor  @AllArgsConstructor
public class Course implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @NotNull
    private String courseCode;
    @NotNull
    private String courseDesc;
    @NotNull
    private String priceType;
    private Integer months;
    private BigDecimal amount;

}
