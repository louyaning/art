package com.team.art.util;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

public class Remind {
    public static void remindUtil(HttpServletResponse response, String message) throws IOException {
        response.setContentType("text/html;charset=utf-8");
        response.getWriter().write("<script>alert(" + message + ");</script>");
        response.getWriter().flush();
    }
}
