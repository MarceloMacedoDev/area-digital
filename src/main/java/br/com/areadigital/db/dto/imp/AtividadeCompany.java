
package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.model.company.Company;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AtividadeCompany implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String code;
    private String text;
    private BaseDto company;

}
