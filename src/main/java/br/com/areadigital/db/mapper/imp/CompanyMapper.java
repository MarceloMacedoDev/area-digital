package br.com.areadigital.db.mapper.imp;

import br.com.areadigital.db.dto.imp.CompanyDto;
import br.com.areadigital.db.dto.imp.UserDto;
import br.com.areadigital.db.mapper.EntityMapper;
import br.com.areadigital.db.model.User;
import br.com.areadigital.db.model.company.Company;
import org.mapstruct.Mapper;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface CompanyMapper extends EntityMapper<CompanyDto, Company>, Serializable {
}