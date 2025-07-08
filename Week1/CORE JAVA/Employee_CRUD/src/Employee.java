public class Employee {
    private final int id;
    private String name;
    private String department;

    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    /* getters & setters */
    public int getId()                 { return id; }
    public String getName()            { return name; }
    public String getDepartment()      { return department; }
    public void setName(String name)   { this.name = name; }
    public void setDepartment(String d){ this.department = d; }

    @Override
    public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s'}",
                id, name, department);
    }
}