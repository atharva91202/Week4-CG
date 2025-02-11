package day1_generics.mealplanner;

public class KetoMeal implements MealPlan{
    private int fatPercentage;

    public KetoMeal(int fatPercentage) {
        this.fatPercentage = fatPercentage;
    }

    @Override
    public String getMealDetails() {
        return "Keto Meal has Fat percentage : " + fatPercentage;
    }
}
