package pe.edu.upc.hello.platform.generic.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record GreetDeveloperRequest(String firstName, String lastName) {
    @JsonCreator
    public GreetDeveloperRequest(@JsonProperty("firstName") String firstName,
                                 @JsonProperty("lastName") String lastName) {
        this.firstName = firstName != null ? firstName : "";
        this.lastName = lastName != null ? lastName : "";
    }
}
