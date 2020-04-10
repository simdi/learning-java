package app;

import java.math.BigDecimal;
import java.util.Scanner;

public class App {

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
    app.collectUserInputAnPrint();
  }
}