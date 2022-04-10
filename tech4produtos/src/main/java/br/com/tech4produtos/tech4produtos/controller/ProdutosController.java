package br.com.tech4produtos.tech4produtos.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tech4produtos.tech4produtos.dto.ProdutosComTenisDTO;
import br.com.tech4produtos.tech4produtos.dto.ProdutosDTO;
import br.com.tech4produtos.tech4produtos.service.ProdutosService;
import br.com.tech4produtos.tech4produtos.view.model.ProdutosResponseDTO;

@RestController
@RequestMapping("/api/produtos")
public class ProdutosController {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private ProdutosService service;

    @GetMapping
    public ResponseEntity<List<ProdutosResponseDTO>> obterProdutos(){
        List<ProdutosDTO> dto = service.obterTodosOsProdutos();

        List<ProdutosResponseDTO> produtos = dto.stream()
                    .map(p -> mapper.map(p, ProdutosResponseDTO.class))
                    .collect(Collectors.toList());
        
        return new ResponseEntity<>(produtos, HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<ProdutosDTO> alterarProdutos(@PathVariable String id, @RequestBody @Valid ProdutosDTO produtos){
        return new ResponseEntity<>(service.atualizarProduto(id, produtos), HttpStatus.ACCEPTED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirProduto(@PathVariable String id){
        service.excluirProdutoPorId(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ProdutosDTO>cadastrarProduto(@RequestBody @Valid ProdutosDTO produto){
        return new ResponseEntity<>(service.cadastrarProduto(produto), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<ProdutosComTenisDTO> obterProdutoPorId(@PathVariable String id){
        Optional<ProdutosDTO> produto = service.obterProdutoPorID(id);

        if(produto.isPresent()){
            return new ResponseEntity<>(mapper.map(produto.get(), ProdutosComTenisDTO.class), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
