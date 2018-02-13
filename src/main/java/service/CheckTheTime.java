package service;

import model.ParkingRecord;

import java.util.Date;

public class CheckTheTime {
    ParkingService parkingService = new ParkingService();


    public int CheckTime(ParkingRecord model) {
        Date time1 = model.getTime1();
        Date time2 = model.getTime2();
        if (time1 == null && time2 == null) {
            throw new IllegalArgumentException("The time is null");
        } else if (time2.getTime() - time1.getTime() < 0) {
            throw new RuntimeException("Insert valid date");
        } else {
            return this.parkingService.evaluate(model);
        }

    }
}

