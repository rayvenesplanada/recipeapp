package com.recime.recipeapp.data.repository;

import com.recime.recipeapp.data.Difficulty;
import com.recime.recipeapp.data.Recipe;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
    List<Recipe> findRecipesByDifficulty(Difficulty difficulty, Sort sort);
}
