package controller;

import dao.UserDao;
import model.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static util.ActionOperations.*;

public class UserController extends HttpServlet {
    private UserDao dao;
    private static final String USER_LIST = "userList.jsp";
    private static final String USER_EDIT = "userEdit.jsp";

    public UserController() {
        this.dao = new UserDao();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        String forward = "";
        if (LIST.name().equalsIgnoreCase(action)) {
            forward = USER_LIST;
            req.setAttribute("users", dao.listUser());
        } else if (DELETE.name().equalsIgnoreCase(action)) {
            int userId = Integer.parseInt(req.getParameter("id"));
            dao.deleteUser(userId);
            forward = USER_LIST;
            req.setAttribute("users", dao.listUser());
        } else if (EDIT.name().equalsIgnoreCase(action)) {
            int userId = Integer.parseInt(req.getParameter("id"));
            User user = dao.getUserById(userId);
            req.setAttribute("user", user);
            forward = USER_EDIT;
        } else if (ADD.name().equalsIgnoreCase(action)) {
            forward = USER_EDIT;
        } else {
            throw new RuntimeException("Bad request");
        }

        RequestDispatcher requestDispatcher = req.getRequestDispatcher(forward);
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user = new User();
        user.setFirstName(req.getParameter("firstName"));
        user.setLastName(req.getParameter("lastName"));
        String id = req.getParameter("id");
        if (id == null || id.isEmpty()) {
            dao.addUser(user);
        } else {
            user.setId(Integer.parseInt(id));
            dao.updateUser(user);
        }
        RequestDispatcher rd = req.getRequestDispatcher(USER_LIST);
        req.setAttribute("users", dao.listUser());
        rd.forward(req, resp);
    }


}



