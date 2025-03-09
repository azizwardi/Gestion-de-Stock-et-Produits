package tn.esprit.gestion_de_stock_et_produits;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService {
    @Autowired
    private StockRepository stockRepository;

    public List<Stock> getAllStocks() {
        return stockRepository.findAll();
    }

    public Stock getStockById(Long id) {
        return stockRepository.findById(id).orElse(null);
    }

    public Stock addStock(Stock stock) {
        return stockRepository.save(stock);
    }

    public void deleteStock(Long id) {
        stockRepository.deleteById(id);
    }
}
