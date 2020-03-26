package com.pedrovsn.domain.dto;

import com.pedrovsn.domain.orm.Contact;

public class ContactResponseDTO {

	private Long id;

	private String name;

	private String nickname;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public static ContactResponseDTO toDTO(Contact contact) {
		ContactResponseDTO contactResponseDTO = new ContactResponseDTO();
		contactResponseDTO.setId(contact.getId());
		contactResponseDTO.setName(contact.getName());
		contactResponseDTO.setNickname(contact.getNickname());

		return contactResponseDTO;
	}

	public static Contact fromDTO(ContactResponseDTO contactResponseDTO) {
		Contact contact = new Contact();
		contact.setName(contactResponseDTO.getName());
		contact.setNickname(contactResponseDTO.getNickname());

		return contact;
	}
}
