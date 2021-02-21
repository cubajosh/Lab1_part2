package com.joshua.demo.businesslayer;

import com.joshua.demo.businesslayer.dto.StockDto;
import com.joshua.demo.entities.Stock;

import java.util.List;

public interface StockService {

    public List<StockDto> getAllStocks();
    public StockDto getStockById(Integer id);
    public StockDto addStock(Stock stock);
    public StockDto updateStock(Stock stock);
    public void deleteStock(StockDto stock);
}
