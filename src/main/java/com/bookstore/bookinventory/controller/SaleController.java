package com.bookstore.bookinventory.controller;

import com.bookstore.bookinventory.model.Sale;
import com.bookstore.bookinventory.service.SaleService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sales")
public class SaleController {

    private final SaleService saleService;

    public SaleController(SaleService saleService) {
        this.saleService = saleService;
    }

    @PostMapping
    public Sale createSale(@RequestBody Sale sale) {
        return saleService.save(sale);
    }

    @GetMapping
    public List<Sale> getAllSales() {
        return saleService.findAll();
    }

    @GetMapping("/{id}")
    public Sale getSaleById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteSale(@PathVariable Long id) {
        saleService.delete(id);
    }

    @GetMapping("/report")
public String getSalesReport() {
    // simple mock report (since no full reporting implemented yet)
    return "Sales report feature - not implemented yet.";
}

}
