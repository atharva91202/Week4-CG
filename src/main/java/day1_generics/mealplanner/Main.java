package day1_generics.mealplanner;

public class Main {
    public static void main(String[] args) {
        // Creating meal plan
        MealPlanner mealPlanner = new MealPlanner();

        // creating meals
        Meal<VegetarianMeal> vegMeal = new Meal<>(new VegetarianMeal("Broccoli"));
        Meal<VeganMeal> veganMeal = new Meal<>(new VeganMeal(true));
        Meal<KetoMeal> ketoMeal = new Meal<>(new KetoMeal(70));
        Meal<HighProteinMeal> proteinMeal = new Meal<>(new HighProteinMeal(40));

        // adding meals to mealPlanner
        mealPlanner.addMeal(vegMeal);
        mealPlanner.addMeal(veganMeal);
        mealPlanner.addMeal(ketoMeal);
        mealPlanner.addMeal(proteinMeal);

        // displaying meals
        mealPlanner.displayMeals();
    }
}
