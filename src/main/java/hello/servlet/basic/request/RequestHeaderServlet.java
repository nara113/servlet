package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(name = "requestHeaderServlet", urlPatterns = "/request-header")
public class RequestHeaderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        getStartLine(req);
        getHeaders(req);
        getHeaderUtil(req);
        printETC(req);
    }

    private void printETC(HttpServletRequest req) {
        System.out.println("==== 기타조회 start ====");
        System.out.println("[Remote 정보]");  // 요청 정보
        System.out.println("req.getRemoteHost() = " + req.getRemoteHost()); // 0:0:0:0:0:0:0:1
        System.out.println("req.getRemoteAddr() = " + req.getRemoteAddr()); // 0:0:0:0:0:0:0:1
        System.out.println("req.getRemotePort() = " + req.getRemotePort()); // 53579
        System.out.println("[Local 정보]");   // 서버 정
        System.out.println("req.getLocalName() = " + req.getLocalName()); // localhost
        System.out.println("req.getLocalAddr() = " + req.getLocalAddr()); // 0:0:0:0:0:0:0:1
        System.out.println("req.getLocalPort() = " + req.getLocalPort()); // 8080
        System.out.println("==== 기타조회 end ====");
    }

    private void getHeaderUtil(HttpServletRequest req) {
        System.out.println("==== header 편의 조회 start ====");
        System.out.println("[Host 편의 조회]");
        System.out.println("req.getServerName() = " + req.getServerName());
        System.out.println("req.getServerPort() = " + req.getServerPort());
        System.out.println("[Accept 편의 조회]");
        req.getLocales().asIterator()
                .forEachRemaining(locale -> System.out.println("locale=" + locale));
        System.out.println("req.getLocale() = " + req.getLocale());
        System.out.println("[Cookies 편의 조회]");
        if (req.getCookies() != null) {
            for (Cookie cookie : req.getCookies()) {
                System.out.println(cookie.getName() + " : " + cookie.getValue());
            }
        }
        System.out.println("[Content 편의 조회]");
        System.out.println("req.getContentType() = " + req.getContentType());
        System.out.println("req.getContentLength() = " + req.getContentLength());
        System.out.println("req.getCharacterEncoding() = " + req.getCharacterEncoding());
        System.out.println("==== header 편의 조회 end ====");
    }

    private void getHeaders(HttpServletRequest req) {
        System.out.println("==== header start ====");
        Enumeration<String> headerNames = req.getHeaderNames();

//        while (headerNames.hasMoreElements()) {
//            String headerName = headerNames.nextElement();
//            System.out.println(headerName + " : " + req.getHeader(headerName));
//        }

        headerNames.asIterator()
                .forEachRemaining(headerName -> System.out.println(headerName + " : " + req.getHeader(headerName)));

        System.out.println("==== header end ====");
    }

    private void getStartLine(HttpServletRequest req) {
        System.out.println("===== request line start ====");
        System.out.println("req.getMethod() = " + req.getMethod()); // GET
        System.out.println("req.getProtocol() = " + req.getProtocol()); // http/1.1
        System.out.println("req.getScheme() = " + req.getScheme()); // http
        System.out.println("req.getRequestURL() = " + req.getRequestURL()); // http://localhost:8080/request-header
        System.out.println("req.getRequestURI() = " + req.getRequestURI()); // /request-header
        System.out.println("req.getQueryString() = " + req.getQueryString()); // null
        System.out.println("req.isSecure() = " + req.isSecure());   //https 사용 여부
        System.out.println("==== request line end ====");
    }
}
