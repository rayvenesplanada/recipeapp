package com.recime.recipeapp.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.recime.recipeapp.data.Recipe;
import com.recime.recipeapp.data.repository.RecipeRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.InputStream;
import java.util.List;

@Service
public class DataLoaderService implements CommandLineRunner {
    private final RecipeRepository recipeRepository;
    private final ObjectMapper objectMapper;

    public DataLoaderService(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        InputStream inputStream = getClass().getResourceAsStream("/recipedata.json");

        List<Recipe> recipes = objectMapper.readValue(inputStream, new TypeReference<List<Recipe>>() {});
        recipeRepository.saveAll(recipes);
    }
}
