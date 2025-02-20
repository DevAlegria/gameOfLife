public class App {
    public static void main(String[] args) throws InterruptedException {
        UserInterface ui = new UserInterface();
        ConfigGoL configGoL = new ConfigGoL();
        configGoL.setConfig();

        Generation[] generationsArray = null;

        Generation generation = new Generation(null);
        generation.createStartGeneration(configGoL.getWidth(), configGoL.getHeight(), configGoL.getPopulation());
        generationsArray = addValueToGenerations(generationsArray, generation);

        ui.print("\nInitial Population");
        ui.print(generation.getGeneration());

        int i = 0;
        while ((i < configGoL.getGenerations() || configGoL.getGenerations() == 0)
                && generationsArray[generationsArray.length - 1].countLives() != 0) {
            Thread.sleep(configGoL.getSpeed());

            Generation nextGeneration = new Generation(
                    generationsArray[generationsArray.length - 1].getGenerationArray());
            nextGeneration.getNextGeneration(configGoL.getNeighborhood());
            generationsArray = addValueToGenerations(generationsArray, nextGeneration);

            ui.printSummaryStatus(nextGeneration.countLives(), configGoL.getWidth() + "x" + configGoL.getHeight(),
                    i + 1,
                    configGoL.getGenerations(), configGoL.getSpeed(),
                    configGoL.getNeighborhood());
            ui.print(nextGeneration.getGeneration());
            i++;
        }
    }

    public static Generation[] addValueToGenerations(Generation[] pastGenerations, Generation newGeneration) {

        int size = pastGenerations == null ? 1 : pastGenerations.length + 1;

        Generation[] auxGeneration = new Generation[size];

        for (int i = 0; pastGenerations != null && i < pastGenerations.length; i++) {
            auxGeneration[i] = pastGenerations[i];
        }
        auxGeneration[auxGeneration.length - 1] = newGeneration;
        pastGenerations = auxGeneration;

        return pastGenerations;
    }
}