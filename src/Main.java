public class Main {
    public static void main(String[] args){
        ClientRequest request =  new ClientRequest("/api/analytics/calculate", "1.0, 2.0");
        RequestController controller = new RequestController();
        ServerResponse requests = controller.ProcessRequest(request);
        System.out.println(requests);
    }
}
