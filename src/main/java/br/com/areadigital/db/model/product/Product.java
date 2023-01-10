package br.com.areadigital.db.model.product;

import br.com.areadigital.db.converter.VisibilityCategoriaConverter;
import br.com.areadigital.db.model.IBaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.*;

@Data
@Entity(name = "tb_product")
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product implements Serializable, IBaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @Lob
    @Column(columnDefinition = "TEXT")
    private String description;
    private Double price;
    private String shortDescription;
    @ElementCollection
    @CollectionTable(name = "tb_product_urlimagsproduct")
    private List<String> urlImagsProduct = new ArrayList<>();
    @Convert(converter = VisibilityCategoriaConverter.class)
    private String visibility;

    @Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private Instant date;

    @ManyToMany
    @JoinTable(name = "tb_product_category",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    List<Category> categories = new ArrayList<>();

    @ElementCollection
    @CollectionTable(name = "tb_product_tagscategoria")
    private List<String> tagsCategoria = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "tb_product_provider",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "provider_id"))
    List<Provider> providers = new ArrayList<>();
}
