package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

        public List<ProductDto> getProducts(String  category, Double price) {
            return List.of(
                    new ProductDto("Product 101", "Category 1", "100.0"),
                    new ProductDto("Product 201", "Category 2", "200.0"),
                    new ProductDto("Product 301", "Category 1", "150.0")
            );
        }

}
