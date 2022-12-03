package saquapi.rest.dashboard;

import saquapi.database.ResponseDataRecord;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@Path("/dashboard/admin")
@Produces("application/json")
public class AdminDashboardResource {

    @Inject
    DashboardService dashboardService;

    @Path("/get-all-data")
    @GET
    public List<ResponseDataRecord> getAllRoomsWithData() {
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getAllRoomsWithData();
    }
}
