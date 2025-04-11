package pe.edu.upc.hello.platform.generic.interfaces.rest.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.upc.hello.platform.generic.domain.model.entity.Course;
import pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers.CourseAssembler;
import pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers.CourseHttpAssembler;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.CourseRequest;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.CourseResponse;


@RestController
@RequestMapping("/courses")
public class CourseController {
    @GetMapping
    public ResponseEntity<CourseResponse> getCourse(
            @RequestParam( required = false ) String name,
            @RequestParam( required = false ) Double hours
    ) {
        Course course = ( name != null && hours != null) ?
                Course.builder().name(name).hours(hours).build()
                : null;
        CourseResponse response = CourseHttpAssembler.toResourceFromEntity(course);
        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<CourseResponse> postCourse(
            @RequestBody CourseRequest courseRequest
    ){
        Course course = CourseAssembler.toEntityFromRequest(courseRequest);
        CourseResponse response = CourseHttpAssembler.toResourceFromEntity(course);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }
}
