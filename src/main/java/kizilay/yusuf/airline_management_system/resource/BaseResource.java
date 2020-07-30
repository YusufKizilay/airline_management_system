package kizilay.yusuf.airline_management_system.resource;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public abstract class BaseResource<T> {

    public abstract T toEntity();
}
