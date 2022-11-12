package com.rest.card.repo;

import org.springframework.data.repository.CrudRepository;

import com.rest.card.model.Card;


public interface CardRepository extends CrudRepository<Card, String>{

}
