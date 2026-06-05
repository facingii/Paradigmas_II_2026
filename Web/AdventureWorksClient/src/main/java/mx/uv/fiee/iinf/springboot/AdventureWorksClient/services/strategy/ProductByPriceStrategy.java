package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.strategy;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductStrategy;

import java.math.BigDecimal;
import java.util.List;

public class ProductByPriceStrategy implements IProductStrategy
{
    @Override
    public List<ProductDto> getProducts(IProductRepository productRepository, String category, Double price) {
        return productRepository.findAllProductsByListPrice(new BigDecimal(price));
    }
}

