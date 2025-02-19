import java.util.ArrayList;
import java.util.List;

public class Neighborhood {
  private List<int[]> neighbors = new ArrayList<>();
  private String name = "No Name";

  Neighborhood(String name) {
    this.name = name;
  }
  Neighborhood(String name, String neighborhood) {
    this.name = name;
    this.setNeigbors(neighborhood);
  }

  public List<int[]> getNeigbors() {
    return neighbors;
  }

  public String getName() {
    return this.name;
  }

  public void setNeigbors(String neigborhood) {
    for (int index = 0, i = -1, j = -1; index < neigborhood.length(); index++) {

      if (i == 0 && j == 0) {
        j++;
        continue;
      }

      char celula = neigborhood.charAt(index);
      switch (celula) {
        case '0':
          j++;
          break;
        case '1':
          this.neighbors.add(new int[] { i, j });
          j++;
          break;
        case '#':
          j = -1;
          i++;
          break;

        default:
          break;
      }
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
}
