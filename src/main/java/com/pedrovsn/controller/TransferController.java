package com.pedrovsn.controller;

import com.pedrovsn.domain.dto.TransferRequestDTO;
import com.pedrovsn.domain.dto.TransferResponseDTO;
import com.pedrovsn.domain.bean.ListResponse;
import com.pedrovsn.domain.bean.PagedRequest;
import com.pedrovsn.service.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/transfers")
public class TransferController {

    private TransferService transferService;

    @Autowired
    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public TransferResponseDTO createDemo(TransferRequestDTO demo) {
        return transferService.save(demo);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferResponseDTO updateDemo(@PathVariable("id") Long id, TransferRequestDTO demo) {
        return transferService.update(id, demo);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void removeDemo(@PathVariable("id") Long id) {
        transferService.delete(id);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public TransferResponseDTO findOneDemo(Long id) {
        return transferService.findById(id);
    }

    @GetMapping("/")
    @ResponseStatus(HttpStatus.OK)
    public ListResponse<TransferResponseDTO> findAllByFilters(@RequestParam("page") int page, @RequestParam("pageSize") int pageSize, @RequestParam("orderBy") String orderBy, @RequestParam("desc") boolean desc) {
        PagedRequest<TransferRequestDTO> pagedRequest = new PagedRequest<>();
        pagedRequest.setPage(page);
        pagedRequest.setPageSize(pageSize);
        pagedRequest.setOrderBy(orderBy);
        pagedRequest.setDesc(desc);

        return transferService.findAll(pagedRequest);
    }
}
