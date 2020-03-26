package com.pedrovsn.service.impl;

import com.pedrovsn.domain.bean.ListResponse;
import com.pedrovsn.domain.bean.PagedRequest;
import com.pedrovsn.domain.dto.TransferRequestDTO;
import com.pedrovsn.domain.dto.TransferResponseDTO;
import com.pedrovsn.domain.orm.Transfer;
import com.pedrovsn.repository.DatabaseExternal;
import com.pedrovsn.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TransferServiceImplTest {

    @Mock
    DatabaseExternal<Transfer, Long> demoRepository;

    @InjectMocks
    TransferService transferService = new TransferServiceImpl(demoRepository);

    private static final Long DEFAULT_ID = 1L;

    Transfer transfer;

    TransferRequestDTO transferRequestDTO;

    TransferResponseDTO transferResponseDTO;

    @BeforeEach
    void setupMockTests() {
        transfer = new Transfer();
        transfer.setId(DEFAULT_ID);

        transferRequestDTO = TransferRequestDTO.toDTO(transfer);
        transferResponseDTO = TransferResponseDTO.toDTO(transfer);
    }

    @DisplayName("Test Mock demoService + demoRepository - Save")
    @Test
    void testSaveDemo() {
        when(demoRepository.save(any(Transfer.class)))
                .thenReturn(transfer);

        TransferResponseDTO save = transferService.save(transferRequestDTO);
        assertThat(save.getId()).isEqualTo(1L);
    }

    @DisplayName("Test Mock demoService + demoRepository - Update")
    @Test
    void testUpdateDemo() {
        when(demoRepository.findById(eq(DEFAULT_ID)))
                .thenReturn(transfer);

        Transfer newTransfer = new Transfer();
        newTransfer.setId(DEFAULT_ID);

        when(demoRepository.save(eq(transfer)))
                .thenReturn(newTransfer);

        TransferRequestDTO newTransferRequestDTO = TransferRequestDTO.toDTO(newTransfer);

        TransferResponseDTO update = transferService.update(DEFAULT_ID, newTransferRequestDTO);

        assertThat(update.getId()).isEqualTo(1L);
    }

    @DisplayName("Test Mock demoService + demoRepository - Get One")
    @Test
    void testGetOne() {
        when(demoRepository.findById(eq(DEFAULT_ID)))
                .thenReturn(transfer);

        TransferResponseDTO found = transferService.findById(DEFAULT_ID);
        assertThat(found.getId()).isEqualTo(1L);
    }

    @DisplayName("Test Mock demoService + demoRepository - Get All")
    @Test
    void testGetAll() {
        PagedRequest<TransferRequestDTO> pagedRequest = new PagedRequest<>();
        pagedRequest.setPageSize(10);
        pagedRequest.setPage(0);
        pagedRequest.setOrderBy("Id");
        pagedRequest.setDesc(Boolean.TRUE);

        Page<Transfer> page = new PageImpl<Transfer>(Arrays.asList(transfer));

        when(demoRepository.findAll(any(PageRequest.class)))
                .thenReturn(page);

        ListResponse<TransferResponseDTO> items = transferService.findAll(pagedRequest);
        assertThat(items.getTotalRegister()).isEqualTo(1L);
    }
}
