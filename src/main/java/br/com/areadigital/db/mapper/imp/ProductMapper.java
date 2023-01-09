package br.com.areadigital.db.mapper.imp;

import br.com.areadigital.db.mapper.EntityMapper;
import br.com.areadigital.db.dto.imp.ProductDto;
import br.com.areadigital.db.model.product.Product;
import org.mapstruct.Mapper;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface ProductMapper extends EntityMapper<ProductDto, Product>, Serializable {
}