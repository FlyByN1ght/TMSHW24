import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/age/*")
public class CheckYearsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String pathInfo = req.getPathInfo();
        String[] pathParts = pathInfo.split("/");

        int age = -1;
        if (pathParts.length > 1) {
            age = Integer.parseInt(pathParts[1]);
        }

        boolean isAdult = age >= 18;

        PrintWriter writer = resp.getWriter();
        if (isAdult) {
            writer.print("Yes, adult");
        } else {
            writer.print("No!");
        }
        writer.close();
    }
}
