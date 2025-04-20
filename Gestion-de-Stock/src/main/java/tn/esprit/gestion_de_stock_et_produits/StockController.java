package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/stocks")
public class StockController {
    @Autowired
    private StockService stockService;

    @GetMapping("/get-all-stocks")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GetMapping("/get-stock/{id}")
    public Stock getStockById(@PathVariable Long id) {
        return stockService.getStockById(id);
    }

    @PostMapping("/add-stock")
    public Stock addStock(@RequestBody Stock stock) {
        return stockService.addStock(stock);
    }

    @DeleteMapping("/delete-stock/{id}")
    public void deleteStock(@PathVariable Long id) {
        stockService.deleteStock(id);
    }
}
