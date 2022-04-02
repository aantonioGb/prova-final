package br.com.tech4produtos.tech4produtos.service;

import java.util.List;
import java.util.Optional;

import br.com.tech4produtos.tech4produtos.dto.ProdutosDTO;

public interface ProdutosService {
    ProdutosDTO cadastrarProduto(ProdutosDTO produto);

    List<ProdutosDTO> obterTodosOsProdutos();

    Optional<ProdutosDTO> obterProdutoPorID(String id);

    void excluirProdutoPorId(String id);

    ProdutosDTO atualizarProduto(String id, ProdutosDTO produto);
}
