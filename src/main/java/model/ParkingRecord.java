package model;


import java.util.Date;

public class ParkingRecord {
    private int id;
    private int carId;
    private int price;
    private Date time1; // TODO: 23.12.2017
    private Date time2; // TODO: 23.12.2017

    public ParkingRecord() {
    }

    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getTime1() {
        return time1;
    }

    public void setTime1(Date time) {
        this.time1 = time;
    }

    public Date getTime2() {
        return time2;
    }

    public void setTime2(Date time2) {
        this.time2 = time2;
    }

}
