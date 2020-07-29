package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Airline;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirlineRepository extends BaseRepository<Airline> {

    @Autowired
    public AirlineRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
