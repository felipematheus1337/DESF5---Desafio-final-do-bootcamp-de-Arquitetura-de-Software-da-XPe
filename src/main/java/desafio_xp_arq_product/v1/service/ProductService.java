package desafio_xp_arq_product.v1.service;

import desafio_xp_arq_product.v1.controller.TotalProductsResponse;
import desafio_xp_arq_product.v1.exception.BusinessException;
import desafio_xp_arq_product.v1.model.Product;
import desafio_xp_arq_product.v1.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    public Product create(Product product) {
        return repository.save(product);
    }

    public List<Product> findAll() {
        return repository.findAll();
    }

    public Product findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new BusinessException("Product with ID " + id + " not found"));
    }

    public Product findByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new BusinessException("Product with name " + name + " not found"));
    }

    public Product update(Product product) {
        if (!repository.existsById(product.getId())) {
            throw new BusinessException("Product with ID " + product.getId() + " does not exist");
        }
        return repository.save(product);
    }

    public Void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new BusinessException("Product with ID " + id + " does not exist");
        }
        repository.deleteById(id);
        return null;
    }

    public TotalProductsResponse countProducts() {
        long count = repository.count();
        return new TotalProductsResponse(count);
    }
}
