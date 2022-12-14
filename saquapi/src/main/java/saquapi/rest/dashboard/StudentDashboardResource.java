package saquapi.rest.dashboard;

import saquapi.database.RequestDataRecord;
import saquapi.rest.base.ResponseMessage;
import saquapi.rest.login.LoginMsg;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.IOException;

@Path("/dashboard/user")
@Produces("application/json")
public class StudentDashboardResource {

    @Inject
    DashboardService dashboardService;

    @Path("/change-password")
    @PATCH
    public Response changePassword(LoginMsg loginMsg) {
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return Response.ok(new ResponseMessage(dashboardService.changePassword(loginMsg) ? "SUCCESS" : "FAILED")).build();
    }

    @Path("/save")
    @POST
    public Response save(RequestDataRecord requestDataRecord) {
        requestDataRecord.setBase64StringImage(requestDataRecord.getBase64StringImage().substring(23));
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return Response.ok(new ResponseMessage(dashboardService.insertData(requestDataRecord) ? "SUCCESS" : "FAILED")).build();
    }

}
