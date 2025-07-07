package org.example;

public class Employee {

    private int id;
    private String name;
    private String department;

    public Employee() { }
    public Employee(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public int getId()               { return id; }
    public String getName()          { return name; }
    public String getDepartment()    { return department; }

    public void setId(int id)                 { this.id = id; }
    public void setName(String name)          { this.name = name; }
    public void setDepartment(String dept)    { this.department = dept; }

    @Override public String toString() {
        return String.format("Employee{id=%d, name='%s', dept='%s'}",
                id, name, department);
    }
}
