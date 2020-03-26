package com.pedrovsn.repository.impl;

import com.pedrovsn.domain.orm.Transfer;
import com.pedrovsn.exception.DemoNotFoundException;
import com.pedrovsn.repository.DatabaseExternal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class TransferRepositoryWithSQL implements DatabaseExternal<Transfer, Long> {

    @Autowired
    private TransferRepository transferRepository;

    @Override
    public Transfer save(Transfer t) {
        return transferRepository.save(t);
    }

    @Override
    public Transfer findById(Long id) {
        return transferRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
    }

    @Override
    public List<Transfer> findAll() {
        List<Transfer> list = new ArrayList<>();
        transferRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Page<Transfer> findAll(Pageable pageable) {
        return transferRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return transferRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        transferRepository.deleteById(id);
    }
}
