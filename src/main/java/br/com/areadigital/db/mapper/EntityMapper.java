package br.com.areadigital.db.mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

public interface EntityMapper<D  , E> extends Serializable {

    E toEntity(D dto);

    D toDto(E entity);

    List<E> toEntity(List<D> dtoList);

    List<D> toDto(List<E> entityList);

    Set<D> toDto(Set<E> entityList);
}
