package kizilay.yusuf.airline_management_system.resource;

public class Response {

    private int id;

    private String resource;

    public Response(int id, String resource) {
        this.id = id;
        this.resource = resource;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }
}
