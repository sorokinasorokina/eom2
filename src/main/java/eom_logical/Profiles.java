package eom_logical;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Profiles {
    @JsonProperty("id")
    int id;
    @JsonProperty("type")
    String  type;

    public int getId() {
        return id;
    }

    public String getType() {
        return type;
    }
}
