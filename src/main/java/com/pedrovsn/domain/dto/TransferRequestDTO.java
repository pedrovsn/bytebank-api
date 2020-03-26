package com.pedrovsn.domain.dto;

import com.pedrovsn.domain.orm.Transfer;

public class TransferRequestDTO {

    private ContactRequestDTO contact;

    private Double value;

    public ContactRequestDTO getContact() {
        return contact;
    }

    public void setContact(ContactRequestDTO contact) {
        this.contact = contact;
    }

    public Double getValue() {
        return value;
    }

    public void setValue(Double value) {
        this.value = value;
    }

    public static TransferRequestDTO toDTO(Transfer transfer) {
        TransferRequestDTO transferRequestDTO = new TransferRequestDTO();
        transferRequestDTO.setContact(ContactRequestDTO.toDTO(transfer.getContact()));
        transferRequestDTO.setValue(transfer.getValue());

        return transferRequestDTO;
    }

    public static Transfer fromDTO(TransferRequestDTO transferRequestDTO) {
        Transfer transfer = new Transfer();
        transfer.setContact(ContactRequestDTO.fromDTO(transferRequestDTO.getContact()));
        transfer.setValue(transferRequestDTO.getValue());

        return transfer;
    }
}
