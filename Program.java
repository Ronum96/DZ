import Interface.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Program {

    public static void main(String[] args) {
        /** TASK 1 */

        Windows win = new Windows();

        /** TASK 2 */

        int n = 4;

        Integer[] list = {1, 2, 3, 4, 5};

        System.out.println(search((x, y) -> {
            return Arrays.asList(y).indexOf(n);
        }, n, list));

/*        search((x, y) -> {
            for (int i = 0; i < y.length; i++) {
                if (y[i] == n)
                    return i;
            }
            return -1;
        }, n, list);*/

        /**
         * TASK 3
         */

        String s = "Лямбда";

        System.out.println(
                reverse(s1 -> {
                    StringBuffer bufer = new StringBuffer(s1);
                    bufer.reverse();
                    return bufer.toString();
                }, s)
        );

        /**
         * TASK 4
         */

        Integer[] z = new Integer[]{1, 6, 20, 8};

        System.out.println(
                maximum(z1 -> Arrays.stream(z1).
                                max(Integer::compare).
                                get()
                        , z)
        );

        /**
         * TASK 5
         */

        List<Integer> integerList = new ArrayList<>();
        integerList.add(2);
        integerList.add(3);
        integerList.add(20);
        integerList.add(5);
        integerList.add(1);

        System.out.println(
                average(list1 -> {
                    int count = list1.size();
                    int summ = 0;
                    for (int i : list1) {
                        summ += i;
                    }
                    return (double) summ / count;
                }, integerList)
        );


        /**
         * TASK 6
         */
        List<String> listString = new ArrayList<>();
        listString.add("Афоня");
        listString.add("Зеркало");
        listString.add("арбуз");
        listString.add("комод");
        listString.add("алгебра");
        listString.add("мармелад");


        List<String> newList = search(
                list1 -> list1.stream().
                        filter(p -> p.startsWith("а")).
                        collect(Collectors.toList())
                , listString);

        newList.forEach(System.out::println);


    }


    /**
     * TASK 2
     */
    public static int search(IndexNumberInterface ini, Integer n, Integer[] list) {
        return ini.search(n, list);
    }

    /**
     * TASK 3
     */
    public static String reverse(StringReverseInterface str, String s) {
        return str.reverse(s);
    }

    /**
     * TASK 4
     */
    public static Integer maximum(MaxNumberInList max, Integer[] list) {
        return max.maximum(list);
    }

    /**
     * TASK 5
     */
    public static Double average(AverageNumbers average, List<Integer> list) {
        return average.average(list);
    }

    /**
     * TASK 6
     */
    public static List<String> search(StringFilterInterface stringFilter, List<String> list) {
        return stringFilter.search(list);
    }
}