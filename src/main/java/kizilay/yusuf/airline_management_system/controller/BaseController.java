package kizilay.yusuf.airline_management_system.controller;

import kizilay.yusuf.airline_management_system.util.ResourcePathHelper;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/airline_management_system/")
public class BaseController implements ResourcePathHelper {

    protected static final String AIRLINE_RESOURCE_PATH="/airline_management_system/airline/%d";

    protected static final String AIRPORT_RESOURCE_PATH="/airline_management_system/airport/%d";

    protected static final String ROUTE_RESOURCE_PATH="/airline_management_system/route/%d";

    protected static  final String FLIGHT_RESOURCE_PATH="/airline_management_system/airline/%d/flight/%d";

    protected static final String TICKET_RESOURCE_PATH="/airline_management_system/airline/%d/flight/%d/ticket/%d";
}

