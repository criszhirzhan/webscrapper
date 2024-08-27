package zhinquir.com.webscrapper.services;

import java.io.IOException;
import java.util.List;

public interface WebScrapperService {

    public void scrapeAndSave(String url);

    /**
     * Metodo que obtiene todos los links de una pagina web
     * @param url de la pagina web
     * @return
     */
    public List<String> getAllLinks(String url);
}
