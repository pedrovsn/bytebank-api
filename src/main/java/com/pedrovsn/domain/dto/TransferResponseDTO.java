package com.pedrovsn.domain.dto;

import com.pedrovsn.domain.orm.Transfer;

public class TransferResponseDTO {

    private Long id;

    private ContactResponseDTO contact;

    private Double value;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ContactResponseDTO getContact() {
        return contact;
    }

    public void setContact(ContactResponseDTO contact) {
        this.contact = contact;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TransferResponseDTO{" +
                "id=" + id +
                ", contactResponseDTO=" + contact +
                ", value=" + value +
                '}';
    }

    public static TransferResponseDTO toDTO(Transfer transfer) {
        TransferResponseDTO transferResponseDTO = new TransferResponseDTO();
        transferResponseDTO.setId(transfer.getId());
        transferResponseDTO.setContact(ContactResponseDTO.toDTO(transfer.getContact()));
        transferResponseDTO.setValue(transfer.getValue());

        return transferResponseDTO;
    }

    public static Transfer fromDTO(TransferResponseDTO transferResponseDTO) {
        Transfer transfer = new Transfer();
        transfer.setId(transferResponseDTO.getId());
        transfer.setContact(ContactResponseDTO.fromDTO(transferResponseDTO.getContact()));
        transfer.setValue(transferResponseDTO.getValue());

        return transfer;
    }
}
