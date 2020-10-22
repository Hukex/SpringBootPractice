package com.game.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.game.entities.Shop;

@Repository
public interface ShopRepository extends JpaRepository<Shop, Long> {

	Shop findByName(String name);

}
