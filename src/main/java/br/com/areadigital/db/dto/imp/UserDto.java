package br.com.areadigital.db.dto.imp;

import br.com.areadigital.db.dto.IBaseDTO;
import br.com.areadigital.db.model.Role;
import lombok.*;
import org.codehaus.jackson.annotate.JsonProperty;

import javax.validation.constraints.Size;
import java.util.Set;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDto implements IBaseDTO<Long> {
    private static final long serialVersionUID = 1L;
    private Long id;
    @JsonProperty("first_name")
    private String firstname;
    private String lastname;
    @Size(max = 255)
    private String email;
    private Set<Role> roles;



}