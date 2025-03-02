package com.recime.recipeapp.data.repository;

public record RecipeDTO (long id, String name, String description, String difficulty, int position, String imageUrl) {}
