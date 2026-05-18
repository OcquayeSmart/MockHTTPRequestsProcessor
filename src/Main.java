public class Main {
    public static void main(String[] args){
        ClientRequest request =  new ClientRequest("API", "3.0, -4.0, 12.5, -9.9");
        RequestController controller = new RequestController();
        ServerResponse requests = controller.ProcessRequest(request);
        System.out.println(requests);
    }
}
