package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Airline;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AirlineRepository extends BaseRepository {

    @Autowired
    public AirlineRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

    public int saveAirline(final Airline airline){
        Session session = null;
        try{
            session=sessionFactory.getCurrentSession();
            Transaction tx = session.beginTransaction();

            session.persist(airline);

            tx.commit();
        }
        catch (Exception e){
            System.err.println(e);
        }
        finally {
           session.close();
        }

        return airline.getAirlineId();
    }

    public Airline findAirline(int airlineId){
        Session session=null;
        try{
            session=sessionFactory.getCurrentSession();
            return (Airline)session.get(Airline.class,airlineId);
        }
        catch (Exception e){
            System.err.println(e);
            return null;
        }
        finally {
            session.close();
        }
    }
}
