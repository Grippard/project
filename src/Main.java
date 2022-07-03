import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Enter arabian or roman numbers");
            new Calc().doCalc(scanner.nextLine());
        } catch (main.OverOfValuesExeption | main.OnlyRomanOrArabianExeption e) {
            throw new RuntimeException(e);
        }
    }
}
