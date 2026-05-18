import java.util.ArrayList;

public class RequestController {
    ArrayList<Double> parsedNumbers = new ArrayList<>();
    ServerResponse toUser = new ServerResponse();
    public void ServerResponse(){


    }
    public void ProcessRequest(ClientRequest request, ArrayList<Double> parsedNumbers){
        //Check endpoint which is kinda like the input
        String userInput = request.endpoint.trim().toLowerCase();
        if(userInput.equals("api") || userInput.equals("analytics") || userInput.equals("calculate")){
            System.out.println("valid");
            String[] myToken = request.payload.split(",");
            for(String token:myToken){
                double newToken = Double.parseDouble(token.trim());
                parsedNumbers.add(Math.abs(newToken));
                //this is the new payload, don't know what to do with it yet
            }
            //we have our parsedNumbers at this point
            System.out.println(Math.max(parsedNumbers));

        }

        else{

            toUser.statusCode = 400;
            System.out.println("Bad Request: Invalid Endpoint");
            //will later remove
            System.out.println("empty body//");
        }



    }
}
