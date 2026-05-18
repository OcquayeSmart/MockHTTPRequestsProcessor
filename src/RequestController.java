import java.util.ArrayList;

public class RequestController {
    ArrayList<Double> parsedNumbers = new ArrayList<>();
    ServerResponse toUser = new ServerResponse();
    double maxValue;
    int ceilMaxValue;
    int counter = 0;
    double firstValue;
    double secondValue;
    double hypotenuse;
    String summary;
    String userInput;
    public void ServerResponse(){


    }
    public void ProcessRequest(ClientRequest request, ArrayList<Double> parsedNumbers){
        //Check endpoint which is kinda like the input
        userInput = request.endpoint.trim().toLowerCase();
        if(userInput.equals(Endpoint.API.name().toLowerCase()) || userInput.equals(Endpoint.ANALYTICS.name().toLowerCase()) || userInput.equals(Endpoint.CALCUlATE.name().toLowerCase())){
            System.out.println("valid");
            String[] myToken = request.payload.split(",");
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

            toUser.statusCode = 400;
            System.out.println("Bad Request: Invalid Endpoint");
            //will later remove
            System.out.println("empty body//");
        }
        summary = """
Metrics Summary: Max Abs = %f | Ceil Max = %d | Hypotenuse = %f
                                   
                    """.formatted(maxValue, ceilMaxValue, hypotenuse);
        System.out.println(summary);


    }
}
