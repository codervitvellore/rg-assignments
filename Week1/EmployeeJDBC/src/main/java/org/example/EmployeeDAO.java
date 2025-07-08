package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAO {

    /* ---------- CREATE ---------- */
    public void add(Employee e) throws Exception {
        String sql = "INSERT INTO employees (id, name, department) VALUES (?,?,?)";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, e.getId());
            ps.setString(2, e.getName());
            ps.setString(3, e.getDepartment());
            ps.executeUpdate();
            System.out.println("[CREATE] " + e);
        }
    }

    /* ---------- READ (one) ---------- */
    public Employee find(int id) throws Exception {
        String sql = "SELECT * FROM employees WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return new Employee(rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("department"));
                }
            }
        }
        return null;
    }

    /* ---------- READ (all) ---------- */
    public List<Employee> findAll() throws Exception {
        List<Employee> list = new ArrayList<>();
        String sql = "SELECT * FROM employees";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                list.add(new Employee(rs.getInt("id"),
                        rs.getString("name"),
                        rs.getString("department")));
            }
        }
        return list;
    }

    /* ---------- UPDATE ---------- */
    public boolean update(Employee e) throws Exception {
        String sql = "UPDATE employees SET name=?, department=? WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, e.getName());
            ps.setString(2, e.getDepartment());
            ps.setInt(3, e.getId());
            int rows = ps.executeUpdate();
            System.out.println("[UPDATE] rows=" + rows);
            return rows > 0;
        }
    }

    /* ---------- DELETE ---------- */
    public boolean delete(int id) throws Exception {
        String sql = "DELETE FROM employees WHERE id=?";
        try (Connection c = ConnectionFactory.getConnection();
             PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setInt(1, id);
            int rows = ps.executeUpdate();
            System.out.println("[DELETE] rows=" + rows);
            return rows > 0;
        }
    }
}
