package kizilay.yusuf.airline_management_system.entity;


import java.io.Serializable;

public abstract class BaseEntity<T> implements Serializable {

    public abstract int getId();

    public  abstract T toResource();
}
