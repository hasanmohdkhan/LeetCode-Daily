package strivers.linkedlist;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Auther : hasan.khan
 * @Created : 17-Jan-25
 * @Description : <a href="">link</a>
 */
public class Polymorphism {

    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();
        animal = new Dog();
        animal.sound();

        String s = "asdfaghjklkjhgfdsa";

        Optional<Character> first = s.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(c -> c, LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(entry -> entry.getValue() > 1)
                .map(Map.Entry::getKey)
                .findFirst();

        System.out.println("first = " + first.orElse(null));

        List<String> e = List.of("C", "D", "Z", "X", "A");
        List<String> collect = e.stream().sorted().collect(Collectors.toList());
        System.out.println("sorted = " + collect);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);

        System.out.println("Sequential Stream:");
        numbers.stream().forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));

        System.out.println("Parallel Stream:");
        numbers.parallelStream().forEach(num -> System.out.println(num + " " + Thread.currentThread().getName()));


    }
}


class  Animal {
    public void sound(){
        System.out.println("Animal default sound!");
    }
}

class Dog extends Animal {
    public void sound(){
        System.out.println("Bark!!");
    }

}
