package jp.ac.it_college.std.sms.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ComboBox;
import jp.ac.it_college.std.sms.Main;
import jp.ac.it_college.std.sms.User;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class BaseController {
    protected Main main;
    protected User user;

    public void setMain(Main main) {
        this.main = main;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setComboBox(ComboBox<String> comboBox, PreparedStatement preparedStatement) {
        try {
            ResultSet resultSet = preparedStatement.executeQuery();
            ObservableList<String> observableList = FXCollections.observableArrayList();
            while (resultSet.next()) {
                observableList.add(resultSet.getString(1));
            }
            comboBox.getItems().addAll(observableList);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
