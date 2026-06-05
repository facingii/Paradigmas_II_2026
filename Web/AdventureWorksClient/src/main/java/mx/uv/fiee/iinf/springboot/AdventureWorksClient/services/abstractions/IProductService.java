package mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.Product;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.Page;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<ProductDto> getAllProducts (Page page);
    List<ProductDto> getProducts (String category, Double price);
    Product findProductById (Long id);

}
