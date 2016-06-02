package jettyjerseytutorial;
//  this will be the file where we are going to write our Rest-methods using jersey

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by RaynorM on 6/2/2016.
 */

@Path("home")

public class Resource {

    @GET
   @Path("param")
    @Produces(MediaType.TEXT_PLAIN)
    public String paramMethod(@QueryParam("name") String name){
        return "Hello, " + name;

    }
    @GET
    @Path("hello")
    @Produces(MediaType.TEXT_PLAIN)
    public String helloWorld(){
        return "Hello, world!";
    }


    @POST
    @Path("post")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_HTML)
    public String postMethod(@FormParam("name") String name) {
        return "<h2> Hello, " + name + "</h2>";
    }
    }



