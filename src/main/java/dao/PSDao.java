package dao;



import model.ParkingRecord;
import util.DBUtil;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PSDao {
    private Connection connection;

    public PSDao() {
        connection = DBUtil.getConnection();
    }

    public void addPS(ParkingRecord parkingRecord) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO PS1(carid, price, time1, time2 ) VALUES (?,?,?,?)");
            preparedStatement.setInt(1, parkingRecord.getCarId());
            preparedStatement.setInt(2, parkingRecord.getPrice());
                preparedStatement.setTimestamp(3, new Timestamp(parkingRecord.getTime1().getTime()));
                preparedStatement.setTimestamp(4, new Timestamp(parkingRecord.getTime2().getTime()));
            preparedStatement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NullPointerException e){
            throw new RuntimeException("Insert the date");
        }
    }
    public void deletePS(int id) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM PS1 WHERE id = ?");
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void updatePS(ParkingRecord parkingRecord) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE PS1 SET price = ?, time1 = ?, time2 = ? WHERE id =?");
            preparedStatement.setInt(1, parkingRecord.getPrice());
            preparedStatement.setTimestamp(2, new Timestamp(parkingRecord.getTime1().getTime()));
            preparedStatement.setTimestamp(3, new Timestamp(parkingRecord.getTime2().getTime()));
            preparedStatement.setInt(4, parkingRecord.getId());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<ParkingRecord> listPS(int carId) {
        List<ParkingRecord> PSList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PS1 WHERE carid = ?");
            preparedStatement.setInt(1, carId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
               ParkingRecord parkingRecord = new ParkingRecord();
                parkingRecord.setId(resultSet.getInt("id"));
                parkingRecord.setPrice(resultSet.getInt("price"));
                parkingRecord.setTime1(resultSet.getTimestamp("time1"));
                parkingRecord.setTime2(resultSet.getTimestamp("time2"));
                parkingRecord.setCarId(resultSet.getInt("carId"));
                PSList.add(parkingRecord);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return PSList;

    }

    public ParkingRecord getPSById(int id, int carId) {
        ParkingRecord parkingRecord = new ParkingRecord();
        parkingRecord.setCarId(carId);

        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM PS1 WHERE id = ?");
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                parkingRecord.setId(resultSet.getInt("id"));
                parkingRecord.setCarId(resultSet.getInt("carId"));
                parkingRecord.setPrice(resultSet.getInt("price"));
                parkingRecord.setTime1(resultSet.getTimestamp("time1"));
                parkingRecord.setTime2(resultSet.getTimestamp("time2"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parkingRecord;
    }


}

