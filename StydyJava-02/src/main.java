import java.io.IOException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

// Código da api a49fa2ca
public class main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o nome do filme: ");
        String filme = scanner.nextLine();
//        var filme2 = scanner.nextLine();
        var endereco = "https://www.omdbapi.com/?t=" + filme + "&apikey=a49fa2ca";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(java.net.URI.create(endereco)) // Endereço da api
                .build();
        HttpResponse<String> response = client.send(request,
                HttpResponse.BodyHandlers.ofString());
        System.out.println(response.body());
    }
}
