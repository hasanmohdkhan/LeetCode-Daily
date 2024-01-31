package Daily.december;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 17-Dec-23
 * @Description : <a href="https://leetcode.com/problems/design-a-food-rating-system/?envType=daily-question&envId=2023-12-17">link</a>
 */
public class DesignAFoodRatingSystem {

    public static void main(String[] args) {
        String[] f = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] c = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] r = {9, 12, 8, 15, 14, 7};

        FoodRatings obj = new FoodRatings(f, c, r);
        System.out.println("highestRated = " + obj.highestRated("korean"));
        System.out.println("highestRated = " + obj.highestRated("japanese"));
        obj.changeRating("sushi", 16);
        System.out.println("highestRated = " + obj.highestRated("japanese"));

        obj.changeRating("ramen", 16);

        System.out.println("highestRated = " + obj.highestRated("japanese"));

    }

}

class FoodRatings {

    private final HashMap<String, Food> foodHashMap = new HashMap<>();
    private final HashMap<String, TreeSet<Food>> cuisineSet = new HashMap<>();

    private static class CompFood implements Comparator<Food> {
        @Override
        public int compare(Food o1, Food o2) {
            if (o1.rated == o2.rated) {
                return o1.foodName.compareTo(o2.foodName); // comparing in ascending order for food name
            }
            return Integer.compare(o2.rated, o1.rated);  // comparing in descending order
           //   return Integer.compare(o1.rated, o2.rated); // comparing in ascending order
        }
    }

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        for (int i = 0; i < foods.length; i++) {
            Food food = new Food(foods[i], ratings[i], cuisines[i]);
            foodHashMap.put(foods[i], food);
            if (cuisineSet.containsKey(cuisines[i])) {
                cuisineSet.get(cuisines[i]).add(food);
            } else {
                TreeSet<Food> newFood = new TreeSet<>(new CompFood());
                newFood.add(food);
                cuisineSet.put(cuisines[i], newFood);
            }
        }
    }

    public void changeRating(String food, int newRating) {
        Food currFood = foodHashMap.get(food);
        cuisineSet.get(currFood.cuisineBelongTo).remove(currFood);
        currFood.rated = newRating;
        cuisineSet.get(currFood.cuisineBelongTo).add(currFood);
    }

    public String highestRated(String cuisine) {
        TreeSet<Food> foodTreeSet = cuisineSet.get(cuisine);
        Iterator<Food> iterator = foodTreeSet.iterator();

     /*   while (iterator.hasNext()){
            Food next = foodTreeSet.iterator().next();
            System.out.println("name = " + next.foodName);
            System.out.println("rated = " + next.rated);
        }*/


        for (Food f : foodTreeSet) {
            System.out.println("f = " + f);
        }


        return cuisineSet.get(cuisine).first().foodName;
    }


    static class Food {
        private final String foodName;
        private int rated;
        private final String cuisineBelongTo;

        public Food(String foodName, Integer rated, String cuisineBelongTo) {
            this.foodName = foodName;
            this.rated = rated;
            this.cuisineBelongTo = cuisineBelongTo;
        }

        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("foodName='").append(foodName).append('\'');
            sb.append(", rated=").append(rated);
            sb.append(", cuisineBelongTo='").append(cuisineBelongTo).append('\'');
            //  sb.append('');
            return sb.toString();
        }

    }


}
