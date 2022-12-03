package saquapi.rest.dashboard;

import saquapi.database.RequestResponseDataRecord;
import saquapi.rest.base.ResponseMessage;
import saquapi.rest.login.LoginMsg;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.PATCH;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

@Path("/dashboard/user")
@Produces("application/json")
public class StudentDashboardResource {

    @Inject
    DashboardService dashboardService;

    @Path("/change-password")
    @PATCH
    public void changePassword(LoginMsg loginMsg) {
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        dashboardService.changePassword(loginMsg);
    }

    @Path("/save")
    @POST
    public Response save(RequestResponseDataRecord requestDataRecord) {
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        return Response.ok(new ResponseMessage(dashboardService.insertData(requestDataRecord) ? "SUCCESS" : "FAILED")).build();
    }

}
