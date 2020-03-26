package com.pedrovsn.repository.impl;

import com.pedrovsn.domain.orm.Contact;
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
public class ContactRepositoryWithSQL implements DatabaseExternal<Contact, Long> {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact save(Contact t) {
        return contactRepository.save(t);
    }

    @Override
    public Contact findById(Long id) {
        return contactRepository.findById(id).orElseThrow(() -> new DemoNotFoundException(id));
    }

    @Override
    public List<Contact> findAll() {
        List<Contact> list = new ArrayList<>();
        contactRepository.findAll().forEach(list::add);

        return list;
    }

    @Override
    public Page<Contact> findAll(Pageable pageable) {
        return contactRepository.findAll(pageable);
    }

    @Override
    public Long count() {
        return contactRepository.count();
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }
}
