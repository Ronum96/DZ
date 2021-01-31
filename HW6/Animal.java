public class Animal implements AnimalInterface {
    private double animalDistanceRun, getAnimalDistanceSwim;

    Animal(double animalDistanceRun, double getAnimalDistanceSwim) {
        this.animalDistanceRun = animalDistanceRun;
        this.getAnimalDistanceSwim = getAnimalDistanceSwim;
    }



    public  boolean run(double value) {
        return  animalDistanceRun > value;
    }

    @Override
    public  boolean swim(double value) {
        return getAnimalDistanceSwim > value;
    }

    double getAnimalDistanceRun() {
        return animalDistanceRun;
    }

    double getGetAnimalDistanceSwim() {
        return getAnimalDistanceSwim;
    }


}
