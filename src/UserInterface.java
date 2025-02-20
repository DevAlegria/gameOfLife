import java.util.Scanner;

public class UserInterface {
  final private Scanner scanner = new Scanner(System.in);

  public int inputInt(String text) {
    System.out.print(text);
    String input = scanner.nextLine().trim();

    if (input.isEmpty()) {
      return -1;
    } else {
      if (input.matches("-?\\d+")) {
        return Integer.parseInt(input);
      } else
        return -2;
    }
  }

  public String inputString(String title) {
    System.out.print(title);
    String input = scanner.nextLine().trim();
    return input;
  }

  public String inputPopulation() {
    String input;
    System.out.print("Enter the initial population -> '101#011#1101': ");
    input = scanner.nextLine().trim();

    if (input.isEmpty()) {
      return "-1";
    }

    if (input.equals("rnd") || input.matches("[01#]+")) {
      return input;
    }
    return "-2";
  }

  public void printStatus(int width, int height, int generations, int speed, String neighborhood,
      String population) {
    System.out.println("Intial Status App");
    this.printVariableStatus(" > Width", width, false, null);
    this.printVariableStatus(" > height", height, false, null);
    this.printVariableStatus(" > Generations", generations, generations == 0, "Infinity");
    this.printVariableStatus(" > Speed", speed, false, null);
    this.printVariableStatus(" > Neighborhood", 0, true, neighborhood);
    this.printPopulationStatus(population);
  }

  public void printSummaryStatus(int lives, String board, int currentGeneration, int generations, int speed,
      Neighborhood neighborhood) {
    System.out.println("STATUS");
    System.out.println(
        "Lives: " + lives + "\tGeneration: " + currentGeneration + (generations > 0 ? " of " + generations : ""));
    System.out.println("Board: " + board + "\tSpeed: " + speed);
    System.out.println("Neigborhood: " + neighborhood.getName());
    System.out.println();
  }

  public void printVariableStatus(String name, int value, boolean condition, String text) {
    String status = String.valueOf(value);
    if (condition)
      status = text;
    else if (value == -1)
      status = "No Present";
    else if (value == -2)
      status = "Invalid";

    System.out.println(
        name + " : [ " + status + " ]");
  }

  public void printPopulationStatus(String population) {
    if (population.equals("-1"))
      population = "No present";
    else if (population.equals("-2"))
      population = "Invalid";

    System.out.println(
        " > Population" + " : '" + population + "'");
  }

  public void print(String text) {
    System.out.println(text);
  }
}
