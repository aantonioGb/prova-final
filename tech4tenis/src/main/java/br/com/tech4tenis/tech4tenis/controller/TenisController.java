package br.com.tech4tenis.tech4tenis.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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

import br.com.tech4tenis.tech4tenis.dto.TenisDTO;
import br.com.tech4tenis.tech4tenis.service.TenisService;
import br.com.tech4tenis.tech4tenis.view.model.TenisResponseDTO;
import br.com.tech4tenis.tech4tenis.view.model.TenisResponsePorIdDTO;

@RestController
@RequestMapping("api/tenis")
public class TenisController {
    ModelMapper mapper = new ModelMapper();

    @Autowired
    private TenisService service;

    @GetMapping
    public ResponseEntity<List<TenisResponseDTO>> obterTenis(){
        List<TenisDTO> dto = service.obterTodoOsTenis();

        List<TenisResponseDTO> tenis = dto.stream()
             .map(t -> mapper.map(t, TenisResponseDTO.class))
             .collect(Collectors.toList());

             return new ResponseEntity<>(tenis, HttpStatus.OK);
    }

    @GetMapping(value="/status")
    public String obterStatus(@Value("${local.server.port}") String porta) {
        return "Está rodando na porta" + porta;
    }

    @GetMapping("/{id}")
    public ResponseEntity<TenisResponsePorIdDTO> obterTenisPorId(@PathVariable String id){
        Optional<TenisDTO> tenis = service.obterTenisProId(id);

        if(tenis.isPresent()){
            return new ResponseEntity<>(mapper.map(tenis.get(), TenisResponsePorIdDTO.class), HttpStatus.FOUND);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<TenisDTO> cadastrarTenis(@RequestBody @Valid TenisDTO tenis){

        return new ResponseEntity<>(service.armazenarTenis(tenis),HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluirTenis(@PathVariable String id){
        service.excluirTenisPorId(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<TenisDTO> alterarProdutos(@PathVariable String id, @RequestBody @Valid TenisDTO tenis){
        return new ResponseEntity<>(service.atualizarTenis(id, tenis), HttpStatus.ACCEPTED);
    }

    @GetMapping("/produto/{produto}")
    public ResponseEntity<List<TenisDTO>> obterTenisPorProduto(@PathVariable String produto){
        return new ResponseEntity<>(service.obterPorProduto(produto),HttpStatus.OK);
    }

}
