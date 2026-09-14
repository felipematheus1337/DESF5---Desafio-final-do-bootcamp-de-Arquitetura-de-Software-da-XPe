package desafio_xp_arq_product.v1.controller;

import desafio_xp_arq_product.v1.model.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {


    @PostMapping
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

    }

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") Long id) {

    }

    @GetMapping
    public ResponseEntity<Product> findByName(@RequestParam(name = "nome") String name) {

    }

    @PutMapping
    public ResponseEntity<Product> updateProduct(Product product) {

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {

    }

    @GetMapping("/count")
    public ResponseEntity<TotalProductsResponse> countProducts() {

    }


}
