package kizilay.yusuf.airline_management_system.service;

import kizilay.yusuf.airline_management_system.entity.Route;
import kizilay.yusuf.airline_management_system.repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {

    private RouteRepository routeRepository;

    @Autowired
    public RouteService(RouteRepository routeRepository) {
        this.routeRepository = routeRepository;
    }

    public int saveRoute(final Route route){
        return  routeRepository.save(route);
    }
    public Route findRoute(int id){
        return  routeRepository.find(id);
    }
}
