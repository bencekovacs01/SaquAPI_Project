package saquapi.rest.base;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CORSFilter implements ContainerResponseFilter {
    @Override
    public void filter(final ContainerRequestContext requestContext, final ContainerResponseContext responseContext) {
        responseContext.getHeaders().putSingle("Access-Control-Allow-Origin", "http://localhost:4200");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, PATCH");
        responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", "Content-Type, Authorization, X-Requested-With");
        String reqHeader = requestContext.getHeaderString("Access-Control-Request-Headers");
        if (reqHeader != null && !reqHeader.equals("")) {
            responseContext.getHeaders().putSingle("Access-Control-Allow-Headers", reqHeader);
        }
    }
}