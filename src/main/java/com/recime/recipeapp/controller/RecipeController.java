package com.recime.recipeapp.controller;

import com.recime.recipeapp.data.repository.RecipeDTO;
import com.recime.recipeapp.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/recipes")
public class RecipeController {
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping
    public List<RecipeDTO> getAllRecipes() {
        return recipeService.getAllRecipes();
    }

    @GetMapping("/filter")
    public List<RecipeDTO> getRecipesByFilter(@RequestParam String difficulty) {
        return recipeService.getAllRecipesByFilter(difficulty);
    }
}

