package kizilay.yusuf.airline_management_system.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import kizilay.yusuf.airline_management_system.entity.BaseEntity;

import java.util.Objects;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseResource<T> {

    public String resource;

    public BaseResource() {
    }

    public BaseResource(String resource, Object ... args) {
        this.resource = createResourcePath(resource, args);
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public abstract T toEntity();

    public String createResourcePath(String template, Object... args) {
        if(Objects.isNull(template)){
            return null;
        }

        return String.format(template, args);
    }
}
