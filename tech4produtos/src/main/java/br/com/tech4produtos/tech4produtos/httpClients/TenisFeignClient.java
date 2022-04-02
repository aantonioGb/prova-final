package br.com.tech4produtos.tech4produtos.httpClients;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import br.com.tech4produtos.tech4produtos.shared.Tenis;

@FeignClient(name="tech4tenis", fallback=TenisFeignClientFallBack.class)
public interface TenisFeignClient {
    
    @GetMapping(path = "api/tenis/produto/{produto}")
    List<Tenis> obterTenisPorProdutos(@PathVariable String produto);
}

@Component
class TenisFeignClientFallBack implements TenisFeignClient{

    @Override
    public List<Tenis> obterTenisPorProdutos(String produto) {
        return new ArrayList<>();
    }
}
