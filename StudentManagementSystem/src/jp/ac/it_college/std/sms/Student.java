package jp.ac.it_college.std.sms;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Student {
    private StringProperty id;
    private StringProperty name;
    private IntegerProperty schoolGrade;
    private StringProperty department;

    public Student(String id, String name, int schoolGrade, String department) {
        this.id = new SimpleStringProperty(id);
        this.name = new SimpleStringProperty(name);
        this.schoolGrade = new SimpleIntegerProperty(schoolGrade);
        this.department = new SimpleStringProperty(department);
    }

    public String getId() {
        return id.get();
    }

    public StringProperty idProperty() {
        return id;
    }

    public void setId(String id) {
        this.id.set(id);
    }

    public String getName() {
        return name.get();
    }

    public StringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public int getSchoolGrade() {
        return schoolGrade.get();
    }

    public IntegerProperty schoolGradeProperty() {
        return schoolGrade;
    }

    public void setSchoolGrade(int schoolGrade) {
        this.schoolGrade.set(schoolGrade);
    }

    public String getDepartment() {
        return department.get();
    }

    public StringProperty departmentProperty() {
        return department;
    }

    public void setDepartment(String department) {
        this.department.set(department);
    }
}
