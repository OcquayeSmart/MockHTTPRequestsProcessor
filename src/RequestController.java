import java.util.ArrayList;

public class RequestController {
    ArrayList<Double> parsedNumbers = new ArrayList<>();
    static double maxValue = 0;
    double nextValue;
    static int ceilMaxValue;
    static int counter = 0;
    static double firstValue, secondValue, hypotenuse, currentValue;
    static String summary;
    static String userInput;
    static String endpoint = "/api/analytics/calculate";


    public ServerResponse ProcessRequest(ClientRequest request){
        //Check endpoint which is kinda like the input
        userInput = request.getEndpoint().trim().toLowerCase();
        //endpoint validation
        if(userInput.equals(endpoint.trim())){
            String[] myToken = request.getPayload().split(",");
            for(String token:myToken){
                double newToken = Double.parseDouble(token.trim());
                counter+=1;
                parsedNumbers.add(Math.abs(newToken));
                //this is the new payload, don't know what to do with it yet
            }
            //hypotenuse approximation
            if(parsedNumbers.size() > 1){
                firstValue = parsedNumbers.get(0);
                secondValue = parsedNumbers.get(1);
                hypotenuse = Math.sqrt(Math.pow(firstValue, 2) + Math.pow(secondValue, 2));
            }
            else if(parsedNumbers.isEmpty()){
                hypotenuse = 0.0;
            }
            //we have our parsedNumbers at this point
            for(int i = 0; i < parsedNumbers.size() - 1; i++){
                currentValue = parsedNumbers.get(i);
                nextValue = parsedNumbers.get(i+1);
                maxValue = currentValue;
                if(currentValue < nextValue){
                    maxValue = nextValue;
                }
                else if(nextValue < currentValue){
                    maxValue = currentValue;
                }
            }
            //ceiling of the maximum
            ceilMaxValue = (int) Math.ceil(maxValue);
        }
        else{
            return new ServerResponse(400, "Bad request: Invalid Endpoint", "No processing took place");
        }
        return new ServerResponse(200, "OK", "Metrics Summary: Max Abs = %.1f | Ceil Max = %d | Hypotenuse = %.1f".formatted(maxValue, ceilMaxValue, hypotenuse));
    }
}
