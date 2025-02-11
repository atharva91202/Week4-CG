package day1_generics.mealplanner;

public class VeganMeal implements MealPlan{
    private boolean isGlutenFree;

    public VeganMeal(boolean isGlutenFree) {
        this.isGlutenFree = isGlutenFree;
    }

    @Override
    public String getMealDetails() {
        return "Vegan Meal - Gluten Free : " + isGlutenFree;
    }
}
