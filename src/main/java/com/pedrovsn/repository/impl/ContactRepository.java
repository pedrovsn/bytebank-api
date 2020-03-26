package com.pedrovsn.repository.impl;

import com.pedrovsn.domain.orm.Contact;
import com.pedrovsn.domain.orm.Transfer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

public interface ContactRepository extends CrudRepository<Contact, Long> {

    Page<Contact> findAll(Pageable pageable);
}
