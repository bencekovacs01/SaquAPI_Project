package com.base.log;

import javax.servlet.http.*;

public class ReqWrapper extends HttpServletRequestWrapper {

    HttpServletRequest request;

    ReqWrapper(HttpServletRequest request){
        super(request);
        this.request = request;
    }

    public String GetDetails(){
        StringBuilder details = new StringBuilder("RemoteHost :");
        details.append(request.getRemoteHost());
        details.append("<br />Remote Address :").append(request.getRemoteAddr());
        details.append("<br />Remote User :").append(request.getRemoteUser());
        details.append("<br />Remote Port :").append(request.getRemotePort());
        details.append("<br />Server Name:").append(request.getServerName());
        details.append("<br />port :").append(request.getServerPort());

        return details.toString();
    }
}