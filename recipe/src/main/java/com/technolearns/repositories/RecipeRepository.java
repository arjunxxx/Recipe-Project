package com.technolearns.repositories;

import org.springframework.data.repository.CrudRepository;

import com.technolearns.domain.Recipe;

public interface RecipeRepository extends CrudRepository<Recipe, Long> {
	
	

}
