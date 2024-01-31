package Daily.december;

import java.util.*;

/**
 * @Auther : hasan.khan
 * @Created : 15-Dec-23
 * @Description : <a href="https://leetcode.com/problems/destination-city/description/">link</a>
 */
public class DestinationCity {

    public String destCity(List<List<String>> paths) {

        Set<String> graph = new HashSet<>();

        for (List<String> path : paths) {
            String sourceCity = path.get(0);
          //  System.out.println("sourceCity = " + sourceCity);
            graph.add(sourceCity);
        }

        for (List<String> path : paths) {

            String dest = path.get(1);
          //  System.out.println("DestCity = " + dest);
            if(!graph.contains(dest)) return dest;

        }

     //   System.out.println("strings = " + strings);
        return "";
    }


    public static void main(String[] args) {
        List<String> paths = new ArrayList<>();
        paths.add("London");
        paths.add("New York");

        List<String> paths1 = new ArrayList<>();
        paths1.add("New York");
        paths1.add("Lima");

        List<String> paths2 = new ArrayList<>();
        paths2.add("Lima");
        paths2.add("Sao Paulo");

        List<List<String>> graph = new ArrayList<>();
        graph.add(paths);
        graph.add(paths1);
        graph.add(paths2);

        System.out.println("graph = " + graph);

        DestinationCity o = new DestinationCity();
        System.out.println("o = " + o.destCity(graph));
    }

}
