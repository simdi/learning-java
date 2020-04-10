package app;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

  private void throwingExceptions() {
    String welcome = "Welcome!";
    char[] chars = welcome.toCharArray();

    System.out.println("Welcome: " + welcome);
    for (char c : chars) {
      System.out.println("Character: " + c);
    }

    try {
      if (chars.length < 10) {
        throw new Exception("String out of bound!!!!");
      }
      char lastChar = chars[chars.length - 1];
      System.out.println("Last character is: " + lastChar);

      String substring = welcome.substring(10);
      System.out.println("Substring is: " + substring);
    } catch (ArrayIndexOutOfBoundsException e) {
      // e.printStackTrace();
      System.out.println("Array out of bound");
    } catch (StringIndexOutOfBoundsException e) {
      System.out.println("String out of bound");
    } catch (Exception e) {
      System.out.println("Error: " + e.getMessage());
    }
  }

  private void simpleCalculator() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter a numeric value: ");
    double val1 = Double.parseDouble(scanner.nextLine());
    System.out.println("Enter a numeric value: ");
    double val2 = Double.parseDouble(scanner.nextLine());
    scanner.close();

    double sum = val1 + val2;
    System.out.println("The result is: " + sum);
  }

  private void collectUserInputAnPrint() {
    Scanner scanner = new Scanner(System.in);
    System.out.println("Enter your name: ");
    String input = scanner.nextLine();
    scanner.close();

    StringBuilder strBuilder = new StringBuilder("Hello ");
    strBuilder.append(input);
    strBuilder.append(", welcome to the world");
    System.out.println(strBuilder);
  }
  public static void main(String[] args) throws Exception {
    System.out.println("Hello Java");

    // double value = .012d;
    // System.out.println("VAlue: " + value);
    // double pSum = value + value + value;
    // System.out.println("Sum of primitives: " + pSum);

    // // To use BigDecimal, you have to first convert it to string.
    // String strValue = Double.toString(value);
    // System.out.println("String value : " + strValue);

    // // We need to pass the converted string value to the BigDecimal
    // BigDecimal bigDecimal = new BigDecimal(strValue);
    // System.out.println("BigDecimal: " + bigDecimal);
    // BigDecimal bigDecimalSum = bigDecimal.add(bigDecimal).add(bigDecimal).add(bigDecimal);
    // System.out.println("BIg Decimal Sum: " + bigDecimalSum);

    App app = new App();
    // app.collectUserInputAnPrint();
    // app.simpleCalculator();
    app.throwingExceptions();
  }
}