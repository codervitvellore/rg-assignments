import java.util.ArrayList;
import java.util.List;

/* ---------- CRUD Service ---------- */
public class EmployeeCRUD {

    private final List<Employee> employees = new ArrayList<>();

    /* CREATE */
    public void addEmployee(Employee e) {
        employees.add(e);
    }

    /* READ (by id) */
    public Employee getEmployee(int id) {
        return employees.stream()
                .filter(e -> e.getId() == id)
                .findFirst()
                .orElse(null);
    }

    /* UPDATE (name & dept) */
    public boolean updateEmployee(int id, String newName, String newDept) {
        Employee e = getEmployee(id);
        if (e == null) return false;
        e.setName(newName);
        e.setDepartment(newDept);
        return true;
    }

    /* DELETE */
    public boolean deleteEmployee(int id) {
        return employees.removeIf(e -> e.getId() == id);
    }

    /* READ-ALL (utility) */
    public List<Employee> getAll() {
        return new ArrayList<>(employees);   // defensive copy
    }

    /* ---------- Demo ---------- */
    public static void main(String[] args) {
        EmployeeCRUD crud = new EmployeeCRUD();

        // Create
        crud.addEmployee(new Employee(1, "Alice", "HR"));
        crud.addEmployee(new Employee(2, "Bob",   "IT"));
        crud.addEmployee(new Employee(3, "Cathy", "Finance"));

        // Read
        System.out.println("Employee 2 -> " + crud.getEmployee(2));

        // Update
        crud.updateEmployee(3, "Cathy Brown", "Accounting");
        System.out.println("After update -> " + crud.getEmployee(3));

        // Delete
        System.out.println("Before delete -> " + crud.getEmployee(1));
        crud.deleteEmployee(1);
        System.out.println("After delete -> " + crud.getEmployee(1));

        // List all
        System.out.println("Current employees:");
        crud.getAll().forEach(System.out::println);
    }
}
