package Models;

public class Cat {

    private  boolean isHungry = true;
    private  String name;

    public Cat(String name){
        this.name = name;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public String getName() {
        return name;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }

    public void setName(String name) {
        this.name = name;
    }
}
