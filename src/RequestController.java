import java.lang.classfile.constantpool.DoubleEntry;
import java.util.ArrayList;

public class RequestController {
    public void ServerResponse(){
        ArrayList<Double> parsedNumbers = new ArrayList<>();
    }
    public void ProcessRequest(ClientRequest request, ArrayList<Double> parsedNumbers){
        //Check endpoint which is kinda like the input
        String userInput = request.endpoint.trim().toLowerCase();
        if(userInput.equals("api") || userInput.equals("analytics") || userInput.equals("calculate")){
            System.out.println("valid");
            String[] myToken = request.payload.split(",");
            for(String token:myToken){
                token.trim();
                double newToken = Double.parseDouble(token);
                parsedNumbers.add(newToken);
            }
            //we have our parsedNumbers at this point

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
