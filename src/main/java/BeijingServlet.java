import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

@WebServlet("/beijing")
public class BeijingServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String cityName = "Asia/Shanghai";
        ZoneId zoneId = ZoneId.of(cityName);

        LocalDateTime localDateTime = LocalDateTime.now(zoneId);

        String timeBeijing = localDateTime.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

        PrintWriter writer = resp.getWriter();
        writer.print("Current time in Asia/Shanghai : " + timeBeijing);
        writer.close();
    }
}