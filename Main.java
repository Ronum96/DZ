import Models.Cat;
import Models.Plate;
import Services.CatService;
import Services.PlateService;

public class Main {
    public static void main(String[] args) {

        Plate plate1 = new Plate();
        PlateService plateService = new PlateService(plate1);
        System.out.println("Hello! In plate " + plate1.getFoodCount() + " units of food.");
        plateService.feederFiller(plate1, 500);



        Cat cats [] = new Cat[]{
                new Cat("Barsik"),
                new Cat("Volodin"),
                new Cat("Se4in"),
                new Cat("Morsik")
        };


        CatService catService0 = new CatService(cats[0], plateService);
        CatService catService1 = new CatService(cats[1], plateService);
        CatService catService2 = new CatService(cats[2], plateService);
        CatService catService3 = new CatService(cats[3], plateService);

        catService0.eater(-50);
        catService0.eater(0);
        catService1.eater(150);
        catService2.eater(200);
        catService3.eater(500);
        catService0.eater(50);
        catService1.eater(150);




    }
}
