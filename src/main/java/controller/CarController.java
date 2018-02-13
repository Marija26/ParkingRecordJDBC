package controller;

import dao.CarDao;
import model.Car;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ActionOperations.*;


public class CarController extends HttpServlet {
    private CarDao dao;
    private static final String CAR_LIST = "carList.jsp";
    private static final String CAR_EDIT = "carEdit.jsp";

    public CarController() {
        this.dao = new CarDao();
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String action = req.getParameter("action");
        String forward = "";
        if (LIST.name().equalsIgnoreCase(action)) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            forward = CAR_LIST;
            req.setAttribute("cars", dao.listCar(userId));
            req.setAttribute("userId", userId);
        } else if (DELETE.name().equalsIgnoreCase(action)) {
            int id = Integer.parseInt(req.getParameter("id"));
            int userId = Integer.parseInt(req.getParameter("userId"));
            dao.deleteCar(id);
            forward = CAR_LIST;
            req.setAttribute("cars", dao.listCar(userId));
            req.setAttribute("userId", userId);
        } else if (EDIT.name().equalsIgnoreCase(action)) {
            forward = CAR_EDIT;
            int id = Integer.parseInt(req.getParameter("id"));
            int userId = Integer.parseInt(req.getParameter("userId"));
            Car car = dao.getCarById(id, userId);
            req.setAttribute("car", car);
            req.setAttribute("userId", userId);
        } else if (ADD.name().equalsIgnoreCase(action)) {
            int userId = Integer.parseInt(req.getParameter("userId"));
            forward = CAR_EDIT;
            req.setAttribute("userId", userId);
        } else {
            throw new RuntimeException("Bad request"); // ????????????????
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }


    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Car car = new Car();
        int userId = Integer.parseInt(req.getParameter("userId"));
        car.setUserId(userId);
        car.setModel(req.getParameter("model"));
        car.setColour(req.getParameter("colour"));

        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addCar(car);
        } else {
            car.setId(Integer.parseInt(id));
            dao.updateCar(car);
        }
        req.setAttribute("userId", userId);

        req.setAttribute("cars", dao.listCar(userId));
        RequestDispatcher rd = req.getRequestDispatcher(CAR_LIST);
        rd.forward(req, resp);

    }
}
