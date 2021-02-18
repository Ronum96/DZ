public class Main {

    public static void main(String[] args) {



        String[][] correctMatrix = {
                {"3", "7", "3", "1"},
                {"1", "6", "0", "4"},
                {"0", "5", "7", "2"},
                {"0", "2", "7", "8"}
        };
        String[][] wrongSizeMatrix = {
                {"1", "2", "0", "3"},
                {"6", "4", "1", "5"},
                {"9", "2", "7", "4"},
                {"0", "2"}
        };
        String[][] wrongCharMatrix = {
                {"1", "9", "2", "3"},
                {"6", "1", "5", "7"},
                {"2", "Z", "7", "6"},
                {"1", "9", "4", "5"}
        };

        try {
            System.out.println("Вариант 1:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(correctMatrix) + ".\n");
        } catch (CustomException e) {
            e.getMessage();
        }

        try {
            System.out.println("Вариант 2:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongSizeMatrix) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

        try {
            System.out.println("Вариант 3:");
            System.out.println("Сумма всех элементов массива равна " + Converter.strConverter(wrongCharMatrix) + ".\n");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }
}