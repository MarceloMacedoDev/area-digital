package br.com.areadigital.web.controller;

import br.com.areadigital.db.dto.IBaseDTO;
import br.com.areadigital.web.service.IBaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * Classe abstrata de controlador que fornece funcionalidades básicas para operações de CRUD.
 * Esta classe implementa a interface {@link IBaseController} e é serializável.
 *
 * @param <D> o tipo de objeto DTO (Data Transfer Object) manipulado pelo controlador
 * @param <K> o tipo de chave primária da entidade de banco de dados manipulada pelo controlador
 */
@Slf4j
public abstract class ABaseController<D extends IBaseDTO<K>, K> implements IBaseController<D, K>, Serializable {

    private static final long serialVersionUID = 1L;
    /**
     * Retorna o serviço de negócios utilizado por este controlador.
     *
     * @return o serviço de negócios utilizado por este controlador
     */
    abstract public  IBaseService<D, K> getService();

    /**
     * Salva um novo DTO.
     *
     * @param objectDTO o DTO a ser salvo
     * @return o DTO salvo
     */
    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<D> save(@RequestBody @Validated D objectDTO) {
        objectDTO = getService().save(objectDTO);
        return ResponseEntity.ok().body(objectDTO);
    }

    /**
     * Recupera um DTO pelo ID.
     *
     * @param id o ID do DTO a ser recuperado
     * @return o DTO recuperado
     */
    @Override
    @GetMapping("/{id}")
    public ResponseEntity<D> findById(@PathVariable("id") K id) {
        D dto = getService().findById(id);
        return ResponseEntity.ok(dto);
    }

    /**
     * Recupera uma página de DTOs de acordo com os critérios especificados.
     *
     * @param objectDTO o DTO com os critérios de busca
     * @param pageable  as configurações da página
     * @return a página de DTOs
     */
    @Override
    @GetMapping("/page-query")
    public ResponseEntity<Page<D>> pageQuery(D objectDTO, Pageable pageable) {
        return null;
    }

    /**
     * Atualiza um DTO existente.
     *
     * @param objectDTO o DTO a ser atualizado
     * @param id        o ID do DTO a ser atualizado
     * @return um objeto ResponseEntity vazio, indicando o sucesso da operação
     */
    @Override
    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody @Validated D objectDTO, @PathVariable("id") K id) {
        getService().update(objectDTO, id);
        return ResponseEntity.ok().build();
    }

    /**
     * Exclui um DTO pelo ID.
     *
     * @param id o ID do DTO a ser excluído
     * @return um objeto ResponseEntity vazio, indicando o sucesso da operação
     */
    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id") K id) {
        getService().deleteById(id);
        return ResponseEntity.ok().build();
    }

    /**
     * Recupera todos os DTOs.
     *
     * @return a lista de DTOs
     */
    @Override
    @GetMapping("/")
    public ResponseEntity<List<D>> findAll() {
        return ResponseEntity.ok().body(getService().findAll());
    }
}
