package com.pedrovsn.service.impl;

import com.pedrovsn.domain.bean.ListResponse;
import com.pedrovsn.domain.bean.PagedRequest;
import com.pedrovsn.domain.dto.ContactRequestDTO;
import com.pedrovsn.domain.dto.TransferRequestDTO;
import com.pedrovsn.domain.dto.TransferResponseDTO;
import com.pedrovsn.domain.orm.Transfer;
import com.pedrovsn.repository.DatabaseExternal;
import com.pedrovsn.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransferServiceImpl implements TransferService {

    private DatabaseExternal<Transfer, Long> demoRepository;

    @Autowired
    public TransferServiceImpl(DatabaseExternal<Transfer, Long> demoRepository) {
        this.demoRepository = demoRepository;
    }

    @Override
    public TransferResponseDTO save(TransferRequestDTO transferRequestDTO) {
        Transfer transfer = TransferRequestDTO.fromDTO(transferRequestDTO);
        return TransferResponseDTO.toDTO(demoRepository.save(transfer));
    }

    @Override
    public TransferResponseDTO update(Long id, TransferRequestDTO transferRequestDTO) {
        Transfer transfer = demoRepository.findById(id);
        transfer.setContact(ContactRequestDTO.fromDTO(transferRequestDTO.getContact()));
        transfer.setValue(transferRequestDTO.getValue());

        Transfer saved = demoRepository.save(transfer);
        return TransferResponseDTO.toDTO(saved);
    }

    @Override
    public TransferResponseDTO findById(Long id) {
        Transfer transfer = demoRepository.findById(id);
        return TransferResponseDTO.toDTO(transfer);
    }

    @Override
    public ListResponse<TransferResponseDTO> findAll(PagedRequest<TransferRequestDTO> filter) {
        PageRequest pageRequest = PageRequest.of(filter.getPage(), filter.getPageSize(), Sort.by(Sort.Direction.DESC,
                filter.getOrderBy()));
        Page<Transfer> all = demoRepository.findAll(pageRequest);

        List<TransferResponseDTO> transferResponseDTOList = new ArrayList<>();
        all.forEach(transfer -> {
            TransferResponseDTO transferResponseDTO = TransferResponseDTO.toDTO(transfer);
            transferResponseDTOList.add(transferResponseDTO);
        });

        ListResponse<TransferResponseDTO> response = new ListResponse<>();
        response.setRegisters(transferResponseDTOList);
        response.setTotalRegister(all.getTotalElements());

        return response;
    }

    @Override
    public void delete(Long id) {
        demoRepository.findById(id);
        demoRepository.deleteById(id);
    }
}
