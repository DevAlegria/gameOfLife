import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Params {
  final static List<Integer> widthValues = new ArrayList<>(Arrays.asList(10, 20, 40, 80));
  final static List<Integer> heightValues = new ArrayList<>(Arrays.asList(10, 20, 40));
  final static String[][] neighborhoods = {
      { "Moore", "111#111#111" },
      { "Jala", "010#101#010" },
      { "Programming", "110#101#011" },
      { "Moore", "111#111#111" },
      { "Reverse Jala", "101##101" },
      { "Custom", "111##11  1" },
  };

  public static String getNeighborhoodName(int index) {
    return neighborhoods[index][0];
  }

  public static int verifyWidth(int value) {
    if (value < 0)
      return value;
    for (int width : widthValues) {
      if (value == width)
        return value;
    }
    return -2;
  }

  public static int verifyHeight(int value) {
    if (value < 0)
      return value;
    for (int height : heightValues) {
      if (value == height)
        return value;
    }
    return -2;
  }

  public static int verifyNeighborhood(int value) {
    if (value < 0)
      return value;
    if (value >= 0 || value < neighborhoods.length)
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
    if (value.equals("-1") || value.equals("-2"))
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
