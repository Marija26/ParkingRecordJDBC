package dao;

import model.Car;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CarDao {
    private Connection connection;

    public CarDao() {
        connection = DBUtil.getConnection();
    }

    public void addCar(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cars1(userid, model, colour ) VALUES (?,?,?)");
            preparedStatement.setInt(1, car.getUserId());
            preparedStatement.setString(2, car.getModel());
            preparedStatement.setString(3, car.getColour());
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public void deleteCar(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cars1 WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updateCar(Car car) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cars1 SET model = ?, colour = ? WHERE id =?");
            preparedStatement.setString(1, car.getModel());
            preparedStatement.setString(2, car.getColour());
            preparedStatement.setInt(3, car.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Car> listCar(int userId) {
        List<Car> carList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars1 WHERE userid = ?");
            preparedStatement.setInt(1, userId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Car car = new Car();
                car.setId(resultSet.getInt("id"));
                car.setModel(resultSet.getString("model"));
                car.setColour(resultSet.getString("colour"));
                car.setUserId(resultSet.getInt("userId"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return carList;

    }



    public Car getCarById(int id, int userId) {
        Car car = new Car();
        car.setUserId(userId);
            try {
                PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM cars1 WHERE id = ?");
                preparedStatement.setInt(1, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    car.setId(resultSet.getInt("id"));
                    car.setUserId(resultSet.getInt("userId"));
                    car.setModel(resultSet.getString("model"));
                    car.setColour(resultSet.getString("colour"));

                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return car;
    }
}
