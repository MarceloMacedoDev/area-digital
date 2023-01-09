package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import br.com.areadigital.db.model.product.Category;
import br.com.areadigital.db.model.product.Provider;
import lombok.*;

import javax.validation.constraints.Size;
import java.time.Instant;
import java.util.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class ProductDto  implements IBaseDTO<Long> {
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
    private List<BaseDto> categories;
    private List<String> tagsCategoria;
    private List<BaseDto> providers;

}