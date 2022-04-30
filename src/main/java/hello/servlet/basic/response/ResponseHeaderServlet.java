package hello.servlet.basic.response;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "responseHeaderServlet", urlPatterns = "/response-header")
public class ResponseHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(HttpServletResponse.SC_OK);

        resp.setHeader("Content-Type", "text/plain;charset=utf-8");
        resp.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
        resp.setHeader("Pragma", "no-cache");
        resp.setHeader("my-header", "hi");

        // [header 편의 메서드]
        // resp.setHeader("Content-Type", "text/plain;charset=utf-8"); 와 같다.
//        resp.setContentType("text/plain");
//        resp.setCharacterEncoding("utf-8");
//        resp.setContentLength(4); //생략시 자동생

        // resp.setHeader("Set-Cookie", "myCookie=good; Max-Age=600") 와 같다.
        Cookie cookie = new Cookie("myCookie", "good");
        cookie.setMaxAge(600);

//        resp.setStatus(HttpServletResponse.SC_FOUND); //302
//        resp.setHeader("Location", "/basic/hello-form.html"); 와 같다.
        resp.sendRedirect("/basic/hello-form.html");

        resp.addCookie(cookie);

        resp.getWriter().write("ok");
    }
}
