package mx.uv.fiee.iinf.springboot.AdventureWorksClient.repositories;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.Product;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto.ProductDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.List;

public interface IProductRepository extends JpaRepository<Product, Long>
{
    @Query(
            value = "SELECT p.productID AS productID, p.name AS name, pc.name AS category, p.listPrice AS price FROM Product p " +
                    "INNER JOIN ProductSubcategory ps ON ps.productSubcategoryID = p.productSubcategoryID " +
                    "INNER JOIN ProductCategory pc ON pc.productCategoryID = ps.productCategoryID " +
                    "WHERE pc.name = ?1"
    )
    List<ProductDto> findAllProductsByCategory (String category);

    @Query(
            value = "SELECT p.productID AS productID, p.name AS name, pc.name AS category, p.listPrice AS price FROM Product p " +
                    "JOIN ProductSubcategory ps ON ps.productSubcategoryID = p.productSubcategoryID " +
                    "JOIN ProductCategory pc ON pc.productCategoryID = ps.productCategoryID " +
                    "WHERE p.listPrice >= ?1"
    )
    List<ProductDto> findAllProductsByListPrice (BigDecimal price);

    @Query(
            value = "SELECT p.productID AS productID, p.name AS name, pc.name AS category, p.listPrice AS price FROM Product p " +
                    "JOIN ProductSubcategory ps ON ps.productSubcategoryID = p.productSubcategoryID " +
                    "JOIN ProductCategory pc ON pc.productCategoryID = ps.productCategoryID " +
                    "WHERE pc.name = ?1 AND p.listPrice >= ?2"
    )
    List<ProductDto> findAllProductsByCategoryAndPriceGreaterThanEqual (String category, BigDecimal price);

    @Query(
            value = "SELECT p.productID AS productID, p.name AS name, pc.name AS category, p.listPrice AS price FROM Product p " +
                    "JOIN ProductSubcategory ps ON ps.productSubcategoryID = p.productSubcategoryID " +
                    "JOIN ProductCategory pc ON pc.productCategoryID = ps.productCategoryID "
    )
    List<ProductDto> findAllProductPageable (Pageable pageable);

    @Query(
            value = "SELECT p FROM Product p " +
                    "WHERE p.productID = ?1"
    )
    Product findProductById (Long productID);
}
