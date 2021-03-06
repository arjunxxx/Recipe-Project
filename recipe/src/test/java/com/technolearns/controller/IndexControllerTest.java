package com.technolearns.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import com.technolearns.domain.Recipe;
import com.technolearns.service.RecipeService;

@ExtendWith(SpringExtension.class)
class IndexControllerTest {

	@Mock
	private RecipeService recipeService;

	@InjectMocks
	private IndexController indexController;

	@Mock
	private Model model;

	@Test
	public void testMockMVC() throws Exception {
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(indexController).build();

		mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
	}

	@Test
	void testGetIndexPage() {
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		Recipe recipe2 = new Recipe();
		recipe2.setId(2L);
		Set<Recipe> recipies = new HashSet<>();
		recipies.add(recipe);
		recipies.add(recipe2);
		when(recipeService.getRecipes()).thenReturn(recipies);
		String indexPage = indexController.getIndexPage(model);
		assertEquals(indexPage, "index");
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		verify(recipeService, times(1)).getRecipes();
		verify(model, times(1)).addAttribute(org.mockito.ArgumentMatchers.eq("recipes"), argumentCaptor.capture());
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
	}

}
