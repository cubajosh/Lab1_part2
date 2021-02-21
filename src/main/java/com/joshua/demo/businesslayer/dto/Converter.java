package com.joshua.demo.businesslayer.dto;

import com.joshua.demo.entities.Stock;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class Converter {

    public StockDto stockDtoConverter(Stock stock){
        ModelMapper modelMapper = new ModelMapper();

                StockDto s = modelMapper.map(stock, StockDto.class);
                return s;

    }
    public List<StockDto> StockDtoList(List<Stock> stock){
        return stock.stream().map(x -> stockDtoConverter(x)).collect(Collectors.toList());
    }
    public Stock stockDelete(StockDto dt){
        ModelMapper mod = new ModelMapper();
        Stock s = mod.map(dt, Stock.class);
        return s;
    }
}
