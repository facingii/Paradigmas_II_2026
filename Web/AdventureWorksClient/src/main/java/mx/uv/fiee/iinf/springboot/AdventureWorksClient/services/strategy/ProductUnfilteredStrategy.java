package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.strategy;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductStrategy;

import java.util.List;

public class ProductUnfilteredStrategy implements IProductStrategy
{
    @Override
    public List<ProductDto> getProducts(IProductRepository productRepository, String category, Double price) {
        return productRepository.findAll ()
                .stream()
                .map(product -> new ProductDto(
                        product.getProductID(),
                        product.getName(),
                        "",
                        product.getListPrice()
                )).toList();
    }
}

