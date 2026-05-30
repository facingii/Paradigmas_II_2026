package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;

import java.util.List;

public interface IProductService {

    List<ProductDto> getProducts(String category, Double price);

}
