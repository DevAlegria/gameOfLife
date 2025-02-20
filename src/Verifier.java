public class Verifier {
  public static int verifyWidth(int value) {
    if (value < 0)
      return value;
    for (int width : Constants.widthValues) {
      if (value == width)
        return value;
    }
    return -2;
  }

  public static int verifyHeight(int value) {
    if (value < 0)
      return value;
    for (int height : Constants.heightValues) {
      if (value == height)
        return value;
    }
    return -2;
  }

  public static int verifyNeighborhood(int value) {
    if (value < 0)
      return value;
    if (value >= 0 || value < Constants.neighborhoods.length)
      return value;
    return -2;
  }

  public static int verifyGenerations(int value) {
    if (value < 0)
      return value;
    return value;

  }

  public static int verifySpeed(int value) {
    if (value < 0)
      return value;
    if (value == -1 || value < 250 || value > 1000)
      return -2;
    return value;

  }

  public static String verifyPopulation(String value, int width, int height) {
    if (value.equals("-1") || value.equals("-2") ||value.equals("rnd"))
      return value;

    String[] rows = value.split("#");

    if (rows.length > height) {
      return "-2";
    }

    for (String row : rows) {
      if (row.length() > width) {
        return "-2";
      }
    }

    return value;
  }
}
