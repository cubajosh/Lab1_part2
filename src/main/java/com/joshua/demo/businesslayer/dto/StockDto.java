package com.joshua.demo.businesslayer.dto;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class StockDto {

      private Integer id;
      private String companyName;
      private String price;
      private String dividend;
      private String ticker;

}
