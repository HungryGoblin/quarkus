import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("/bmi")
public class BodyMassIndexController {

    @Inject
    BodyMassIndexModel bmim;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Никакого бодипозитва!";
    }

    // http://localhost:8080/bmi/calc?height=1.8&weight=100
    @GET
    @Path("/calc")
    @Produces(MediaType.TEXT_PLAIN)
    public Double calcIndex(@QueryParam("height") Double height, @QueryParam("weight") Double weight) {
        bmim.initBodyMassIndexModel(weight, height);
        return bmim.getIndex();
    }

    // http://localhost:8080/bmi/recommendation?height=1.8&weight=100
    @GET
    @Path("/recommendation")
    @Produces(MediaType.TEXT_PLAIN)
    public String getRecommendation(@QueryParam("height") Double height, @QueryParam("weight") Double weight) {
        bmim.initBodyMassIndexModel(weight, height);
        return String.format("ИМТ: %.2f (%s)",bmim.getIndex(), bmim.getRecommendation());
    }
}