package saquapi.rest.dashboard;

import saquapi.database.ResponseDataRecord;
import saquapi.rest.base.ResponseMessage;
import saquapi.services.base.InvocationProxy;
import saquapi.services.dashboard.DashboardService;
import saquapi.services.dashboard.DashboardServiceBean;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/dashboard/admin")
@Produces("application/json")
public class AdminDashboardResource {

    @Inject
    DashboardService dashboardService;

    @Path("/get-all-data")
    @GET
    public List<ResponseDataRecord> getAllRoomsWithData() {
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getAllRoomsWithData();
    }

    @Path("/get-room-data")
    @GET
    public List<ResponseDataRecord> getRoomData(@QueryParam("roomNumber") int roomNumber){
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getRoomData(roomNumber);
    }

    @Path("/get-image")
    @GET
    public byte[] getImage(@QueryParam("key") int key){
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return dashboardService.getImage(key);
    }
    
    @Path("/update-data")
    @PATCH
    public Response updateData(UpdateRequestMsg updateRequestMsg){
        dashboardService = (DashboardService) InvocationProxy.newInstance(new DashboardServiceBean());
        return Response.ok(new ResponseMessage(dashboardService.updateData(updateRequestMsg) ? "SUCCESS" : "FAILED")).build();
    }
}
