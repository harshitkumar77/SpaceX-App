package harshit.app.spacex.Utils.restService;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import harshit.app.spacex.model.CrewMember;

public interface CrewApi {
    @GET("/v4/crew")
    Call<List<CrewMember>> getCrewMembers();

}
