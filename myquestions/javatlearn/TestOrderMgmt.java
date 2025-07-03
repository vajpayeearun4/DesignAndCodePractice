package myquestions.javatlearn;

public class TestOrderMgmt {

    public static void main(String[] args) {
        Customer obj1 = new Customer("Customer1", "last name");
        System.out.println(obj1.getFullName());
        System.out.println(obj1.getFullName("--"));

    }
}
