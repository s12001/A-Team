package jp.ac.it_college.std.sms;

public class User {
    private String id;
    private String password;
    private boolean student;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (!id.substring(0,1).equals("t")) {
            setStudent(true);
        } else {
            setStudent(false);
        }
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isStudent() {
        return student;
    }

    public void setStudent(boolean student) {
        this.student = student;
    }
}
