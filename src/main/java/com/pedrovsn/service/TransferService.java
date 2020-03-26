package com.pedrovsn.service;

import com.pedrovsn.domain.dto.TransferRequestDTO;
import com.pedrovsn.domain.dto.TransferResponseDTO;
import com.pedrovsn.domain.bean.ListResponse;
import com.pedrovsn.domain.bean.PagedRequest;

public interface TransferService {

    TransferResponseDTO save(TransferRequestDTO transferRequestDTO);
    TransferResponseDTO update(Long id, TransferRequestDTO transferRequestDTO);
    TransferResponseDTO findById(Long id);
    ListResponse<TransferResponseDTO> findAll(PagedRequest<TransferRequestDTO> filter);
    void delete(Long id);
}
