package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

@JsonIgnoreProperties(ignoreUnknown = true)
public class CompanyDto implements Serializable, IBaseDTO<Long> {
    private Long id;
    private String abertura;

    @JsonProperty(value = "atividade_principal")
    private List<AtividadeCompany> atividadePrincipal = new ArrayList<>();

    @JsonProperty(value = "atividades_secundarias")
    private List<AtividadeCompany> atividadesSecundaria = new ArrayList<>();

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


}