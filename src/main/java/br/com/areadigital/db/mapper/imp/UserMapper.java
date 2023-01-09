package br.com.areadigital.db.mapper.imp;

import br.com.areadigital.db.dto.imp.UserDto;
import br.com.areadigital.db.mapper.EntityMapper;
import br.com.areadigital.db.model.User;
import org.mapstruct.Mapper;

import java.io.Serializable;

@Mapper(componentModel = "spring")
public interface UserMapper extends EntityMapper<UserDto, User>, Serializable {
}