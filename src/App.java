import java.util.*;

public class App {
    public static void main(String[] args) throws InterruptedException {

        ConfigGoL game = new ConfigGoL();
        game.setConfig();

        String[] selectedNeigborhod = Params.neighborhoods[game.getNeighborhood()];
        Neigborhood neigborhood = new Neigborhood(selectedNeigborhod[0]);
        neigborhood.setNeigbors(selectedNeigborhod[1]);

        List<Generation> generationsList = new ArrayList<>();
        Generation generation = new Generation(null);
        generation.createStartGeneration(game.getWidth(), game.getHeight(), game.getPopulation());
        generationsList.add(generation);

        System.out.println(generation.getGeneration());

        int i = 0;
        while (i < game.getGenerations() || game.getGenerations() == 0) {
            Generation nextGeneration = new Generation(
                    generationsList.get(generationsList.size() - 1).getGenerationArray());

            nextGeneration.getNextGeneration(neigborhood);
            generationsList.add(nextGeneration);
            System.out.println(nextGeneration.getGeneration());
            i++;
            Thread.sleep(game.getSpeed());
        }
    }
}