package servlet;

//import com.company.db.db_utils.UserDataBase;
//import com.company.db.repository.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;


@WebServlet(name = "login", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
    }

    public static boolean checkParameters(String[] parameters, Map<String, String[]> parameterMap) {
        for (String parameter : parameters) {
            if (!parameterMap.containsKey(parameter)) {
                return false;
            }
        }
        return true;
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String[] parameters = {"email", "password"};
        boolean checkResult = checkParameters(parameters, request.getParameterMap());

        if (!checkResult) {
            System.out.println("Ашипка 1 - не все заполнил");
            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

        } else {
            String email = request.getParameter("email");
            String password = request.getParameter("password");
            User user = null;
            try {
                user = UserDataBase.getINSTANCE().login(email, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
            if (user != null) {
                HttpSession session = request.getSession();
                System.out.println("Успешный вход юзера с id = "+ user.getID());
                session.setAttribute("id", user.getID());

//                String id = String.valueOf(user.getID());
//                request.setAttribute("id", Integer.parseInt(id));
                getServletContext().getRequestDispatcher("/profile.jsp").forward(request, response);
            } else {
                System.out.println("Ашипка 2 - накосячил в логине или пароле");
                getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);
            }
        }
    }
}
