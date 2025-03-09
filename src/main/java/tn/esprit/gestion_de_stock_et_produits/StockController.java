package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @DeleteMapping("/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
