package poly.edu.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import poly.edu.domain.Product;
import poly.edu.service.ProductService;

import java.util.List;
import java.util.Optional;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @RequestMapping("/product/list")
    public  String list(Model model){
//        List<Product> list = productService.findAll();
//        model.addAttribute("items",list);
        return "admins/web/index";
    }

    @RequestMapping("/product/detail/{id}")
    public String detail(Model model, @PathVariable("id") Integer id){
        Optional<Product> product = productService.findById(id);
        if(product.isPresent()){
            Product p = product.get();
            model.addAttribute("pitem", p);
        }
        return "admins/web/single-product";
    }

    @RequestMapping("/cart/views")
    public String viewCart(Model model){
        return "admins/web/viewCart";
    }
}
