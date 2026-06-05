package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories.IProductRepository;

import java.util.List;

public interface IProductStrategy
{
    List<ProductDto> getProducts(IProductRepository productRepository, String category, Double price);
}