package br.com.areadigital.db.model.product;

import br.com.areadigital.db.converter.VisibilityCategoriaConverter;
import br.com.areadigital.db.model.IBaseEntity;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Entity(name = "tb_category")
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
    @CollectionTable(name = "tb_category_tagscategoria")
    private List<String> tagsCategoria = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_category_imagescategoria")
    private List<String> imagesCategoria = new ArrayList<>();

    @ManyToMany(mappedBy = "categories")
    private List<Product> products = new ArrayList<>();

}
