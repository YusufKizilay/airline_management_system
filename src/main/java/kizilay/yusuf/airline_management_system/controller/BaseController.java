package kizilay.yusuf.airline_management_system.controller;

import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/airline_management_system/")
public class BaseController {

    protected static final String AIRLINE_RESOURCE_PATH="/airline_management_system/airline/";

    protected static final String AIRPORT_RESOURCE_PATH="/airline_management_system/airport/";

    protected static final String ROUTE_RESOURCE_PATH="/airline_management_system/route/";

    protected static  final String FLIGHT_RESOURCE_PATH="/airline_management_system/airline/{airlineId}/flight";
}

