package com.joshua.demo.presentationlayer;

import com.joshua.demo.businesslayer.StockService;
import com.joshua.demo.businesslayer.dto.StockDto;
import com.joshua.demo.entities.Stock;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("api/stockmarket")
public class StockRest {

    private StockService service;
    public StockRest(StockService service){
        this.service = service;
    }

    @GetMapping
    @ResponseBody
    public ResponseEntity<Map<String, Object>> getAllStocks(){
        try {
            List<StockDto> s = service.getAllStocks();
            Map<String, Object> response = new HashMap<>();
            response.put("Stocks", s);
            return ResponseEntity.ok(response);
        }catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id){
        try {
            StockDto s = service.getStockById(id);
            return ResponseEntity.ok(s);
        }
        catch (Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @PostMapping
    public ResponseEntity<?> AddStock(@RequestBody Stock stock){
        try {
            StockDto st = service.addStock(stock);
            return ResponseEntity.ok(st);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @PutMapping("/{id}")
    public ResponseEntity<StockDto> UpdateStock(@PathVariable Integer id, @RequestBody Stock stock){
        try{
            stock.setId(id);
            StockDto s = service.updateStock(stock);
            return ResponseEntity.ok(s);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<StockDto> DeleteStock(@PathVariable Integer id){
        try{
            StockDto s = service.getStockById(id);
            service.deleteStock(s);
            return ResponseEntity.ok(s);
        }
        catch(Exception e){
            return ResponseEntity.status(404).body(null);
        }
    }
}
