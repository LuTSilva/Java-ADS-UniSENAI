package com.gerenciamento.mecanica.service;

import com.gerenciamento.mecanica.dto.ClienteDto;
import com.gerenciamento.mecanica.dto.FilialDto;
import com.gerenciamento.mecanica.model.ClienteModel;
import com.gerenciamento.mecanica.model.FilialModel;
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
        cliente.setNomeCliente(dto.nomeCliente());
        cliente.setEmailCliente(dto.emailCliente());
        cliente.setTelefoneCliente(dto.telefoneCliente());
        cliente.setSenhaCliente(dto.senhaCliente());
        cliente.setCpfCliente(dto.cpfCliente());
        cliente.setCepCliente(dto.cepCliente());
        cliente.setCidadeCliente(dto.cidadeCliente());
        cliente.setBairroCliente(dto.bairroCliente());
        cliente.setRuaCliente(dto.ruaCliente());
        cliente.setNumeroEnderecoCliente(dto.numeroEnderecoCliente());
        return clienteRepository.save(cliente);
    }
    public List<ClienteModel> listarTodos() {
        return clienteRepository.findAll();
    }

    public Optional<ClienteModel> findByCdCliente(Integer cdCliente) {
        return clienteRepository.findByCdCliente(cdCliente);
    }

    public Optional<ClienteModel> findByNuCpf(String cpfCliente) {
        return clienteRepository.findByNuCpf(cpfCliente);
    }

    public Optional<ClienteModel> atualizaDados(Integer cdCliente, ClienteDto clienteDto) {
        return clienteRepository.findByCdCliente(cdCliente).map(cliente -> {
            cliente.setNomeCliente(clienteDto.nomeCliente());
            cliente.setEmailCliente(clienteDto.emailCliente());
            cliente.setTelefoneCliente(clienteDto.telefoneCliente());
            cliente.setSenhaCliente(clienteDto.senhaCliente());
            cliente.setCpfCliente(clienteDto.cpfCliente());
            cliente.setCepCliente(clienteDto.cepCliente());
            cliente.setCidadeCliente(clienteDto.cidadeCliente());
            cliente.setBairroCliente(clienteDto.bairroCliente());
            cliente.setRuaCliente(clienteDto.ruaCliente());
            cliente.setNumeroEnderecoCliente(clienteDto.numeroEnderecoCliente());
            return clienteRepository.save(cliente);
        });
    }

    public void deletarCliente(Integer cdCliente) {
        clienteRepository.deleteByCdCliente(cdCliente);
    }

}
