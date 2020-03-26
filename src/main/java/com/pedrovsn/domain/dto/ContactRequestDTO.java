package com.pedrovsn.domain.dto;

import com.pedrovsn.domain.orm.Contact;
import com.pedrovsn.domain.orm.Transfer;

public class ContactRequestDTO {

	private String name;

	private String nickname;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public static ContactRequestDTO toDTO(Contact contact) {
		ContactRequestDTO contactRequestDTO = new ContactRequestDTO();
		contactRequestDTO.setName(contact.getName());
		contactRequestDTO.setNickname(contact.getNickname());

		return contactRequestDTO;
	}

	public static Contact fromDTO(ContactRequestDTO contactRequestDTO) {
		Contact contact = new Contact();
		contact.setName(contactRequestDTO.getName());
		contact.setNickname(contactRequestDTO.getNickname());

		return contact;
	}
}
