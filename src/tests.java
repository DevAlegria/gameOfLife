public class tests {
  public static void main(String[] args) {
    Neighborhood neighborhood = new Neighborhood("test", "101##101");

    int[][] test = neighborhood.getNeigbors();
    for (int i = 0; i < test.length; i++) {
      for (int j = 0; j < test[i].length; j++) {
        System.out.println(test[i][j]);
      }
    }
  }
}
