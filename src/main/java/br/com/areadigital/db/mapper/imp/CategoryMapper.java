package br.com.areadigital.db.mapper.imp;

import br.com.areadigital.db.dto.imp.CategoryDto;
import br.com.areadigital.db.mapper.EntityMapper;
import br.com.areadigital.db.model.product.Category;
import org.mapstruct.Mapper;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface CategoryMapper extends EntityMapper<CategoryDto, Category>, Serializable {
}