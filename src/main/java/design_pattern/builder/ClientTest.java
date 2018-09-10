package design_pattern.builder;

public class ClientTest {
    public static void main(String[] args) {
        Client client = new Client.Builder()
                .setName("String")
                .setAge(66)
                .build();
        System.out.println(client);
    }
}
