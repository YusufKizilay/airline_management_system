package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Airline;
import kizilay.yusuf.airline_management_system.exception.DatabaseOperationException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;

@Repository
public class AirlineRepository extends BaseRepository<Airline> {

    private static final String FIND_AIRLINE="select a from Airline a left join fetch a.flights";

    @Autowired
    public AirlineRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    @Override
    public Airline find(int id) {
        Session session=null;
        Airline airline=null;

        try{
            session= sessionFactory.openSession();
            Query query= session.createQuery(FIND_AIRLINE);
            List<Airline> airlineList = query.list();

            if(Objects.nonNull(airlineList)){
                airline= airlineList.get(0);

            }
        }
        catch (Exception e){
            throw new DatabaseOperationException("Error occured when try to find airline",e);
        }
        finally {
            session.clear();
            session.close();
        }

        return airline;
    }
}
