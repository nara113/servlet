package hello.servlet.web.frontcontroller.v3;

import hello.servlet.web.frontcontroller.MyModelAndView;

import java.util.Map;

public interface ControllerV3 {
    MyModelAndView process(Map<String, String> paramMap);
}
