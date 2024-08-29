import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpHeaders;
import java.net.http.HttpResponse.BodyHandlers;

public class Main {
    public static void main(String[] args) {
        try {
            // Construção da URI com query parameters
            String uri = "Teste";

            // Criação do cliente HTTP
            HttpClient client = HttpClient.newHttpClient();

            // Construção do corpo da requisição
            String jsonBody = "{ \"username\": \"73612754009\" }";

            // Construção da requisição HTTP DELETE
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(uri))
                    .header("Authorization", "oi")
                    .header("Content-Type", "application/json")
                    .method("DELETE", BodyPublishers.ofString(jsonBody))
                    .build();

            // Envio da requisição e obtenção da resposta
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());

            // Impressão do status e do corpo da resposta
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
