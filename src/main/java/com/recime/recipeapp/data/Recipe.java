package com.recime.recipeapp.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.recime.recipeapp.data.repository.RecipeDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @Enumerated(EnumType.STRING)
    @JsonProperty("difficulty")
    private Difficulty difficulty;
    @JsonProperty("position")
    private Integer position;
    @JsonProperty("imageUrl")
    private String imageUrl;


    public static RecipeDTO toDTO(Recipe recipe) {
        return new RecipeDTO(recipe.id,
                recipe.name,
                recipe.description,
                recipe.difficulty != null ? recipe.difficulty.toString() : null,
                recipe.position,
                recipe.imageUrl);
    }
}
