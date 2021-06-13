package com.technolearns.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.technolearns.domain.Recipe;
import com.technolearns.repositories.RecipeRepository;

class RecipeServiceImplTest {

	RecipeServiceImpl recipeService;

	@Mock
	RecipeRepository recipeRepository;

	@BeforeEach
	void setUp() throws Exception {

		MockitoAnnotations.initMocks(this);
		recipeService = new RecipeServiceImpl(recipeRepository);

	}

	@Test
	void testGetRecipes() {

		Recipe recipe = new Recipe();
		HashSet<Recipe> recipeData = new HashSet<>();
		recipeData.add(recipe);
		when(recipeRepository.findAll()).thenReturn(recipeData);

		Set<Recipe> recipes = recipeService.getRecipes();
		assertEquals(recipes, recipeData);
		assertEquals(recipes.size(), 1);
		verify(recipeRepository, times(1)).findAll();

	}

}
