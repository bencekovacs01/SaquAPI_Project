package com.base.log;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class WrapperEx extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res)throws ServletException, IOException{
        ReqWrapper wrap = (ReqWrapper)req;
        String details = wrap.GetDetails();

        try(PrintWriter out = res.getWriter()){
            res.setContentType("text/html");
            out.println("<html><head></head><body><h1>");
            out.println(details);
            out.println("</h1></body></html");
        }
    }
}