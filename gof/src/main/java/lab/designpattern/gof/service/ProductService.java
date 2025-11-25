package lab.designpattern.gof.service;

import lab.designpattern.gof.dto.ProductDTO;
import lab.designpattern.gof.feign.ExternalProductClient;
import lab.designpattern.gof.feign.ExternalProductDTO;
import lab.designpattern.gof.model.Product;
import lab.designpattern.gof.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;
    private final ExternalProductClient externalClient;

    public ProductService(ProductRepository repository, ExternalProductClient externalClient) {
        this.repository = repository;
        this.externalClient = externalClient;
    }

    public List<Product> listAll() {
        return repository.findAll();
    }

    public Product save(ProductDTO dto) {
        Product p = new Product();
        p.setName(dto.getName());
        p.setPrice(dto.getPrice());
        return repository.save(p);
    }

    public List<ExternalProductDTO> listExternalProducts() {
        return externalClient.getProducts();
    }

    public Product findById(Long id){
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
    }

    public Product delete(Long id) {
        return repository.findById(id)
                .map(produto -> {
                    repository.deleteById(id);
                    return produto;
                })
                .orElseThrow(() -> new RuntimeException("Produto não encontrado"));
    }


    public Product update(Long id, Product newData) {
        return repository.findById(id).map(existing -> {existing.setName(newData.getName());
        existing.setPrice(newData.getPrice());
        return repository.save(existing);
        })
                .orElseThrow(() -> new RuntimeException("Produto nao encontrado"));
    }
}