package pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers;

import org.apache.commons.lang3.ObjectUtils;
import pe.edu.upc.hello.platform.generic.domain.model.entity.Course;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.CourseResponse;

public class CourseHttpAssembler {
    public static CourseResponse toResourceFromEntity(Course course) {
        if (isDeveloperNullOrEmptyNamed(course)) {
            return new CourseResponse("Welcome Anonymous Spring Boot Developer :D");
        }
        return new CourseResponse(
                course.getId(),
                course.getCourseName(),
                course.getCourseHours(),
                "Congrats! You are now enrolled in " + course.getCourseName() + ". And its duration is " + course.getCourseHours()
        );
    }
    private static boolean isDeveloperNullOrEmptyNamed(Course course) {
        return ObjectUtils.isEmpty(course);
    }
}