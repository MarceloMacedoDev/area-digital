package br.com.areadigital.web.controller;

import br.com.areadigital.db.dto.IBaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * Interface de controlador que fornece funcionalidades básicas para operações de CRUD.
 *
 * @param <D> o tipo de objeto DTO (Data Transfer Object) manipulado pelo controlador
 * @param <K> o tipo de chave primária da entidade de banco de dados manipulada pelo controlador
 */
public interface IBaseController<D extends IBaseDTO<K>, K> {

    /**
     * Retorna uma lista de todos os objetos do banco de dados.
     *
     * @return a resposta HTTP com a lista de objetos encontrados, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<List<D>> findAll();

    /**
     * Salva um objeto DTO no banco de dados.
     *
     * @param objectDTO o objeto DTO a ser salvo
     * @return uma resposta HTTP vazia em caso de sucesso, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<D> save(@RequestBody @Validated D objectDTO);

    /**
     * Retorna um objeto do banco de dados a partir de seu ID.
     *
     * @param id o ID do objeto a ser retornado
     * @return a resposta HTTP com o objeto encontrado, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<D> findById(@PathVariable("id") K id);

    /**
     * Retorna uma página de objetos do banco de dados de acordo com os critérios especificados.
     *
     * @param objectDTO o objeto DTO com os critérios de busca
     * @param pageable  a configuração da página de resultados
     * @return a resposta HTTP com a página de resultados encontrada, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<Page<D>> pageQuery(D objectDTO, Pageable pageable);

    /**
     * Atualiza um objeto no banco de dados a partir de seu ID e do objeto DTO fornecido.
     *
     * @param objectDTO o objeto DTO com as informações atualizadas
     * @param id        o ID do objeto a ser atualizado
     * @return uma resposta HTTP vazia em caso de sucesso, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<Void> update(@RequestBody @Validated D objectDTO, @PathVariable("id") K id);

    /**
     * Exclui um objeto do banco de dados a partir de seu ID.
     *
     * @param id o ID do objeto a ser excluído
     * @return uma resposta HTTP vazia em caso de sucesso, ou um código de erro HTTP em caso de falha
     */
    public ResponseEntity<Void> deleteById(@PathVariable("id") K id);


}
