package br.com.areadigital.db.model.product;

import br.com.areadigital.db.converter.VisibilityCategoriaConverter;
import br.com.areadigital.db.model.IBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Category implements Serializable, IBaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Lob
    private String description;

    @Convert(converter = VisibilityCategoriaConverter.class)
    private String visibility;

    @ElementCollection
    @CollectionTable(name = "TagsCategoria")
    private List<String> tagsCategoria = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "ImagesCategoria")
    private List<String> imagesCategoria = new ArrayList<>();


}
