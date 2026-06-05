package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.Product;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.Page;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.strategy.ProductServiceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IProductService {
    @Autowired
    IProductRepository productRepository;

    public List<ProductDto> getAllProducts (Page page)
    {
        var pageable = PageRequest.of (
                page.number (),
                page.size (),
                Sort.by (Sort.Order.asc (page.sort ()))
        );

        return productRepository.findAllProductPageable(pageable);
    }

    public List<ProductDto> getProducts(String category, Double price) {
//        List<ProductDto> results;

//        if (category == null || category.equals("")
//        || price == null || price < 0) {
//
//        }
//
//        if (price == null || price < 0) {
//            throw new IllegalArgumentException("price cannot be null or negative");
//        }

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
//        var results = productRepository.findAllProductsByCategoryAndPriceGreaterThanEqual (category, new BigDecimal(price));

//        return results;

        // applying strategy pattern
        var serviceContext = new ProductServiceContext(ProductServiceContext.createStrategy (category, price));
        return serviceContext.executeStrategy (productRepository, category, price);
    }

    public Product findProductById (Long id)
    {
        return productRepository.findProductById (id);
    }
}
