package poly.edu.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import poly.edu.domain.Product;
import poly.edu.service.ProductService;

import java.util.List;
import java.util.Optional;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
    @Autowired
    ProductService productService;

    @GetMapping()
    public List<Product> getAll(){
        return  productService.findAll();
    }
    @GetMapping("{id}")
    public Optional<Product> getOne(@PathVariable("id") Integer id){
        return  productService.findById(id);
    }

    @PostMapping()
    public Product create(@RequestBody Product product){
        return productService.save(product);
    }

    @PutMapping("{id}")
    public Product update(@PathVariable("id") Integer id,@RequestBody Product product){
        return productService.save(product);
    }

    @DeleteMapping ("{id}")
    public void delete(@PathVariable("id") Integer id){
         productService.deleteById(id);
    }
}
