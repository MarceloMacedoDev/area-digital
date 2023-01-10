package br.com.areadigital.web.service;

import br.com.areadigital.db.dto.IBaseDTO;
import br.com.areadigital.db.mapper.EntityMapper;
import br.com.areadigital.db.model.IBaseEntity;
import br.com.areadigital.util.Util;
import br.com.areadigital.web.service.exceptions.ResourceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

/**
 * Classe abstrata de serviço que fornece funcionalidades básicas para operações de CRUD.
 * Esta classe implementa a interface {@link  IBaseService} e é serializável.
 *
 * @param <D> o tipo de objeto DTO (Data Transfer Object) manipulado pelo serviço
 * @param <E> o tipo de entidade de banco de dados manipulada pelo serviço
 * @param <K> o tipo de chave primária da entidade de banco de dados manipulada pelo serviço
 */
@Slf4j
public abstract class ABaseService<D extends IBaseDTO<K>, E extends IBaseEntity<K>, K> implements IBaseService<D, K>, Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * Retorna o mapeador de entidades para DTOs utilizado por este serviço.
     *
     * @return o mapeador de entidades para DTOs utilizado por este serviço
     */
    abstract public EntityMapper<D, E> getEntityMapper();

    /**
     * Retorna o repositório JPA utilizado por este serviço.
     *
     * @return o repositório JPA utilizado por este serviço
     */
    abstract public JpaRepository<E, K> getRepository();

    /**
     * {@inheritDoc}
     */
    @Override
    public D save(D objectDTO) {
        preSave(objectDTO);
        E entity = getEntityMapper().toEntity(objectDTO);
        posSave(objectDTO);
        return getEntityMapper().toDto((E) getRepository().save(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteById(K id) {
        try {
            preDelete(id);
            getRepository().deleteById(id);
            posDelete(id);
        } catch (Exception e) {
            throw new ResourceNotFoundException("non-existent data");
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public D findById(K id) {
        return getEntityMapper().toDto(getRepository().findById(id).orElseThrow(() -> new ResourceNotFoundException("not found")));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<D> findByCondition(D objectDTO, Pageable pageable) {
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public D update(D objectDTO, K id) {
        E entity = (E) getRepository().findById(id).orElseThrow(
                () -> new ResourceNotFoundException("non-existent data")
        );
        preUpdate(objectDTO);
        BeanUtils.copyProperties(objectDTO, entity, Util.getNullProperties(objectDTO));
        posUpdate(objectDTO);
        return save(getEntityMapper().toDto(entity));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<D> findAll() {
        List<D> list = getEntityMapper().toDto(getRepository().findAll());
        return list;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preSave(D objectDTO) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void posSave(D objectDTO) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preUpdate(D objectDTO) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void posUpdate(D objectDTO) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void preDelete(K id) {

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void posDelete(K id) {

    }
}
