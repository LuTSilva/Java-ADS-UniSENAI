package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ClienteDto;
import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    public ClienteModel salvar (@Valid @RequestBody ClienteDto dto) {
        ClienteModel cliente = new ClienteModel();
        cliente.setNmCliente(dto.nmCliente());
        cliente.setDsEmail(dto.dsEmail());
        cliente.setNuTelefone(dto.nuTelefone());
        cliente.setNuCpf(dto.nuCpf());
        return clienteRepository.save(cliente);
    }
    public List<ClienteModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findByCdCliente(Integer cdCliente) {
        return clienteRepository.findByCdCliente(cdCliente);
    }

    public Optional<ClienteModel> findByNuCpf(String nuCpf) {
        return clienteRepository.findByNuCpf(nuCpf);
    }

    public Optional<ClienteModel> atualizaDados(Integer cdCliente, ClienteDto clienteDto) {
        return clienteRepository.findByCdCliente(cdCliente).map(cliente -> {
            cliente.setNmCliente(clienteDto.nmCliente());
            cliente.setDsEmail(clienteDto.dsEmail());
            cliente.setNuTelefone(clienteDto.nuTelefone());
            cliente.setNuCpf(clienteDto.nuCpf());
            return clienteRepository.save(cliente);
        });
    }

    public void deletarCliente(Integer cdCliente) {
        clienteRepository.deleteByCdCliente(cdCliente);
    }

}
