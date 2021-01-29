public class Main {


    public static void main(String[] args) {

        Colleague[] collArray = new Colleague[5];

        collArray[0] = new Colleague("Ivanov Ivan", "Driver", "ivan@mail.ru", "+7123456789", 25000, 35);
        collArray[1] = new Colleague("Ivanov Ivan1", "Driver1", "ivan1@mail.ru", "+7213456789", 30000, 39);
        collArray[2] = new Colleague("Ivanov Ivan2", "Driver2", "ivan2@mail.ru", "+7313456789", 35000, 45);
        collArray[3] = new Colleague("Ivanov Ivan3", "Driver3", "ivan3@mail.ru", "+7413456789", 20000, 49);
        collArray[4] = new Colleague("Ivanov Ivan4", "Driver4", "ivan4@mail.ru", "+7513456789", 40000, 27);

        for (Colleague item : collArray) {
            if (item.getAge() > 40) item.Show();


        }


    }

}