package com.game.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.Data;

@Entity
@Table(name = "GAMES", uniqueConstraints = { @UniqueConstraint(columnNames = { "TITLE" }) })
@Data
public class Game {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "TITLE")
	private String title;

	@Column(name = "DESCRIPTION", length = 3000)
	private String description;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinTable(name = "GAMES_GENRES", joinColumns = { @JoinColumn(name = "GAMES") }, inverseJoinColumns = {
			@JoinColumn(name = "GENRES") })
	private List<Genre> genres;

	@Column(name = "RELEASE")
	private Date release;

	@OneToMany(mappedBy = "game")
	private List<Stock> stocks;

}
