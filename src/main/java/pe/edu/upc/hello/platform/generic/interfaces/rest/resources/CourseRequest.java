package pe.edu.upc.hello.platform.generic.interfaces.rest.resources;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseRequest(String name, Double hours) {
    @JsonCreator
    public CourseRequest(@JsonProperty("name") String name,
                                 @JsonProperty("hours") Double hours) {
        this.name = name != null ? name : "";
        this.hours = hours != null ? hours : 0;
    }
}