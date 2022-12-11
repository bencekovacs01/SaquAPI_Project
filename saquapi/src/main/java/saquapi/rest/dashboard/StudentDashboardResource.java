package saquapi.rest.dashboard;

import saquapi.database.RequestDataRecord;
import saquapi.rest.base.ResponseMessage;
import saquapi.rest.login.LoginMsg;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.io.FileInputStream;

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
    public Response save(@FormParam("roomNumber") int roomNumber, @FormParam("coldWater") long coldWater, @FormParam("hotWater") long hotWater, @FormParam("fileInputStream") FileInputStream fileInputStream) {
        RequestDataRecord requestDataRecord = new RequestDataRecord(roomNumber,coldWater,hotWater,fileInputStream);
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return Response.ok(new ResponseMessage(dashboardService.insertData(requestDataRecord) ? "SUCCESS" : "FAILED")).build();
    }

}
