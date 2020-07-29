package kizilay.yusuf.airline_management_system.entity;


public abstract class BaseEntity<T> {

    public abstract int getId();

    public  abstract T toResource();
}
