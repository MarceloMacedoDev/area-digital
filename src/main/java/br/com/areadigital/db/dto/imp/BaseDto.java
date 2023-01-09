package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseDto implements Serializable, IBaseDTO<Long> {
    private static final long serialVersionUID = 1L;

    private Long id;
    private String name;
}
