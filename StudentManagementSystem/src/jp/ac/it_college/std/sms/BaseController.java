package jp.ac.it_college.std.sms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class BaseController {
    protected Main main;
    private static final String GET_PASSWORD_SQL =
            "select password from $tableName where id = ?;";

    public void setMain(Main main) { this.main = main; }

    public boolean checkUser(String id) {
        boolean flag = false;
        if (id.substring(0,1).equals("t")) {
            flag = true;
        }
        return flag;
    }

    public boolean checkPassword(String id, String password, boolean teacher) {
        boolean flag = false;
        try {
            String sql;
            if (teacher) {
                sql = GET_PASSWORD_SQL.replace("$tableName", "teacher");
            } else {
                sql = GET_PASSWORD_SQL.replace("$tableName", "student");
            }
            PreparedStatement preparedStatement = DatabaseHelper.getInstance().getPreparedStatement(sql);
            preparedStatement.setString(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            String resultPassword = null;
            while (resultSet.next()) {
                resultPassword = resultSet.getString("password");
            }
            if (password.equals(resultPassword)) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
