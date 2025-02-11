package day1_generics.mealplanner;

import java.util.ArrayList;
import java.util.List;

public class MealPlanner {
    private List<Meal <? extends MealPlan>> mealPlans = new ArrayList<>();

    public void addMeal(Meal<? extends MealPlan> meal){
        if(validateMeal(meal)){
            mealPlans.add(meal);
        }
        else{
            System.out.println("Invalid meal plan : " + meal);
        }
    }

    public <T extends MealPlan> boolean validateMeal(Meal<T> meal) {
        return meal.getMealType() != null;
    }

    public void displayMeals(){
        System.out.println("Meal Plan :-");
        for(Meal<? extends MealPlan> meal : mealPlans){
            System.out.println(meal);
        }
    }
}
