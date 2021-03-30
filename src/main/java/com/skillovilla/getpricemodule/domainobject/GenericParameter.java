package com.skillovilla.getpricemodule.domainobject;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "D_TYPE", discriminatorType = DiscriminatorType.STRING)
@Getter @Setter
public class GenericParameter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String code;
    @NotNull
    private String description;
    private String parameterValue;
}
