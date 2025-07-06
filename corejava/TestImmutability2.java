package corejava;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TestImmutability2 {
    public static void main(String[] args) {
        Employee arun = new Employee("arun", 100, "eng", 100, null);
        Employee sarika = new Employee("sarika", 100, "it", 500, new Address("Barra", "Kanpur"));
        Employee jivin = new Employee("jivin", 100, "finance", 50, new Address("Sobha", "Bangalore"));

        System.out.println("Sarika City= " + sarika.getAddress().city);
        System.out.println("Sarika City= " + sarika.getAddress().city);

    }
}

final class Employee {
    final String id;
    final double salary;
    final String department;
    final int totalDays;
    final Address address;

    public Employee(String id, double salary, String department, int totalDays, Address address) {
        this.id = id;
        this.salary = salary;
        this.department = department;
        this.totalDays = totalDays;
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(id, employee.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}

final class Address{
   final String location;
   final String city;

    public Address(String location, String city) {
        this.location = location;
        this.city = city;
    }
}
