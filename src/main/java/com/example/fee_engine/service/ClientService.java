package com.example.fee_engine.service;

import com.example.fee_engine.model.Client;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


public interface ClientService {
    Optional<Client> findById(Long id);

    List<Client> findALL();

    Optional<Client> save(Client client);

}
