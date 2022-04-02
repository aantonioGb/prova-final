package br.com.tech4tenis.tech4tenis.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4tenis.tech4tenis.dto.TenisDTO;

public interface TenisService {

    List<TenisDTO> obterTodoOsTenis();

    Optional<TenisDTO> obterTenisProId(String id);

    TenisDTO armazenarTenis(TenisDTO tenis);

    void excluirTenisPorId(String id);

    TenisDTO atualizarTenis(String id, TenisDTO tenis);

    List<TenisDTO> obterPorProduto(String produto);

    
}
