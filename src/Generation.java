public class Generation {
  private boolean[][] generation;

  public void setGeneration(boolean[][] generation) {
    this.generation = generation;
  }

  Generation(boolean[][] generation) {
    this.generation = generation;
  }

  public void getNextGeneration(Neighborhood neigborhood) {
    boolean[][] nextGeneration = new boolean[this.generation.length][this.generation[0].length];

    for (int i = 0; i < this.generation.length; i++) {
      for (int j = 0; j < this.generation[i].length; j++) {

        boolean current = this.generation[i][j];
        int lives = 0;
        for (int[] neigbor : neigborhood.getNeigbors()) {
          int x = i + neigbor[0];
          int y = j + neigbor[1];

          if (!(x < 0 || y < 0 || x >= this.generation.length || y >= this.generation[i].length)) {

            boolean value = this.generation[x][y];
            if (value)
              lives += 1;
          }

        }

        if (current) {
          if (lives > 3 || lives < 2) {
            current = false;
          }

        } else {
          if (lives == 3) {
            current = true;
          }
        }

        nextGeneration[i][j] = current;
      }
    }

    this.generation = nextGeneration;
  }

  public void createStartGeneration(int width, int height, String population) {
    boolean[][] startGeneration = new boolean[height][width];
    int i = 0;
    int j = 0;
    for (int index = 0; index < population.length(); index++) {

      char celula = population.charAt(index);
      if (celula == '0') {
        startGeneration[i][j] = false;
        j++;
      } else if (celula == '1') {
        startGeneration[i][j] = true;
        j++;
      } else if (celula == '#') {
        j = 0;
        i++;
      }
    }
    this.generation = startGeneration;
  }

  public String getGeneration() {
    StringBuilder generationStr = new StringBuilder();

    for (int i = 0; i < generation.length; i++) {
      for (int j = 0; j < generation[i].length; j++) {
        char celula = generation[i][j] ? 'x' : '·';
        generationStr.append(celula + " ");
      }
      generationStr.append("\n");

    }
    return generationStr.toString();
  }

  public int countLives() {
    /*
     * 1 1 1 0 1 1 1 0
     * 0 0 0 1 0 0 0 1
     * 1 1 1 0 1 1 1 0
     * 0 0 0 1 0 0 0 1
     * 1 1 1 0 1 1 1 0
     * 0 0 0 1 0 0 0 1
    */

    int lives = 0;
    for (int i = 0; i < generation.length / 2; i++) {
      for (int j = 0; j < generation[i].length / 2; j++) {
        if (generation[i][j])
          lives++;
        if (generation[generation.length - (i + 1)][j])
          lives++;
        if (generation[i][generation[i].length - (j + 1)])
          lives++;
        if (generation[generation.length - (i + 1)][generation[i].length - (j + 1)])
          lives++;
      }
    }
    return lives;
  }

  public boolean[][] getGenerationArray() {
    return this.generation;
  }

}
