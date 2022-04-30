package hello.servlet.basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "helloServlet", urlPatterns = "/hello")
public class HelloServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloServlet.service"); // 단축키 : soutm
        System.out.println("req = " + req); // 단축키 : soutv
        System.out.println("resp = " + resp);

        String name = req.getParameter("name");
        System.out.println("name = " + name);

        resp.setContentType("text/plain");
        resp.setCharacterEncoding("UTF-8"); // 한글 가능
        resp.getWriter().println("hello " + name);
    }
}
