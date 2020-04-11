package app;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Scanner;

public class App {

  private static void readDataFromNet() throws IOException {
    final String FLOWER_FEED = "http://services.hanselandpetal.com/feeds/flowers.xml";

    InputStream inputStream = null;
    BufferedInputStream bufferedInputStream = null;
    
    try {
      URL url = new URL(FLOWER_FEED);
      inputStream = url.openStream();
      bufferedInputStream = new BufferedInputStream(inputStream);
  
      StringBuilder sb = new StringBuilder();
  
      while (true) {
        int data = bufferedInputStream.read();
        if (data == -1) {
          break;
        } else {
          System.out.println(data);
          sb.append((char) data);
        }
      }

      // System.out.println(sb);
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      inputStream.close();
      bufferedInputStream.close();
    }

  }

  private static void readFileWithNewIO() {
    Path sourcePath = Paths.get("file", "text.txt");
    Path targetPath = Paths.get("file", "new_target.txt");

    try {
      Files.copy(sourcePath, targetPath, StandardCopyOption.REPLACE_EXISTING);
      System.out.println("File copied!");
    } catch (Exception e) {
      System.out.println("Error copying file");
      e.printStackTrace();
    }
  }

  private static void readFile() {
    String sourceFile = "file/text.txt";
    String targetFile = "file/target.txt";

    // You use the try resource because you want to auto close io files.
    try (
      FileReader fileReader = new FileReader(sourceFile);
      BufferedReader bufferedReader = new BufferedReader(fileReader);
      FileWriter fileWriter = new FileWriter(targetFile)
    ) {
      while (true) {
        String line = bufferedReader.readLine();
        if (line == null) {
          break;
        } else {
          fileWriter.write(line + "\n");
        }
      }
      System.out.println("File copied!");
    } catch (Exception e) {
      System.out.println("There was an error reading or writing to file.");
      e.printStackTrace();
    }
  }

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

    // App app = new App();
    // app.collectUserInputAnPrint();
    // app.simpleCalculator();
    // app.throwingExceptions();

    // readFile();
    // readFileWithNewIO();
    readDataFromNet();
  }
}