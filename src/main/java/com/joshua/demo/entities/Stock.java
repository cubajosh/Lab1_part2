package com.joshua.demo.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="stock_data")
@NoArgsConstructor
@Setter
@Getter
public class Stock {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer id;
    private String companyName;
    private String ticker;
    private String price;
    private String dividend;
    private String ceo;
    private String equity;




}
