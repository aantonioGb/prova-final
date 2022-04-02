package br.com.tech4tenis.tech4tenis.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.tech4tenis.tech4tenis.dto.TenisDTO;
import br.com.tech4tenis.tech4tenis.model.Tenis;
import br.com.tech4tenis.tech4tenis.repository.TenisRepository;

@Service
public class TenisServiceImpl implements TenisService {
   ModelMapper mapper = new ModelMapper();
   
   @Autowired
   private TenisRepository repository;

    @Override
    public List<TenisDTO> obterTodoOsTenis(){
        List<Tenis> tenis = repository.findAll();

        return tenis.stream()
               .map(t -> mapper.map(t, TenisDTO.class))
               .collect(Collectors.toList());
    }

    @Override
    public Optional<TenisDTO> obterTenisProId(String id) {
        Optional<Tenis> tenis = repository.findById(id);

        if(tenis.isPresent()){
            return Optional.of(mapper.map(tenis.get(), TenisDTO.class));
        }
        return Optional.empty();
    }

    @Override
    public TenisDTO armazenarTenis(TenisDTO tenis) {
        Tenis tenisgravar = mapper.map(tenis, Tenis.class);
        tenisgravar = repository.save(tenisgravar);
        return mapper.map(tenisgravar, TenisDTO.class);
    }

    @Override
    public void excluirTenisPorId(String id) {
        repository.deleteById(id);
        
    }

    @Override
    public TenisDTO atualizarTenis(String id, TenisDTO tenis) {
        Tenis tenisatualizar = mapper.map(tenis, Tenis.class);
        tenisatualizar.setId(id);
        tenisatualizar = repository.save(tenisatualizar);
        return mapper.map(tenisatualizar, TenisDTO.class);
    }

    @Override
    public List<TenisDTO> obterPorProduto(String produto) {
        List<Tenis> tenis = repository.findByProduto(produto);
        return tenis.stream()
                .map(t -> mapper.map(t, TenisDTO.class))
                .collect(Collectors.toList());
    }


}
