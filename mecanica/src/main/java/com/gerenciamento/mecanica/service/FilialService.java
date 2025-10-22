package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.FilialDto;
import com.gerenciamento.mecanica.model.FilialModel;
import com.gerenciamento.mecanica.repository.FilialRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class FilialService {

    @Autowired
    private FilialRepository filialRepository;

    public FilialModel salvar (@Valid @RequestBody FilialDto dto) {
        FilialModel filial = new FilialModel();
        filial.setNmRazao(dto.nmRazao());
        filial.setNmFantasia(dto.nmFantasia());
        filial.setNuCnpj(dto.nuCnpj());
        filial.setDsLocal(dto.dsLocal());
        filial.setNuTelefone(dto.nuTelefone());
        filial.setFlAtivo("S");
        return filialRepository.save(filial);
    }
    public List<FilialModel> listarTodos() {
        return filialRepository.findAll();
    }

    public List<FilialModel> listarFiliaisAtivas() {
        return filialRepository.findAllByFlAtivo();
    }

    public Optional<FilialModel> findByCdFilial(Integer cdFilial) {
        return filialRepository.findByCdFilial(cdFilial);
    }

    public Optional<FilialModel> findByNuCnpj(String nuCnpj) {
        return filialRepository.findByNuCnpj(nuCnpj);
    }

    public Optional<FilialModel> atualizaDados(Integer cdFilial, FilialDto filialDto) {
        return filialRepository.findByCdFilial(cdFilial).map(filial -> {
            filial.setNuCnpj(filialDto.nuCnpj());
            filial.setDsLocal(filialDto.dsLocal());
            filial.setNmFantasia(filialDto.nmFantasia());
            filial.setNmRazao(filialDto.nmRazao());
            filial.setNuTelefone(filialDto.nuTelefone());
            filial.setFlAtivo(filialDto.flAtivo());
            return filialRepository.save(filial);
        });
    }

    public void deletarFilial(Integer cdFilial){
        filialRepository.deleteByCdFilial(cdFilial);
    }
}
