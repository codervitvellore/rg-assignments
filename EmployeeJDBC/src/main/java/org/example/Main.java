package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {

    public static void main(String[] args) {
        EmployeeDAO dao = new EmployeeDAO();

        try {
            // CREATE
            dao.add(new Employee(1, "Alice", "HR"));
            dao.add(new Employee(2, "Bob",   "IT"));
            dao.add(new Employee(3, "Cathy", "Finance"));

            // READ
            System.out.println("Employee 2 → " + dao.find(2));

            // UPDATE
            dao.update(new Employee(3, "Cathy Brown", "Accounting"));
            System.out.println("After update → " + dao.find(3));

            // DELETE
            dao.delete(1);

            // READ ALL
            System.out.println("Current employees:");
            dao.findAll().forEach(System.out::println);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
