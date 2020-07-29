package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Flight;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class FlightRepository extends BaseRepository<Flight> {

    @Autowired
    public FlightRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
