import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Calculator!");
        System.out.println("Enter 'exit' to quit.");

        while (true) {
            System.out.print("Enter an expression (e.g., 5 + 3): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            // 🔧 Sanitize input
            input = input.replaceAll("\\s+", ""); // Remove all whitespaces
            input = input.replaceAll("([+\\-*/])\\1+", "$1"); // Replace multiple same operators with one
            input = input.replaceAll("([+\\-*/]{2,})", "$1".substring(0, 1)); // Optional double check

            // ❌ Validation
            if (input.matches("^[+\\-*/].*") || input.matches(".*[+\\-*/]$")) {
                System.out.println("Error: Expression cannot start or end with an operator.");
                continue;
            }

            if (!input.matches("[0-9+\\-*/.()]+")) {
                System.out.println("Error: Invalid characters in the expression.");
                continue;
            }

            try {
                double result = calculator.Evaluate(input);

                if (result == Double.POSITIVE_INFINITY) {
                    throw new ArithmeticException("Division by zero");
                }
                if (Double.isNaN(result)) {
                    throw new IllegalArgumentException("Invalid expression");
                }

                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
    }
}
