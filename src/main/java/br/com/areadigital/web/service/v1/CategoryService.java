package br.com.areadigital.web.service.v1;

import br.com.areadigital.db.dto.imp.CategoryDto;
import br.com.areadigital.db.mapper.imp.CategoryMapper;
import br.com.areadigital.db.model.product.Category;
import br.com.areadigital.db.repository.CategoryRepository;
import br.com.areadigital.web.service.ABaseService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Data
@Service
@RequiredArgsConstructor
public class CategoryService  extends ABaseService<CategoryDto, Category,Long> {
    private final CategoryRepository repository;
    private final CategoryMapper entityMapper;

}