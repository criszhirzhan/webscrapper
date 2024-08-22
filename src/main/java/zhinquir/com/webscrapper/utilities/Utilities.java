package zhinquir.com.webscrapper.utilities;
import java.net.MalformedURLException;
import java.net.URL;

public final class Utilities {

    /**
     * Método estático para extraer el dominio de una URL
     * @param url
     * @return
     */
    public static String extractDomain(String url) {
        try {
            URL uri = new URL(url);
            return uri.getHost();
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return null; // Manejar la excepción según sea necesario
        }
    }
}
