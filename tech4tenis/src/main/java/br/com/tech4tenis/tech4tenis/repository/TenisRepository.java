package br.com.tech4tenis.tech4tenis.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import br.com.tech4tenis.tech4tenis.model.Tenis;

public interface TenisRepository extends MongoRepository<Tenis, String>{

    List<Tenis> findByProduto(String produto);

    
}
