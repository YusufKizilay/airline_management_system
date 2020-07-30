package kizilay.yusuf.airline_management_system.repository;

import kizilay.yusuf.airline_management_system.entity.BaseEntity;
import kizilay.yusuf.airline_management_system.entity.Ticket;
import kizilay.yusuf.airline_management_system.exception.DatabaseOperationException;
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

            throw new DatabaseOperationException("Error occurred when try to save entity!", e);
        } finally {
            session.clear();
            session.close();
        }

        return t.getId();
    }

    public int update(T t){
        Session session = null;
        Transaction tx = null;
        try {
            session = sessionFactory.openSession();
            tx = session.beginTransaction();

            session.update(t);

            tx.commit();
        } catch (Exception e) {
            tx.rollback();

            throw new DatabaseOperationException("Error occured when try to update entity!",e);

        } finally {
            session.clear();
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
            throw new DatabaseOperationException("Error occurred when try to fetch entity!",e);
        } finally {
            session.clear();
            session.close();
        }
    }

}
