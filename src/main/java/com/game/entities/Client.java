package com.game.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "CLIENTS")
@Data
public class Client {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "CARD")
	private String card;

	@Column(name = "NAME")
	private String name;

	@Column(name = "SURNAME")
	private String surname;

	@OneToMany(mappedBy = "client")
	private List<Ticket> tickets;

}
