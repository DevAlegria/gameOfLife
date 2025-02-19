import java.util.*;

public class App {
    public static void main(String[] args) throws InterruptedException {
        UserInterface ui = new UserInterface();
        ConfigGoL configGoL = new ConfigGoL();
        configGoL.setConfig();

        List<Generation> generationsList = new ArrayList<>();
        Generation generation = new Generation(null);
        generation.createStartGeneration(configGoL.getWidth(), configGoL.getHeight(), configGoL.getPopulation());
        generationsList.add(generation);
        ui.print(generation.getGeneration());

        int i = 0;
        while (i < configGoL.getGenerations() || configGoL.getGenerations() == 0) {
            Thread.sleep(configGoL.getSpeed());
            Generation nextGeneration = new Generation(
                    generationsList.get(generationsList.size() - 1).getGenerationArray());

            nextGeneration.getNextGeneration(configGoL.getNeighborhood());
            generationsList.add(nextGeneration);
            ui.printSummaryStatus(nextGeneration.countLives(), configGoL.getWidth() + "x" + configGoL.getHeight(),
                    i + 1,
                    configGoL.getGenerations(), configGoL.getSpeed(),
                    configGoL.getNeighborhood());
            ui.print(nextGeneration.getGeneration());
            if (nextGeneration.countLives() == 0)
                break;
            i++;
        }
    }
}