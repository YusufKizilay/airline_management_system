package kizilay.yusuf.airline_management_system.resource;

public class RouteResource {

    private int sourceAirportId;

    private int destinationAirportId;

    private String sourceAirportResource;

    private String destinationAirportResource;

    public RouteResource() {
    }

    public RouteResource(int sourceAirportId, int destinationAirportId) {
        this.sourceAirportId = sourceAirportId;
        this.destinationAirportId = destinationAirportId;
        this.sourceAirportResource="/airline_management_system/airport/"+sourceAirportId;
        this.destinationAirportResource="/airline_management_system/airport/"+destinationAirportId;
    }

    public int getSourceAirportId() {
        return sourceAirportId;
    }

    public void setSourceAirportId(int sourceAirportId) {
        this.sourceAirportId = sourceAirportId;
    }

    public int getDestinationAirportId() {
        return destinationAirportId;
    }

    public void setDestinationAirportId(int destinationAirportId) {
        this.destinationAirportId = destinationAirportId;
    }

    public String getSourceAirportResource() {
        return sourceAirportResource;
    }

    public void setSourceAirportResource(String sourceAirportResource) {
        this.sourceAirportResource = sourceAirportResource;
    }

    public String getDestinationAirportResource() {
        return destinationAirportResource;
    }

    public void setDestinationAirportResource(String destinationAirportResource) {
        this.destinationAirportResource = destinationAirportResource;
    }
}
