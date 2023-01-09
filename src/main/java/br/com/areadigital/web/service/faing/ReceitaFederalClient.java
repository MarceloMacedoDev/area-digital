package br.com.areadigital.web.service.faing;

import br.com.areadigital.db.model.company.Company;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "receitaws", url = "https://www.receitaws.com.br/v1/cnpj")
public interface ReceitaFederalClient {

    @GetMapping(value = "/{cnpj}")
    Company    recuperarDadosEmpresaPorCnpj(@PathVariable("cnpj") String cnpj);
}