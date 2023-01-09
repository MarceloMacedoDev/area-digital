package br.com.areadigital.web.controller.v1;

import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.web.controller.ABaseController;
import br.com.areadigital.web.service.v1.CompanyService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Data
@RestController
@RequestMapping("/v1/companies")
@RequiredArgsConstructor
public class CompanyController extends ABaseController<CompanyDto, Long> {
    private final CompanyService service;

    @GetMapping("/cnpj/{cnpj}")
    public ResponseEntity<CompanyDto> findcnpj(@PathVariable("cnpj") String cnpj) {


        return ResponseEntity.ok(service.findcnpj(cnpj));
    }
}
