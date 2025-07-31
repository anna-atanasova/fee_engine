package com.example.fee_engine.service.impl;

import com.example.fee_engine.model.Client;
import com.example.fee_engine.repository.ClientRepository;
import com.example.fee_engine.service.ClientService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    private final ClientRepository clientRepository;

    public ClientServiceImpl(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    public List<Client> findALL() {
        return clientRepository.findAll();
    }

    @Override
    public Optional<Client> save(Client client) {
        return Optional.of(clientRepository.save(client));
    }
}

