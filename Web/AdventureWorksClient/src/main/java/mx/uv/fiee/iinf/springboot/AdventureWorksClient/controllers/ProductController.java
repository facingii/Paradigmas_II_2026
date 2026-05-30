package mx.uv.fiee.iinf.springboot.AdventureWorksClient.controllers;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.Product;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.ProductService;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    IProductService productService;

    @GetMapping
    public String GetProducts ()
    {
        return "Product List";
    }

    @GetMapping("/search")
    public List<ProductDto> search (@RequestParam(required = false) String category,
                           @RequestParam(required = false) Double price)
    {
        return productService.getProducts(category, price);
    }

    @PostMapping
    public ResponseEntity<@NonNull String> createProduct (@RequestBody Product product)
    {
        return new ResponseEntity<>(
                product.toString(),
                HttpStatus.CREATED
        );
    }
}
