import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaMoneda {
    private static final String API_KEY = "3d64481ddf84b92e98c87524";
    private static final String API_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static HttpResponse<String> obtenerTasasDeCambio(String moneda) throws IOException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(API_URL + moneda))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() != 200) {
            throw new IOException("Error en la API: Código de respuesta HTTP " + response.statusCode());
        }

        return response;
    }

    public static JsonObject obtenerTasasDeCambioJson(HttpResponse<String> respuesta) {
        Gson gson = new Gson();
        return gson.fromJson(respuesta.body(), JsonObject.class);
    }

    public static double obtenerTasaDeCambio(JsonObject jsonObject, String monedaDestino) {
        // Validar si "conversion_rates" existe en el JSON
        if (!jsonObject.has("conversion_rates")) {
            throw new NullPointerException("El JSON no contiene la clave 'conversion_rates'. Respuesta: " + jsonObject);
        }

        JsonObject conversionRates = jsonObject.get("conversion_rates").getAsJsonObject();

        // Validar si la moneda destino existe en "conversion_rates"
        if (!conversionRates.has(monedaDestino)) {
            throw new IllegalArgumentException("La moneda destino '" + monedaDestino + "' no está disponible.");
        }

        return conversionRates.get(monedaDestino).getAsDouble();
    }

    public static double convertirMoneda(double cantidad, String monedaOrigen, String monedaDestino) throws IOException, InterruptedException {
        HttpResponse<String> respuesta = obtenerTasasDeCambio(monedaOrigen);
        JsonObject jsonObject = obtenerTasasDeCambioJson(respuesta);
        double tasaDeCambio = obtenerTasaDeCambio(jsonObject, monedaDestino);

        return cantidad * tasaDeCambio;
    }
}
