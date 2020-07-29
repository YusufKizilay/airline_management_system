package kizilay.yusuf.airline_management_system.repository;

import org.hibernate.SessionFactory;

public abstract class BaseRepository {

    protected SessionFactory sessionFactory;

    public BaseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
