package coderdudos.printdonation.connection.Request;

public class Request {
    type requestType;
    private int id;

    public Request() {
        this.requestType = type.info;
        this.id = -1;
    }

    public Request(type request, int id) {
        this.requestType = request;
        this.id = id;
    }

    public type getRequestType() {
        return this.requestType;
    }

    public void setRequestType(type requestType) {
        this.requestType = requestType;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private enum type {
        info,
        icon,
        photos,
        stl
    }

}