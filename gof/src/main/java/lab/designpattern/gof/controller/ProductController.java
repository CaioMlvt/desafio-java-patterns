package lab.designpattern.gof.controller;

import jakarta.validation.Valid;
import lab.designpattern.gof.dto.ProductDTO;
import lab.designpattern.gof.feign.ExternalProductDTO;
import lab.designpattern.gof.model.Product;

import org.springframework.web.bind.annotation.*;
import lab.designpattern.gof.service.ProductService;

import java.util.List;


@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<Product> getAll() {
        return service.listAll();
    }



    @GetMapping("/external")
    public List<ExternalProductDTO> getExternal() {
        return service.listExternalProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return service.findById(id);
    }

    @DeleteMapping("/{id}")
    public Product delete(@PathVariable Long id){
        return service.delete(id);
    }


    @PutMapping("/{id}")
    public Product update (@PathVariable Long id, @Valid @RequestBody Product p){
        return service.update(id,p);
    }


    @PostMapping
    public Product create(@Valid @RequestBody ProductDTO dto) {
        System.out.println("Recebi -> name: " + dto.getName() + ", price: " + dto.getPrice()); //Teste pra ver se recebeu mesmo
        return service.save(dto);
    }
}