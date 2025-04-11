package pe.edu.upc.hello.platform.generic.interfaces.rest.assemblers;

import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import pe.edu.upc.hello.platform.generic.domain.model.entity.Course;
import pe.edu.upc.hello.platform.generic.interfaces.rest.resources.CourseRequest;

public class CourseAssembler {
    public static Course toEntityFromRequest(CourseRequest request) {
        if(ObjectUtils.isEmpty(request) || StringUtils.isAnyBlank(request.name())){
            return null;
        }
        return Course.builder()
                .name(request.name())
                .hours(request.hours())
                .build();
    }
}
