package day1_generics.mealplanner;

public class VegetarianMeal implements MealPlan{
    private String mainIngredient;

    public VegetarianMeal(String mainIngredient) {
        this.mainIngredient = mainIngredient;
    }

    @Override
    public String getMealDetails() {
        return "Vegetarian Meal with main ingredient : " + mainIngredient;
    }
}
