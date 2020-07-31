package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.exception.DatabaseOperationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class AirlineRepository extends BaseRepository<Airline> {

    private static final String FIND_AIRLINE = "select a from Airline a left join fetch a.flights where a.airlineId = :id";

    @Autowired
    public AirlineRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Airline find(int id) {
        Session session = null;
        Airline airline = null;

        try {
            session = sessionFactory.openSession();
            Query query = session.createQuery(FIND_AIRLINE);
            query.setParameter("id", id);
            List<Airline> airlineList = query.list();

            if (!CollectionUtils.isEmpty(airlineList)) {
                airline = airlineList.get(0);

            }
        } catch (Exception e) {
            throw new DatabaseOperationException("Error occurred when try to find airline", e);
        } finally {
            session.clear();
            session.close();
        }

        return airline;
    }
}
