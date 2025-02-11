package day1_generics.mealplanner;

public class Meal <T extends MealPlan>{
    private T mealType;

    public Meal(T mealType){
        this.mealType = mealType;
    }

    public T getMealType() {
        return mealType;
    }

    @Override
    public String toString() {
        return mealType.getMealDetails();
    }
}
