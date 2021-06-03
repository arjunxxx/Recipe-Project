  
package com.technolearns.service;

import java.util.Set;

import com.technolearns.domain.Recipe;


public interface RecipeService {

    Set<Recipe> getRecipes();
}