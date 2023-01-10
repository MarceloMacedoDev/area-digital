package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import br.com.areadigital.db.model.product.Category;
import br.com.areadigital.db.model.product.Provider;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductDto implements IBaseDTO<Long> {
    private long serialVersionUID;
    private Long id;
    private String name;
    @Size(max = 255)
    private String description;
    private Double price;
    private String shortDescription;
    private List<String> urlImagsProduct;
    private String visibility;
    private Instant date;
    @NotEmpty(message = "Produto sem categoria não é permitido")
    private List<CategoryDto> categories = new ArrayList<>();
    private List<String> tagsCategoria = new ArrayList<>();
    private List<BaseDto> providers = new ArrayList<>();

}