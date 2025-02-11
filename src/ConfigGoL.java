import java.util.Random;

public class ConfigGoL {
  private int width, height, generations, speed, neighborhood;
  private String population;

  public void setConfig() {
    UserInterface ui = new UserInterface();
    this.width = ui.inputInt("Enter the width of the GoL board [10, 20, 40, 80] > ");
    this.width = Params.verifyWidth(this.width);

    this.height = ui.inputInt("Enter the height of the Gol Board [10, 20, 40] > ");
    this.height = Params.verifyHeight(this.height);

    this.generations = ui.inputInt("Enter the number of generations: ");
    this.generations = Params.verifyGenerations(this.generations);

    this.speed = ui.inputInt("Enter the speed between 250 to 1000 milliseconds: ");
    this.speed = Params.verifySpeed(this.speed);

    this.neighborhood = ui.inputInt("Enter the neighborhood: ");
    this.neighborhood = Params.verifyNeighborhood(this.neighborhood);

    this.population = ui.inputPopulation();
    this.population = Params.verifyPopulation(this.population, this.width, this.height);
    System.out.println(population);
    ui.printStatus(this.width, this.height, this.generations, this.speed, this.neighborhood, this.population);

    if (!isValidConfig()) {
      String selected = ui.inputString("[You have invalid values!]\n    Playing with default values? (Yes/No) > ")
          .toLowerCase();
      if (selected.equals("y") || selected.equals("yes")) {
        this.setDefaultConfig();
        ui.printStatus(this.width, this.height, this.generations, this.speed, this.neighborhood, this.population);
      } else {
        ui.print("The configuration values are not valid\n    End Game");
        System.exit(0);
      }
    }

  }

  private void setDefaultConfig() {
    if (this.width < 0)
      this.width = 10;

    if (this.height < 0)
      this.height = 10;

    if (this.generations < 0)
      this.generations = 0;

    if (this.speed < 0)
      this.speed = 1000;

    if (this.neighborhood < 0)
      this.neighborhood = 0;

    if (this.population.equals("-1") || this.population.equals("-2")) {
      this.population = createRandomGrid(this.height > 0 ? height : 10, this.width > 0 ? width : 10);
    }
  }

  private boolean isValidConfig() {
    if (this.width < 0 || this.height < 0 || this.neighborhood < 0 || this.speed < 0 || this.generations < 0
        || this.population.equals("-1") || this.population.equals("-2"))
      return false;
    return true;
  }

  public int getWidth() {
    return this.width;
  }

  public int getHeight() {
    return this.height;
  }

  public int getGenerations() {
    return this.generations;
  }

  public int getSpeed() {
    return this.speed;
  }

  public int getNeighborhood() {
    return this.neighborhood;
  }

  public String getPopulation() {
    return this.population;
  }

  static String createRandomGrid(int rows, int cols) {
    var random = new Random();
    String grid = new String("");
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        grid += random.nextBoolean() ? "1" : "0";
      }
      if (i < rows - 1)
        grid += "#";
    }
    ;
    return grid;
  }
}
