package com.joshua.demo.businesslayer;

import com.joshua.demo.businesslayer.dto.Converter;
import com.joshua.demo.datalayer.dao.StockRepo;
import com.joshua.demo.businesslayer.dto.StockDto;
import com.joshua.demo.entities.Stock;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockServicelmpl implements StockService{

    private Converter converter;
    private StockRepo rep;

    public StockServicelmpl(Converter converter, StockRepo rep) {
        this.converter = converter;
        this.rep = rep;
    }


    @Override
    public List<StockDto> getAllStocks(){
        return converter.StockDtoList(rep.findAll());

    }
    @Override
    public StockDto getStockById(Integer id){

        return converter.stockDtoConverter(rep.findById(id).get());

    }
    @Override
    public StockDto addStock(Stock stock){
        Stock st = rep.save(stock);
        StockDto d = converter.stockDtoConverter(st);
        return d;
    }
    @Override
    public void deleteStock(StockDto stock){
        Stock s = converter.stockDelete(stock);
        rep.delete(s);
    }
    @Override
    public StockDto updateStock(Stock stock){
        Stock s = rep.save(stock);
        return converter.stockDtoConverter(s);
    }


}
