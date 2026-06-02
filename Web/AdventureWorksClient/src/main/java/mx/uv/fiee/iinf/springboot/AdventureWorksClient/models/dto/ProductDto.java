package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto;

import java.math.BigDecimal;

public record ProductDto (
    String name,
    String category,
    BigDecimal price
)
{}
