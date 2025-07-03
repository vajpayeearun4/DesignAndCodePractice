package myquestions.javatlearn;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Test2 {
    public static void main(String[] args) {
        PermanentEmployee permanentEmployee = new PermanentEmployee();
        ContractEmployee contractEmployee = new ContractEmployee();
        List<Employee> employees = new ArrayList<Employee>();
        employees.add(permanentEmployee);
        employees.add(contractEmployee);
        printBonusOfAllEmp(employees);
    }

    static void printBonusOfAllEmp(List<Employee> employeeList) {
        System.out.println(employeeList.size());
    }
}

class Employee {
    String name;
    Date joiningDate;
    double bonus;

    double calculateBonus() {
        return bonus;
    }
}

class ContractEmployee extends Employee {

    double calculateBonus() {
        return bonus * .08;
    }
}

class PermanentEmployee extends Employee{
    double bonus;

    double calculateBonus() {
        return bonus * 1.5;
    }
}


