package br.com.areadigital.db.enums;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public enum RolesEnum {
    ADMIN("ROLE_ADMG","Administrador Geral"),
    CLIENTE("ROLE_CLIENTE","Cliente"),
    PARCEIRO("ROLE_PARCEIRO","Parceiro"),
    FINANCEIRO("ROLE_OPF","Operador  Financeiro" ),
    SERVICO("ROLE_SRV","Operador de Serviços"),
    PROVIDER("ROLE_FORN","Fornecedor"),
    PARTNER("ROLE_PARTNER","Partner"),
    ESTOQUE ("ROLE_EST","Operador de Estoque"),
    ADMINESTOQUE ("ROLE_ADMEST","Estoquista")
    ;

    private String id;
    private String descricao;



    private RolesEnum(String valor, String descricao) {
        this.id = valor;
        this.descricao = descricao;
    }

    public static String getIdEnum(String descricao) {

        for (RolesEnum e : values()) {
            if (e.getDescricao().equals(descricao) )
                return e.getId() ;
        }
        return null;
    }

    public static String getDescricaoEnum(String id) {

        for (RolesEnum e : values()) {
            if (e.getId().equals(id) )
                return e.getDescricao() ;
        }
        return null;
    }



    public static RolesEnum findById(String s) {

        for (RolesEnum e : values()) {
            if (e.getDescricao().equals(s) )
                return e ;
        }
        return null;
    }

}
