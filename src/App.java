import java.util.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        UserInterface ui = new UserInterface();
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
            Thread.sleep(game.getSpeed());
            Generation nextGeneration = new Generation(
                    generationsList.get(generationsList.size() - 1).getGenerationArray());

            nextGeneration.getNextGeneration(neigborhood);
            generationsList.add(nextGeneration);
            ui.printState(0, game.getWidth() + "x" + game.getHeight(), i + 1, game.getGenerations(), game.getSpeed(),
                    game.getNeighborhood());
            ui.print(nextGeneration.getGeneration());

            i++;
        }
    }
}