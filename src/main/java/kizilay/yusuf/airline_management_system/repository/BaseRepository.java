package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.BaseEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.core.GenericTypeResolver;

public abstract class BaseRepository<T extends BaseEntity> {

    protected SessionFactory sessionFactory;

    private Class<?> classType;

    public BaseRepository(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
        this.classType = GenericTypeResolver.resolveTypeArgument(this.getClass(), BaseRepository.class);
    }

    public int save(T t) {
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.save(t);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            session.close();
        }

        return t.getId();
    }

    public T find(int id) {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            return (T) session.get(classType, id);
        } catch (Exception e) {
            System.err.println(e);
            return null;
        } finally {
            session.close();
        }
    }

}
