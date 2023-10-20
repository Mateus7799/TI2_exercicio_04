import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class AzureTextAnalyzer {

  private static final String endpoint = "https://southamerica.api.cognitive.microsoft.com/text/analytics/v3.0-preview.1/sentiment";
    private static final String subscriptionKey = "<fkFH8803IuVY47rql5VrTQC0RKbRzUruzGMkwnLFJYAzSeAw16dD>"; 

    public static void main(String[] args) throws Exception {
        HttpClient httpclient = HttpClients.createDefault();

        HttpPost request = new HttpPost(endpoint);
        request.setHeader("Content-Type", "application/json");
        request.setHeader("Ocp-Apim-Subscription-Key", subscriptionKey);

        StringEntity reqEntity = new StringEntity(
                "{\n" +
                        "  \"documents\": [\n" +
                        "    {\n" +
                        "      \"language\": \"en\",\n" +
                        "      \"id\": \"1\",\n" +
                        "      \"text\": \"I had a wonderful experience! The rooms were wonderful and the staff was helpful.\"\n" +
                        "    }\n" +
                        "  ]\n" +
                        "}",
                "UTF-8");
        request.setEntity(reqEntity);

        HttpResponse response = httpclient.execute(request);
        HttpEntity entity = response.getEntity();

        if (entity != null) {
            System.out.println(EntityUtils.toString(entity, "UTF-8"));
        }
    }
}
