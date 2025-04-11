package pe.edu.upc.hello.platform.generic.interfaces.rest.resources;

import java.util.UUID;

public record CourseResponse(UUID id, String name, Double hours, String message) {
    public CourseResponse(String message) {
        this(null, null,null, message);
    }
}
