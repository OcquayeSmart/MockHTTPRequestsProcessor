public class ServerResponse {
    private final int statusCode;
    private final String statusMessage;
    private final String body;

    ServerResponse(int statusCode, String statusMessage, String body){
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.body = body;
    }
    public int getStatusCode(){
        return this.statusCode;
    }
    public String getStatusMessage(){
        return this.statusMessage;
    }
    public String getBody(){
        return this.body;
    }
    @Override
    public String toString(){
        return RequestController.summary = """
Status %d, Message %s, Body %s""".formatted(getStatusCode(),getStatusMessage(),getBody());
    }
}
