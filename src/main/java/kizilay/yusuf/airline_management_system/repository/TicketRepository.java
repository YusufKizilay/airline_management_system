package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TicketRepository extends BaseRepository<Ticket> {

    @Autowired
    public TicketRepository(SessionFactory sessionFactory) {
        super(sessionFactory);
    }

}
