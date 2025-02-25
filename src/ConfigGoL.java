import java.util.Random;

public class ConfigGoL {
  private int width, height, generations, speed, auxNeighborhood;
  private String population;
  private Neighborhood neighborhood;

  public void setConfig() {
    UserInterface ui = new UserInterface();
    this.width = ui.inputInt("Enter the width of the GoL board [10, 20, 40, 80] > ");
    this.width = Verifier.verifyWidth(this.width);

    this.height = ui.inputInt("Enter the height of the Gol Board [10, 20, 40] > ");
    this.height = Verifier.verifyHeight(this.height);

    this.generations = ui.inputInt("Enter the number of generations: ");
    this.generations = Verifier.verifyGenerations(this.generations);

    this.speed = ui.inputInt("Enter the speed between 250 to 1000 milliseconds: ");
    this.speed = Verifier.verifySpeed(this.speed);

    this.auxNeighborhood = ui.inputInt("Enter the neighborhood: ");
    this.auxNeighborhood = Verifier.verifyNeighborhood(this.auxNeighborhood);

    if (auxNeighborhood >= 0) {
      this.neighborhood = new Neighborhood(Constants.getNeighborhoodName(auxNeighborhood),
          Constants.getNeighborhood(auxNeighborhood));
    }

    this.population = ui.inputPopulation();
    this.population = Verifier.verifyPopulation(this.population, this.width, this.height);

    ui.printStatus(this.width, this.height, this.generations, this.speed,
        neighborhood == null ? auxNeighborhood == -1 ? "No Present" : "Invalid" : neighborhood.getName(),
        this.population);
    System.out.println(this.population.equals("rnd"));
    if (this.population.equals("rnd"))
      this.population = createRandomGrid(this.height > 0 ? height : 10, this.width > 0 ? width : 10);

    if (!isValidConfig()) {
      String selected = ui.inputString("[You have invalid values!]\n    Playing with default values? (Yes/No) > ")
          .toLowerCase();
      if (selected.equals("y") || selected.equals("yes")) {
        this.setDefaultConfig();
        ui.printStatus(this.width, this.height, this.generations, this.speed, this.neighborhood.getName(),
            this.population);
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

    if (this.population.equals("-1") || this.population.equals("-2") || this.population.equals("rnd")) {
      this.population = createRandomGrid(this.height > 0 ? height : 10, this.width > 0 ? width : 10);
    }

    if (auxNeighborhood < 0)
      this.neighborhood = new Neighborhood(Constants.getNeighborhoodName(0),
          Constants.getNeighborhood(0));
  }

  private boolean isValidConfig() {
    return !(this.width < 0 || this.height < 0 || this.auxNeighborhood < 0 || this.speed < 0 || this.generations < 0
        || this.population.equals("-1") || this.population.equals("-2"));
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

  public Neighborhood getNeighborhood() {
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
