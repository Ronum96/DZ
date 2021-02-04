public class Colleague {

    private String fullName;
    private String position;
    private String email;
    private String telephone;
    private int salary;
    private int age;

    public Colleague(String fullName, String position, String email, String telephone, int salary, int age){

        this.fullName = fullName;
        this.position = position;
        this.email = email;
        this.telephone = telephone;
        this.salary = salary;
        this.age = age;
     }


    public int getAge() {
        return age;
    }

    void Show() {
        System.out.println(fullName + " " + position + " " + email + " " + telephone + " " + salary + " " + age);
    }
}
