package mx.uv.fiee.iinf.springboot.AdventureWorksClient.controllers;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.Product;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.Page;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.ProductService;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public String GetProducts (@RequestParam(required = true) int size,
                                         @RequestParam(required = true) int number,
                                         Model model)
    {
        //return productService.getAllProducts(new Page(size, number, "productID"));
        var products = productService.getAllProducts (new Page (size, number, "productID"));
        model.addAttribute ("products", products);
        return "products";
    }

    @GetMapping("/search")
    public String search (@RequestParam(required = false) String category,
                           @RequestParam(required = false) Double price,
                          Model model)
    {
         var products = productService.getProducts (category, price);
         model.addAttribute ("products", products);
         return "search";
    }


    @GetMapping("/new")
    public String createProduct (Model model)
    {
        model.addAttribute ("product", new Product ());
        return "addProduct";
    }

    @PostMapping("/addProduct")
    public String createProduct (
            @Validated Product product,
            BindingResult result,
            Model model
    )
    {
        if (result.hasErrors ()) {
            return "addProduct";
        }

        model.addAttribute ("product", product);
        return "productAdded";
    }

    @GetMapping("/edit/{id}")
    public String updateProduct (@PathVariable long id, Model model)
    {
        var product = productService.findProductById (id);


        model.addAttribute ("product", product);
        return "editProduct";
    }

    @PostMapping("/edit/{id}")
    public String updateProduct (@PathVariable int id,
                                 @Validated Product product,
                                 BindingResult result,
                                 Model model)
    {
        if (result.hasErrors ()) {
            return "productEdited";
        }

        model.addAttribute ("product", product);
        return "productEdited";
    }
}
