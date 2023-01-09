package br.com.areadigital.web.service;

import br.com.areadigital.db.dto.IBaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface de serviço que fornece funcionalidades básicas para operações de CRUD.
 *
 * @param <D> o tipo de objeto DTO (Data Transfer Object) manipulado pelo serviço
 * @param <K> o tipo de chave primária da entidade de banco de dados manipulada pelo serviço
 */
public interface IBaseService<D extends IBaseDTO<K>, K> {

    /**
     * Salva um objeto DTO no banco de dados.
     *
     * @param objectDTO o objeto DTO a ser salvo
     * @return o objeto DTO salvo
     */
    public D save(D objectDTO);

    /**
     * Exclui um objeto do banco de dados a partir de seu ID.
     *
     * @param id o ID do objeto a ser excluído
     */
    public void deleteById(K id);

    /**
     * Retorna um objeto do banco de dados a partir de seu ID.
     *
     * @param id o ID do objeto a ser retornado
     * @return o objeto com o ID especificado
     */
    public D findById(K id);

    /**
     * Retorna uma página de objetos do banco de dados de acordo com os critérios especificados.
     *
     * @param objectDTO o objeto DTO com os critérios de busca
     * @param pageable  a configuração da página de resultados
     * @return a página de resultados encontrada
     */
    public Page<D> findByCondition(D objectDTO, Pageable pageable);

    /**
     * Atualiza um objeto no banco de dados a partir de seu ID e do objeto DTO fornecido.
     *
     * @param objectDTO o objeto DTO com as informações atualizadas
     * @param id        o ID do objeto a ser atualizado
     * @return o objeto DTO atualizado
     */
    public D update(D objectDTO, K id);

    /**
     * Retorna uma lista de todos os objetos do banco de dados.
     *
     * @return a resposta HTTP com a lista de objetos encontrados, ou um código de erro HTTP em caso de falha
     */
    public List<D> findAll();

    /**
     * Método chamado antes de salvar um objeto no banco de dados.
     *
     * @param objectDTO o objeto DTO que será salvo
     */
    void preSave(D objectDTO);

    /**
     * Método chamado após salvar um objeto no banco de dados.
     *
     * @param objectDTO o objeto DTO que foi salvo
     */
    void posSave(D objectDTO);

    /**
     * Método chamado antes de excluir um objeto do banco de dados.
     *
     * @param id o ID do objeto que será excluído
     */
    void preDelete(K id);

    /**
     * Método chamado após excluir um objeto do banco de dados.
     *
     * @param id o ID do objeto que foi excluído
     */
    void posDelete(K id);

    /**
     * Método chamado antes de atualizar um objeto no banco de dados.
     *
     * @param objectDTO o objeto DTO com as informações atualizadas
     */
    void preUpdate(D objectDTO);

    /**
     * Método chamado após atualizar um objeto no banco de dados.
     *
     * @param objectDTO o objeto DTO atualizado
     */
    void posUpdate(D objectDTO);


}
