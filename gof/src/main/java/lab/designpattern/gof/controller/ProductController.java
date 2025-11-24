package lab.designpattern.gof.controller;

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

    @GetMapping
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


    @PostMapping
    public Product create(@RequestBody Product p) {
        System.out.println("Recebi -> name: " + p.getName() + ", price: " + p.getPrice()); //Teste pra ver se recebeu mesmo
        return service.save(p);
    }
}