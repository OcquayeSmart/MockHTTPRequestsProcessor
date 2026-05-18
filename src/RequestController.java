import java.util.ArrayList;

public class RequestController {
    ArrayList<Double> parsedNumbers = new ArrayList<>();
    static ServerResponse errorCode1 = new ServerResponse(400, "Bad request: Invalid Endpoint", "No processing took place");
    static ServerResponse successCode = new ServerResponse(200, "OK", "Metrics Summary: Max Abs = %f | Ceil Max = %d | Hypotenuse = %f".formatted(RequestController.maxValue, RequestController.ceilMaxValue, RequestController.hypotenuse));
    static double maxValue;
    static int ceilMaxValue;
    static int counter = 0;
    static double firstValue;
    static double secondValue;
    static double hypotenuse;
    static String summary;
    static String userInput;
    public ServerResponse ProcessRequest(ClientRequest request){
        //Check endpoint which is kinda like the input
        userInput = request.getEndpoint().trim().toLowerCase();
        //endpoint validation
        if(userInput.equals(Endpoint.API.name().toLowerCase()) || userInput.equals(Endpoint.ANALYTICS.name().toLowerCase()) || userInput.equals(Endpoint.CALCUlATE.name().toLowerCase())){
            System.out.println("valid");
            String[] myToken = request.getPayload().split(",");
            for(String token:myToken){
                double newToken = Double.parseDouble(token.trim());
                counter+=1;
                parsedNumbers.add(Math.abs(newToken));
                //this is the new payload, don't know what to do with it yet
            }
            //hypotenuse approximation
            for(int i = 0; i < parsedNumbers.size(); i++){
                if(counter>=2){
                    firstValue = parsedNumbers.get(i);
                    secondValue = parsedNumbers.get(i+1);
                    hypotenuse = Math.sqrt(Math.pow(firstValue, 2) + Math.pow(secondValue, 2));
                }
                else{
                    hypotenuse = 0.0;
                }
            }
            //we have our parsedNumbers at this point
            for(int i = 0; i < parsedNumbers.size(); i++){
                double currentValue = parsedNumbers.get(i);
                maxValue = currentValue;
                if(parsedNumbers.get(i+1) > currentValue){
                    maxValue = parsedNumbers.get(i+1);
                }
            }
            //ceiling of the maximum
            ceilMaxValue = (int) Math.ceil(maxValue);
        }
        else{
            return errorCode1;
        }
        return successCode;
    }
}
