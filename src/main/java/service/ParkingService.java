package service;

import model.ParkingRecord;

import java.util.Date;

import static util.Constans.CHARGE;

public class ParkingService {

    public int evaluate(ParkingRecord model) {
        Date time1 = model.getTime1();
        Date time2 = model.getTime2();
        if (time1!=null && time2!=null) {
            long longTime = time2.getTime() - time1.getTime();
            int time = (int) (longTime / (1000 * 60 * 60));
            return time * CHARGE;
        }else {
            throw new IllegalArgumentException("Time is null");
        }
    }
}

