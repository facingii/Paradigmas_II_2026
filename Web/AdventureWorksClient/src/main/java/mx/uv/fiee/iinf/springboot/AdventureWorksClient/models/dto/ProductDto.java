package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto;

import java.math.BigDecimal;

public record ProductDto (
    Long productID,
    String name,
    String category,
    BigDecimal price
)
{}
