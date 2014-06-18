package jp.ac.it_college.std.sms;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Authentication {
    private static final String GET_PASSWORD_SQL =
            "select count(*) from $tableName where id = ? and password = ?";

    public static boolean isAuthenticated(User user) {
        boolean flag = false;
        try {
            String sql;
            if (user.isStudent()) {
                sql = GET_PASSWORD_SQL.replace("$tableName", "student");
            } else {
                sql = GET_PASSWORD_SQL.replace("$tableName", "teacher");
            }
            PreparedStatement preparedStatement =
                    DatabaseHelper.getInstance().getPreparedStatement(sql);
            preparedStatement.setString(1, user.getId());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next() && resultSet.getInt(1) == 1) {
                flag = true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flag;
    }
}
