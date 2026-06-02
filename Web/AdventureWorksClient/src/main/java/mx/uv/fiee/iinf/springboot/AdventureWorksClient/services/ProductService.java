package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    public List<ProductDto> getProducts(String category, Double price) {
        if (category == null || category.equals("")) {
            throw new IllegalArgumentException("category cannot be null or empty");
        }

        if (price == null || price < 0) {
            throw new IllegalArgumentException("price cannot be null or negative");
        }

//        var products = productRepository.findAll ();
//
//        var results = new LinkedList<ProductDto>();
//        for (var product : products) {
//            results.add (new ProductDto(
//                    product.getName(),
//                    "",
//                    product.getListPrice()
//            ));
//        }
//

//        var results = productRepository.findAllProductsByCategory(category);
//        var results = productRepository.findAllProductsByListPrice(new BigDecimal(price));
        var results = productRepository.findAllProductsByCategoryAndPriceGreaterThanEqual (category, new BigDecimal(price));

        return results;
    }
}

