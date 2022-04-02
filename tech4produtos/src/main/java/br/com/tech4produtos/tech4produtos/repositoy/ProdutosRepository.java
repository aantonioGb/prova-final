package br.com.tech4produtos.tech4produtos.repositoy;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4produtos.tech4produtos.model.Produtos;

public interface ProdutosRepository extends MongoRepository<Produtos, String>{
 
}
