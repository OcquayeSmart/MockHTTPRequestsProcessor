import java.util.Arrays;
public class Main {
    public static void main(String[] args){
        ClientRequest request =  new ClientRequest("/api/analytics/calculae", "2.0, string, -5");
        RequestController controller = new RequestController();
        ServerResponse requests = controller.processRequest(request);
        System.out.println(requests);
    }
}
