package br.com.areadigital.web.controller.v1;

import br.com.areadigital.db.dto.imp.CategoryDto;
import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.web.controller.ABaseController;
import br.com.areadigital.web.service.v1.CategoryService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@Data
@RestController
@RequestMapping("/v1/categories")
@RequiredArgsConstructor
public class CategoryController extends ABaseController<CategoryDto, Long> {
    private final CategoryService service;


}