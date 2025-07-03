package myquestions.javatlearn;

public class Customer {
    private int age;
    private String firstName;
    private String lastName;
    private String birthMonth;

    public Customer() {
    }

    public Customer(String firstName, int age) {
        this.firstName = firstName;
        this.age = age;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public int getAge() {
        return age;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public String getFullName(String separator) {
        return this.firstName + separator + this.lastName;
    }
}
