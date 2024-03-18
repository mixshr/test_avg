import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        System.out.println("Введите количество чисел (Для выхода введите exit)");
        Integer intInput = enterNumber();

        if (intInput == null) {
            System.out.println("Доброго времени суток!");
            return;
        }

        System.out.println("Перечислите числа по которым вы хотите рассчитать среднее значение" +
                " (Для прерывания введите exit)"
        );

        int[] intArray = new int[intInput];
        for (int i = 0; i < intArray.length; i++) {
            Integer arrValue = enterNumber();

            if (arrValue == null) {
                System.out.println("Операция была прервана! Доброго времени суток!");
                return;
            }
            intArray[i] = arrValue;
        }

        System.out.println("Ваше среднее значение: "  + IntStream.of(intArray).average().getAsDouble());
    }

    static Integer enterNumber() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int intInput = 0;
        boolean dontStop = true;
        do {
            try {
                String input = reader.readLine();
                if (input.equals("exit")) {
                    return null;
                }

                intInput = Integer.parseInt(input);
                dontStop = false;
            } catch (Exception e) {
                System.out.println("Вы ввели не целочисленное значение повторите еще раз");
            }
        } while (dontStop);

        return intInput;
    }
}