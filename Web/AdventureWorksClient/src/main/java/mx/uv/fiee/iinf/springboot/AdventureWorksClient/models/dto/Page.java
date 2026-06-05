package mx.uv.fiee.iinf.springboot.AdventureWorksClient.models.dto;

import org.springframework.data.domain.Sort;

public record Page(
        int size,
        int number,
        String sort
)
{}
