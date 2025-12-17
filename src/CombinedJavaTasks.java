import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class CombinedJavaTasks {

    // Задача 1: Метод для замены элементов массива
    public static <T> void swapElements(T[] array, int index1, int index2) {
        if (array == null || index1 < 0 || index2 < 0 ||
                index1 >= array.length || index2 >= array.length) {
            throw new IllegalArgumentException("Некорректные индексы или массив");
        }

        T temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    // Задача 2: Параметризованный класс Box
    static class Box<T extends Number> {
        private T value;

        public Box(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public double getNumberValue() {
            return value.doubleValue();
        }

        public static double sumBoxes(Box<?>... boxes) {
            double sum = 0;
            for (Box<?> box : boxes) {
                if (box.getValue() instanceof Number) {
                    sum += ((Number) box.getValue()).doubleValue();
                }
            }
            return sum;
        }
    }

    // Задача 3: Проверка строки на наличие чисел
    public static void validateNoNumbers(String input) throws IllegalArgumentException {
        if (input == null) {
            throw new IllegalArgumentException("Строка не может быть null");
        }

        if (Pattern.compile("\\d").matcher(input).find()) {
            throw new IllegalArgumentException("Строка не должна содержать число!");
        }
    }

    // Главный метод
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("═".repeat(50));
        System.out.println("КОМБИНИРОВАННОЕ РЕШЕНИЕ ТРЕХ ЗАДАЧ");
        System.out.println("═".repeat(50));

        // Задача 1
        System.out.println("\n1. ЗАМЕНА ЭЛЕМЕНТОВ В МАССИВЕ:");
        Integer[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Исходный массив: " + Arrays.toString(numbers));
        swapElements(numbers, 1, 3);
        System.out.println("После замены индексов 1 и 3: " + Arrays.toString(numbers));

        String[] words = {"Яблоко", "Банан", "Апельсин", "Груша"};
        System.out.println("Исходный массив: " + Arrays.toString(words));
        swapElements(words, 0, 2);
        System.out.println("После замены индексов 0 и 2: " + Arrays.toString(words));

        // Задача 2
        System.out.println("\n2. РАБОТА С КЛАССОМ BOX:");
        Box<Integer> intBox = new Box<>(15);
        Box<Double> doubleBox = new Box<>(7.8);
        Box<Float> floatBox = new Box<>(3.14f);

        System.out.println("Коробка с целым числом: " + intBox.getValue());
        System.out.println("Коробка с дробным числом: " + doubleBox.getValue());
        System.out.println("Коробка с float числом: " + floatBox.getValue());

        double sum = Box.sumBoxes(intBox, doubleBox, floatBox);
        System.out.println("Сумма всех чисел в коробках: " + sum);

        // Задача 3
        System.out.println("\n3. ПРОВЕРКА СТРОКИ НА НАЛИЧИЕ ЧИСЕЛ:");

        try {
            System.out.print("Введите строку без чисел: ");
            String input1 = scanner.nextLine();
            validateNoNumbers(input1);
            System.out.println("✓ Строка корректна: \"" + input1 + "\"");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        try {
            System.out.print("Введите другую строку: ");
            String input2 = scanner.nextLine();
            validateNoNumbers(input2);
            System.out.println("✓ Строка корректна: \"" + input2 + "\"");
        } catch (IllegalArgumentException e) {
            System.out.println("✗ Ошибка: " + e.getMessage());
        }

        scanner.close();

        System.out.println("\n═".repeat(25));
        System.out.println("ВСЕ ЗАДАЧИ ВЫПОЛНЕНЫ");
        System.out.println("═".repeat(25));
    }
}