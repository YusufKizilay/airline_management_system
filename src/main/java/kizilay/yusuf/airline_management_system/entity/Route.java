package kizilay.yusuf.airline_management_system.entity;

import kizilay.yusuf.airline_management_system.resource.RouteResource;

import javax.persistence.*;

@Entity
@Table(name = "route")
public class Route extends BaseEntity<RouteResource> {

    @Id
    @GeneratedValue
    @Column(name = "route_id")
    private int routeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "source_airport_id")
    private Airport source;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "destination_airport_id")
    private Airport destination;

    public Route() {
    }

    public Route(Airport source, Airport destination) {
        this.source = source;
        this.destination = destination;
    }

    public int getRouteId() {
        return routeId;
    }

    public void setRouteId(int routeId) {
        this.routeId = routeId;
    }

    public Airport getSource() {
        return source;
    }

    public void setSource(Airport source) {
        this.source = source;
    }

    public Airport getDestination() {
        return destination;
    }

    public void setDestination(Airport destination) {
        this.destination = destination;
    }

    @Override
    public int getId() {
        return this.routeId;
    }

    @Override
    public RouteResource toResource() {
        return null;
    }
}
