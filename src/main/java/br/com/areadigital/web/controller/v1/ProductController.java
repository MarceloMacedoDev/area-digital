package br.com.areadigital.web.controller.v1;

import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.db.dto.imp.ProductDto;
import br.com.areadigital.web.controller.ABaseController;
import br.com.areadigital.web.service.v1.CompanyService;
import br.com.areadigital.web.service.v1.ProductService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@Data
@RestController
@RequestMapping("/v1/products")
@RequiredArgsConstructor
public class ProductController extends ABaseController<ProductDto, Long> {
    private final ProductService service;

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<ProductDto> save(@RequestBody @Validated ProductDto objectDTO) {
        objectDTO = getService().save(objectDTO);
        return ResponseEntity.ok().body(objectDTO);
    }
}