package br.com.areadigital.web.service.v1;

import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.db.mapper.imp.CompanyMapper;
import br.com.areadigital.db.model.company.Company;
import br.com.areadigital.db.repository.CompanyRepository;
import br.com.areadigital.web.service.ABaseService;
import br.com.areadigital.web.service.exceptions.ResourceNotFoundException;
import br.com.areadigital.web.service.faing.ReceitaFederalClient;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class CompanyService extends ABaseService<CompanyDto, Company, Long> {


    private final ReceitaFederalClient receitaFederalClient;
    private final CompanyRepository repository;
    private final CompanyMapper entityMapper;

    public CompanyDto findcnpj(String cnpj) {
        try {
            Company company = receitaFederalClient.recuperarDadosEmpresaPorCnpj(cnpj);
            CompanyDto companyDto = entityMapper.toDto((company));
            companyDto = save(companyDto);
            return companyDto;
        } catch (Exception e) {
            throw new ResourceNotFoundException("non-existent cnpj");
        }
    }
}
