public class ClientRequest {
    private final String endpoint;
    private final String payload;

    ClientRequest(String endpoint, String payload){
        this.endpoint = endpoint;
        this.payload = payload;
    }
    public String getEndpoint(){
        return this.endpoint;
    }
    public String getPayload(){
        return this.payload;
    }
}
