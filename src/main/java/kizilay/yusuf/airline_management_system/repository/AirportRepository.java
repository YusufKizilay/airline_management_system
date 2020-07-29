package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Airport;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirportRepository extends BaseRepository<Airport> {

    @Autowired
    public AirportRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }
}
