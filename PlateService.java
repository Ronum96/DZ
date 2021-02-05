package Services;

import Models.Plate;

public class PlateService {

    protected Plate plate;

    public PlateService(Plate plate){
        this.plate = plate;
    }

    public void feederFiller(Plate plate, int foodCount){
        plate.setFoodCount(foodCount);
        System.out.println("In the plate " + foodCount + " units of food.");
    }
}