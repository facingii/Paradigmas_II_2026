package mx.uv.fiee.iinf.springboot.AdventureWorksClient.controllers;

import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.ProductService;
import mx.uv.fiee.iinf.springboot.AdventureWorksClient.services.abstractions.IProductService;
import org.jspecify.annotations.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/sales")
public class SalesController {
    @Autowired
    IProductService productService;

    @GetMapping("/month/{month}")
    public ResponseEntity<@NonNull String> GetSalesByMonth (@PathVariable int month)
    {
        var headers = new HttpHeaders();
        headers.add ("X-APPLICATION-VALUE", "1989");

        var resp = new ResponseEntity<@NonNull String>(
                "Sales by Month: " + month,
                headers,
                HttpStatus.CREATED
        );

        return resp;
    }

    @GetMapping("/month/calendar/{name}")
    public String GetSalesByMonthName (@PathVariable String name)
    {
        return "Sales by Month: " + name;
    }

    @GetMapping("/year/{year}")
    public String GetSalesByYear (@PathVariable int year)
    {
        return "Sales by Year: " + year;
    }

}

