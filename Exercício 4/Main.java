
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Main {

    public static void main(String[] args) {
        try {
            // URL do serviço cognitivo
            String url = "4BtmFQcAHVIvMLv8qcwWnk6iURKmhD5UVA9uKdZxIOpHtguCRazxJHASIJXBasdfasa2231H9UY8";
            String apiKey = "<your-api-key>"; // Chave de API do serviço cognitivo

            // Dados de entrada no formato JSON
            String inputData = "{\"documents\": [{\"id\": \"1\", \"language\": \"pt\", \"text\": \"Eu adoro esse produto!\"}]}";

            // Conexão HTTP
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Ocp-Apim-Subscription-Key", apiKey);
            con.setDoOutput(true);

            // Enviar dados de entrada
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = inputData.getBytes("utf-8");
                os.write(input, 0, input.length);
            }

            // Receber a resposta
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            // Exibir a resposta
            System.out.println("Resposta: " + response.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
