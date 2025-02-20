public class Neighborhood {
  private int[][] neighbors = new int[0][2];
  private String name = "No Name";

  Neighborhood(String name) {
    this.name = name;
    neighbors[0][0] = 1;
  }

  Neighborhood(String name, String neighborhood) {
    this.name = name;
    this.setNeighbors(neighborhood);
  }

  public int[][] getNeigbors() {
    return neighbors;
  }

  public String getName() {
    return this.name;
  }

  public void setNeighbors(String neigborhood) {
    for (int index = 0, i = -1, j = -1; index < neigborhood.length(); index++) {

      if (!(i == 0 && j == 0)) {

        char celula = neigborhood.charAt(index);
        if (celula == '0') {
          j++;
        } else if (celula == '1') {
          this.setValueToNeighbors(new int[] { i, j });
          j++;
        } else if (celula == '#') {
          j = -1;
          i++;
        }

      } else
        j++;

    }
  }

  @Override
  public String toString() {
    StringBuilder strNeigbors = new StringBuilder();
    strNeigbors.append(this.name + "\n");
    boolean[][] neigborhood = new boolean[3][3];
    for (int[] celula : this.neighbors) {
      neigborhood[celula[0] + 1][celula[1] + 1] = true;
    }
    for (int i = 0; i < neigborhood.length; i++) {
      strNeigbors.append("\t");
      for (int j = 0; j < neigborhood.length; j++) {
        if (i == 1 && j == 1) {
          strNeigbors.append("o ");
          continue;
        }
        if (neigborhood[i][j]) {
          strNeigbors.append("x ");
        } else {
          strNeigbors.append("· ");
        }
      }
      strNeigbors.append("\n");
    }
    return strNeigbors.toString();
  }

  private void setValueToNeighbors(int[] array) {

    int[][] auxNeighbors = new int[neighbors.length + 1][2];
    for (int i = 0; i < this.neighbors.length; i++) {
      auxNeighbors[i] = this.neighbors[i];
    }
    auxNeighbors[auxNeighbors.length - 1] = array;
    neighbors = auxNeighbors;

  }
}
