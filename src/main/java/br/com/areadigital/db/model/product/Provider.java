package br.com.areadigital.db.model.product;

import br.com.areadigital.db.converter.DateConverter;
import br.com.areadigital.db.model.IBaseEntity;
import br.com.areadigital.db.model.company.AtividadePrincipal;
import br.com.areadigital.db.model.company.AtividadesSecundaria;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
@Entity(name = "tb_provider")
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class Provider implements Serializable , IBaseEntity<Long> {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Convert(converter = DateConverter.class)
    private String abertura;

    @JsonProperty(value = "tb_provider_atividade_principal")
    @OneToMany(mappedBy = "company")
    private List<AtividadePrincipal> atividadePrincipal  ;

    @JsonProperty(value = "tb_pbr.com.areadigital.webrovider_atividades_secundarias")
    @OneToMany(mappedBy = "company")
    private List<AtividadesSecundaria> atividadesSecundaria ;

    @ManyToMany(mappedBy = "providers")
    private List<Product> products = new ArrayList<>();

    private String bairro;
    @JsonProperty(value = "capital_social")
    private String capitalSocial;
    private String cep;
    private String cnpj;
    private String complemento;
    @JsonProperty(value = "data_especial")
    private String dataSituacao;
    @JsonProperty(value = "data_situacao_especial")
    private String dataSituacaoEspecial;
    private String efr;
    private String email;
    //    private Extra extra;
    private String fantasia;
    private String logradouro;
    @JsonProperty(value = "motivo_situacao")
    private String motivoSituacao;
    private String municipio;
    @JsonProperty(value = "natureza_juridica")
    private String naturezaJuridica;
    private String nome;
    private String numero;
    private String porte;
    //    private List<Object> qsa;
    private String situacao;
    @JsonProperty(value = "situacao_especial")
    private String situacaoEspecial;
    private String status;
    private String telefone;
    private String tipo;
    private String uf;
    @JsonProperty(value = "ultima_atualizacao")
    private String ultimaAtualizacao;



    // Construtor, getters e setters omitidos por brevidade
}