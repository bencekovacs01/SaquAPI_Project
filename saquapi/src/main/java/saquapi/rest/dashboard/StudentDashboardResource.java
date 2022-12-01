package saquapi.rest.dashboard;

import saquapi.rest.login.LoginMsg;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Path("/dashboard/user")
public class StudentDashboardResource {

    @Inject
    DashboardService dashboardService;

    @Path("/change-password")
    @PATCH
    @Produces("application/json")
    public void changePassword(LoginMsg loginMsg) {
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        dashboardService.changePassword(loginMsg);
    }

}
