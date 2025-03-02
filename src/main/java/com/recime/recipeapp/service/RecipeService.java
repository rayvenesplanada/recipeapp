package com.recime.recipeapp.service;

import com.recime.recipeapp.data.Difficulty;
import com.recime.recipeapp.data.Recipe;
import com.recime.recipeapp.data.repository.RecipeDTO;
import com.recime.recipeapp.data.repository.RecipeRepository;
import com.recime.recipeapp.exception.RecipeException;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecipeService {
    private final RecipeRepository recipeRepository;

    private final Sort SORT_BY_POSITION_ASC = Sort.by(
            Sort.Order.asc("position"),
                Sort.Order.asc("id")
                        );

    public RecipeService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Transactional(readOnly = true)
    public List<RecipeDTO> getAllRecipes() {
        return recipeRepository.findAll(SORT_BY_POSITION_ASC).stream()
                .map(Recipe::toDTO)
                .toList();
    }

    @Transactional(readOnly = true)
    public List<RecipeDTO> getAllRecipesByFilter(String difficultyStr) {
        Difficulty difficulty = Difficulty.fromString(difficultyStr);
        if (difficulty == null) {
            throw new RecipeException("A difficulty is required for filtering trending recipes");
        }

        return recipeRepository.findRecipesByDifficulty(difficulty, SORT_BY_POSITION_ASC).stream()
                .map(Recipe::toDTO)
                .toList();
    }
}
