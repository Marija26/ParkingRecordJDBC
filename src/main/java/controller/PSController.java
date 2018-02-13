package controller;


import dao.PSDao;
import model.ParkingRecord;
//import service.CheckTheTime;
import service.CheckTheTime;
import service.ParkingService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import static util.ActionOperations.*;
import static util.Constans.CHARGE;

public class PSController extends HttpServlet {
    private PSDao dao;
//    private CheckTheTime checkTheTime;
    private ParkingService parkingService;
    private static final String PS_LIST = "PSList.jsp";
    private static final String PS_EDIT = "PSEdit.jsp";


    public PSController() {
        this.dao = new PSDao();
        this.parkingService = new ParkingService();
//        this.checkTheTime = new CheckTheTime();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String forward = "";
        if (LIST.name().equalsIgnoreCase(action)) {
            int carId = Integer.parseInt(req.getParameter("carId"));
            forward = PS_LIST;
            req.setAttribute("carId", carId);
            req.setAttribute("PS", dao.listPS(carId));
        } else if (DELETE.name().equalsIgnoreCase(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            int carId = Integer.parseInt(req.getParameter("carId"));
            dao.deletePS(id);
            forward = PS_LIST;
            req.setAttribute("carId", carId);
            req.setAttribute("PS", dao.listPS(carId));
        } else if (EDIT.name().equalsIgnoreCase(action)) {
            forward = PS_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            int carId = Integer.parseInt(req.getParameter("carId"));
            ParkingRecord parkingRecord = dao.getPSById(id, carId);
            req.setAttribute("PS", parkingRecord);
            req.setAttribute("carId", carId);
        } else if (ADD.name().equalsIgnoreCase(action)) {
            int carId = Integer.parseInt(req.getParameter("carId"));
            forward = PS_EDIT;
            req.setAttribute("carId", carId);
        } else {
            throw new RuntimeException("Bad request");
        }

        req.setAttribute("charge", CHARGE);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }



    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ParkingRecord parkingRecord = new ParkingRecord();
        CheckTheTime checkTheTime = new CheckTheTime();
        int carId =Integer.parseInt(req.getParameter("carId"));
//        int charge =Integer.parseInt(req.getParameter("charge"));
        parkingRecord.setCarId(carId);
        try {
            Date timestamp1 = new SimpleDateFormat("yyyy.MM.dd HH:mm").parse(req.getParameter("time1"));
            parkingRecord.setTime1(timestamp1);
            Date timestamp2 = new SimpleDateFormat("yyyy.MM.dd HH:mm").parse(req.getParameter("time2"));
            parkingRecord.setTime2(timestamp2);
        } catch (ParseException e){
            e.printStackTrace();
        }

//        parkingRecord.setPrice(parkingService.evaluate(parkingRecord));
        parkingRecord.setPrice(checkTheTime.CheckTime(parkingRecord));

        String id = req.getParameter("id");

        if (id == null || id.isEmpty()) {
            dao.addPS(parkingRecord);
        } else {
            parkingRecord.setId(Integer.parseInt(id));
            dao.updatePS(parkingRecord);
        }
        req.setAttribute("charge", CHARGE);

        RequestDispatcher rd = req.getRequestDispatcher(PS_LIST);
        req.setAttribute("carId", carId );
        req.setAttribute("PS", dao.listPS(carId));
        rd.forward(req, resp);
    }
}
