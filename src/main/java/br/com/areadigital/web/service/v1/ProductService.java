package br.com.areadigital.web.service.v1;

import br.com.areadigital.db.dto.imp.ProductDto;
import br.com.areadigital.db.mapper.imp.ProductMapper;
import br.com.areadigital.db.model.product.Product;
import br.com.areadigital.db.repository.ProductRepository;
import br.com.areadigital.web.service.ABaseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class ProductService extends ABaseService<ProductDto, Product, Long> {


private final ProductRepository repository;
private final ProductMapper entityMapper;


}