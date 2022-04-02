package br.com.tech4produtos.tech4produtos.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4produtos.tech4produtos.dto.ProdutosDTO;
import br.com.tech4produtos.tech4produtos.httpClients.TenisFeignClient;
import br.com.tech4produtos.tech4produtos.model.Produtos;
import br.com.tech4produtos.tech4produtos.repositoy.ProdutosRepository;

@Service
public class ProdutosServiceImpl implements ProdutosService{

    ModelMapper mapper = new ModelMapper();

    @Autowired
    private TenisFeignClient tenisClient;

    @Autowired
    private ProdutosRepository repository;


    @Override
    public ProdutosDTO cadastrarProduto(ProdutosDTO produto) {
        Produtos produtosgravar = mapper.map(produto, Produtos.class);
        produtosgravar = repository.save(produtosgravar);
        
        return mapper.map(produtosgravar, ProdutosDTO.class);
    }

    @Override
    public List<ProdutosDTO> obterTodosOsProdutos() {
        List<Produtos> produto = repository.findAll();

        return produto.stream()
                .map(p -> mapper.map(p, ProdutosDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<ProdutosDTO> obterProdutoPorID(String id) {
        Optional<Produtos> produto = repository.findById(id);

        if(produto.isPresent()){
            ProdutosDTO dto = mapper.map(produto.get(), ProdutosDTO.class);

            dto.setTenis(tenisClient.obterTenisPorProdutos(id));

            return Optional.of(dto);
        }
        return Optional.empty();
    }

    @Override
    public void excluirProdutoPorId(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public ProdutosDTO atualizarProduto(String id, ProdutosDTO produto) {
        Optional<Produtos> produtosbusca = repository.findById(id);

        if(produtosbusca.isPresent()){
            Produtos atualizarproduto = mapper.map(produto, Produtos.class);
            atualizarproduto.setId(id);
            atualizarproduto = repository.save(atualizarproduto);

            return mapper.map(produto, ProdutosDTO.class);
        }
        return null;
    }
    
}
