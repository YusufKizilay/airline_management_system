package kizilay.yusuf.airline_management_system.util;

public interface ResourcePathHelper {

    default String createPath(String template, Object ...args ){
        return String.format(template,args);
    }
}
