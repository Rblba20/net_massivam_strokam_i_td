import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File inputFile = new File("input.txt");
        File outputFile = new File("output.txt");

        Scanner scanner = new Scanner(inputFile);
        PrintWriter writer = new PrintWriter(outputFile);

        // Прочитаем все целые числа из входного файла и подсчитаем количество элементов
        int count = 0;
        while (scanner.hasNextInt()) {
            scanner.nextInt();
            count++;
        }

        scanner.close();

        scanner = new Scanner(inputFile);

        // Посчитаем индекс середины массива (половины)
        int midIndex = count / 2;

        // Начиная с индекса середины до конца массива, запишем числа в выходной файл
        for (int i = 0; i < count; i++) {
            if (i >= midIndex) {
                writer.print(scanner.nextInt() + " ");
            } else {
                scanner.nextInt();
            }
        }

        // Затем начиная с начала массива до индекса середины, запишем числа в выходной файл
        scanner = new Scanner(inputFile); // вернемся в начало файла
        for (int i = 0; i < midIndex; i++) {
            writer.print(scanner.nextInt() + " ");
        }

        scanner.close();
        writer.close();
    }
}