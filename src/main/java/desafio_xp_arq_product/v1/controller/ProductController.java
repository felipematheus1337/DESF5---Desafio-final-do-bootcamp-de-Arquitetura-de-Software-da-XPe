package desafio_xp_arq_product.v1.controller;

import desafio_xp_arq_product.v1.model.Product;
import desafio_xp_arq_product.v1.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService service;

    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return ResponseEntity.ok(service.create(product));

    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        return ResponseEntity.ok(service.findAll());

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @GetMapping
    public ResponseEntity<Product> findByName(@RequestParam(name = "nome") String name) {
        return ResponseEntity.ok(service.findByName(name));

    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(Product product) {
        return ResponseEntity.ok(service.update(product));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        return ResponseEntity.ok(service.delete(id));
    }

    @GetMapping("/count")
    public ResponseEntity<TotalProductsResponse> countProducts() {
        return ResponseEntity.ok(service.countProducts());

    }


}
