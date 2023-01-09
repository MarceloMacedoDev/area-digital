package br.com.areadigital.web.controller.v1;

import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.db.dto.imp.ProductDto;
import br.com.areadigital.web.controller.ABaseController;
import br.com.areadigital.web.service.v1.CompanyService;
import br.com.areadigital.web.service.v1.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Data
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController extends ABaseController<ProductDto, Long> {
    private final ProductService service;

}