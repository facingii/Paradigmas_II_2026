package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.strategy;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductStrategy;

import java.util.List;

public class ProductServiceContext
{
    private final IProductStrategy strategy;

    public ProductServiceContext (IProductStrategy strategy)
    {
        this.strategy = strategy;
    }

    public List<ProductDto> executeStrategy (IProductRepository productRepository, String category, Double price)
    {
        return strategy.getProducts(productRepository, category, price);
    }

    public static IProductStrategy createStrategy (String category, Double price)
    {
        if (category == null) {
            category = "";
        }

        if  (price == null) {
            price = -1.0;
        }

        if (category.isEmpty() && price < 0)
        {
            return new ProductUnfilteredStrategy ();
        }

        if (category.isEmpty()) {
            return new ProductByPriceStrategy();
        } else if (price < 0) {
            return new ProductByCategoryStrategy();
        }

        return new ProductByCategoryAndPriceStrategy();
    }
}


