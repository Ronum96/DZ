package Services;

import Models.Cat;

public class CatService {

    private Cat cat;
    private Services.PlateService plateService;

    public CatService(Cat cat, Services.PlateService plateService){
        this.cat=cat;
        this.plateService=plateService;
    }
    public void eater(int eatenFood) {

        if (!cat.isHungry()) {
            System.out.println(cat.getName() + " is not hungry.");
        }else
        if (eatenFood<0){
            System.out.println("Cats cant into negative food amount, DUDE!");
        }
        else {
            if (plateService.plate.getFoodCount() == 0) {
                System.out.println("Please fill the plate first!");
            } else {
                if ((plateService.plate.getFoodCount() - eatenFood) < 0) {
                    System.out.println("Not enough food! Cat " + cat.getName() + " is still hungry!");
                } else {
                    int a = plateService.plate.getFoodCount();
                    a -= eatenFood;
                    plateService.plate.setFoodCount(a);
                    System.out.println("The cat " + cat.getName() + " ate " + eatenFood + " units of food.");
                    System.out.println("There are " + plateService.plate.getFoodCount() + " units of food left.");
                    cat.setHungry(false);
                }
            }

        }
    }
}
