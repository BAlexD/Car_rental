package servlet;

//import com.company.db.db_utils.UserDataBase;
//import com.company.db.repository.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "register", urlPatterns = {"/register"})
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
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

        String[] parameters = {"username", "email", "password"};
        boolean checkResult = checkParameters(parameters, request.getParameterMap());

        if (!checkResult) {
            System.out.println("Ашипка 1 - не все заполнил");
            getServletContext().getRequestDispatcher("/register.jsp").forward(request, response);
        } else {

            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String password = request.getParameter("password");

            request.getParameter("username");
            request.getParameter("email");
            request.getParameter("password");

            System.out.println("принял реквесты и погнал");
            UserDataBase.getINSTANCE().add(new User(0, email, username,  password));

            System.out.println("проверил инстанс");
            //TODO проверка на успешную регистрацию
            response.sendRedirect(getServletContext().getContextPath() + "/login.jsp");
//            getServletContext().getRequestDispatcher("/login.jsp").forward(request, response);

//            boolean registerResult = Helper.userRepository().add(newUser);
//            if (registerResult) {
//                response.sendRedirect("login");
//            } else {
//                request.setAttribute("message", "Something went wrong.");
//                request.setAttribute("viewFile", "register.jsp");
//                request.setAttribute("pageTitle", "Register");
//                Helper.view(request, response);
//            }
        }

    }

}
