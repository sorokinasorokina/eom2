package eom_logical;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthResponse {
    @JsonProperty("authentication_token")
    String authentication_token;
    @JsonProperty("profiles")
    List <Profiles> profiles;

    public String getAuthentication_token() {
        return authentication_token;
    }

    public List<Profiles> getProfiles() {
        return profiles;
    }
}
