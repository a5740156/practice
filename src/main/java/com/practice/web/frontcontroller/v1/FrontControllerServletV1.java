package com.practice.web.frontcontroller.v1;

import com.practice.web.frontcontroller.v1.controller.MemberFormControllerV1;
import com.practice.web.frontcontroller.v1.controller.MemberListControllerV1;
import com.practice.web.frontcontroller.v1.controller.MemberSaveControllerV1;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.swing.plaf.synth.ColorType;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "frontControllerServletV1", urlPatterns = "/front-controller/v1/*")
public class FrontControllerServletV1 extends HttpServlet {

    private Map<String, ControllerV1> controllerMap = new HashMap<>();

    public FrontControllerServletV1() {
        controllerMap.put("/front-controller/v1/members/new-form", new MemberFormControllerV1());
        controllerMap.put("/front-controller/v1/members/save", new MemberSaveControllerV1());
        controllerMap.put("/front-controller/v1/members", new MemberListControllerV1());

    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String requestURI = req.getRequestURI();
        System.out.println("requestURI = " + requestURI);

        ControllerV1 controllerV1 = controllerMap.get(requestURI);
        if (controllerV1 == null) {
            resp.sendError(HttpServletResponse.SC_NOT_FOUND);
        }
        controllerV1.process(req, resp);
    }
}
