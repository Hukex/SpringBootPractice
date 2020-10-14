package com.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.entities.Genre;
import com.game.enums.GenreEnum;

@Repository
public interface GenreRepository extends JpaRepository<Genre, Long> {
	Genre findByGenre(GenreEnum genre);

}
