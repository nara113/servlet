package hello.servlet.web.frontcontroller.v3.controller;

import hello.servlet.web.frontcontroller.MyModelAndView;
import hello.servlet.web.frontcontroller.v3.ControllerV3;

import java.util.Map;

public class MemberFormControllerV3 implements ControllerV3 {
    @Override
    public MyModelAndView process(Map<String, String> paramMap) {
        return new MyModelAndView("new-form");
    }
}
