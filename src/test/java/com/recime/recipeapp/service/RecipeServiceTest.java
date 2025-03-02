package com.recime.recipeapp.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.recime.recipeapp.data.Difficulty;
import com.recime.recipeapp.data.Recipe;
import com.recime.recipeapp.data.repository.RecipeDTO;
import com.recime.recipeapp.data.repository.RecipeRepository;
import com.recime.recipeapp.exception.RecipeException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Sort;

import java.util.List;

public class RecipeServiceTest {

    @Mock
    private RecipeRepository recipeRepository;

    @InjectMocks
    private RecipeService recipeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetAllRecipes() {
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .name("Burger 1")
                .position(1)
                .build();
        Recipe recipe2 = Recipe.builder()
                .id(2L)
                .name("Burger 2")
                .position(2)
                .build();


        when(recipeRepository.findAll(any(Sort.class))).thenReturn(List.of(recipe1, recipe2));
        List<RecipeDTO> recipes = recipeService.getAllRecipes();

        assertEquals(2, recipes.size());
        assertEquals("Burger 1", recipes.get(0).name());
        assertEquals(1, recipes.get(0).position());
        assertEquals("Burger 2", recipes.get(1).name());
        assertEquals(2, recipes.get(1).position());
    }

    @Test
    public void testGetAllRecipesByFilter() {
        Difficulty difficulty = Difficulty.EASY;
        Recipe recipe1 = Recipe.builder()
                .id(1L)
                .name("Burger 1")
                .position(1)
                .difficulty(difficulty)
                .build();
        Recipe recipe2 = Recipe.builder()
                .id(2L)
                .name("Burger 2")
                .position(2)
                .difficulty(difficulty)
                .build();
        when(recipeRepository.findRecipesByDifficulty(eq(difficulty), any(Sort.class))).thenReturn(List.of(recipe1, recipe2));

        List<RecipeDTO> recipes = recipeService.getAllRecipesByFilter("EASY");

        assertEquals(2, recipes.size());
        assertEquals("Burger 1", recipes.get(0).name());
        assertEquals("EASY", recipes.get(0).difficulty());
        assertEquals("Burger 2", recipes.get(1).name());
        assertEquals("EASY", recipes.get(1).difficulty());
    }

    @Test
    public void testGetAllRecipesByFilterThrowsException() {
        RecipeException exception = assertThrows(RecipeException.class, () -> {
            recipeService.getAllRecipesByFilter("INVALID");
        });

        assertEquals("A difficulty is required for filtering trending recipes", exception.getMessage());
    }
} 