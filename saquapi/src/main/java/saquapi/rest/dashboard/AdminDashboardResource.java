package saquapi.rest.dashboard;

import saquapi.database.ResponseDataRecord;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.*;
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

    @Path("/get-room-data")
    @GET
    public List<ResponseDataRecord> getRoomData(@QueryParam("roomNumber") int roomNumber){
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getRoomData(roomNumber);
    }

    @Path("/get-image")
    @GET
    public byte[] getImage(@QueryParam("key") int key){
        dashboardService = InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getImage(key);
    }
}
