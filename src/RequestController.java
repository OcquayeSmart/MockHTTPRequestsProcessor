public class RequestController {
    public void ServerResponse(){

    }
    public void ProcessRequest(ClientRequest request){
        //Check endpoint which is kinda like the input
        String userInput = request.endpoint.trim().toLowerCase();
        if(userInput.equals("api") || userInput.equals("analytics") || userInput.equals("calculate")){
            System.out.println("valid");
        }
        else{
            ServerResponse toUser = new ServerResponse();
            toUser.statusCode = 400;
            System.out.println("Bad Request: Invalid Endpoint");
            //will later remove
            System.out.println("empty body//");
        }
    }
}
