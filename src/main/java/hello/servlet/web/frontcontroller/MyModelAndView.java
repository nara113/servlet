package hello.servlet.web.frontcontroller;

import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Getter @Setter
public class MyModelAndView {
    private String viewPath;

    private Map<String, Object> model = new HashMap<>();

    public MyModelAndView(String viewPath) {
        this.viewPath = viewPath;
    }
}
