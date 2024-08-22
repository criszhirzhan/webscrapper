package zhinquir.com.webscrapper.servicesImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.stereotype.Service;
import zhinquir.com.webscrapper.models.WebPage;
import zhinquir.com.webscrapper.repository.WebPageRepository;
import zhinquir.com.webscrapper.services.WebScrapperService;
import zhinquir.com.webscrapper.utilities.Utilities;

import java.io.IOException;

@Service
public class WebScrapperServiceImpl implements WebScrapperService {

    private final WebPageRepository repository;

    public WebScrapperServiceImpl(WebPageRepository repository) {
        this.repository = repository;
    }


    @Override
    public void scrapeAndSave(String url) throws IOException {

        // se va a conectar a una url y la va a descargar y se almacena en la variable document
        Document document = Jsoup.connect(url).get();

        String title = document.title();

        // Extrae el contenido de la meta descripción de la página web
        String description = document.select("meta[name=description]")
                .attr("content");

        // Extrae el contenido de la meta image de la página web
        String picture = document.select("meta[property=og:image]")
                .attr("content");

        String domain = Utilities.extractDomain(url);

        WebPage webPage = new WebPage();
        webPage.setTitle(title);
        webPage.setDescription(description);
        webPage.setPicture(picture);
        webPage.setDomain(domain);
        webPage.setUrl(url);

        repository.save(webPage);

    }
}
