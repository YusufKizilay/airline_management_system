package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Route;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RouteRepository extends BaseRepository<Route> {

    @Autowired
    public RouteRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
