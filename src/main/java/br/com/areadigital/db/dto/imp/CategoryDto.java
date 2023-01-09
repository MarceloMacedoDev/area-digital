package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto implements Serializable, IBaseDTO<Long> {

    private Long id;
    private String name;
    private String description;
    private String visibility;
    private List<String> tagsCategoria = new ArrayList<>();
    private List<String> imagesCategoria = new ArrayList<>();

}
