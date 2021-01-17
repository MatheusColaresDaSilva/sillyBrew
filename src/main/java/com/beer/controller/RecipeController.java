package com.beer.controller;

import com.beer.exception.RecipeNotFoundException;
import com.beer.model.Recipe;
import com.beer.repository.RecipeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RecipeController {

    private final RecipeRepository recipeRepository;

    public RecipeController(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @GetMapping("/")
    public String index() {
        return "ON";
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public List<Recipe> findAll() {
        return recipeRepository.findAll();
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.POST)
    public Recipe newRecipe(@RequestBody Recipe recipe) {
        return recipeRepository.save(recipe);
    }

    @GetMapping("/recipes/{id}")
    public Recipe find(@PathVariable Long id) {
        return recipeRepository.findById(id).orElseThrow (() -> new RecipeNotFoundException(id));
   }

   @PutMapping("/recipes/{id}")
   public Recipe replaceRecipe(@RequestBody Recipe newRecipe, @PathVariable Long id) {
       return recipeRepository.findById(id).map(recipe -> {
           recipe.updateRecipe(newRecipe);
           return recipeRepository.save(recipe);
       }).orElseGet (() -> {
           newRecipe.setId(id);
           return recipeRepository.save(newRecipe);
       });
   }

    @DeleteMapping("/recipes/{id}")
    void deleteRecipe(@PathVariable Long id) {
        recipeRepository.deleteById(id);
    }
}
