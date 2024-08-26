package zhinquir.com.webscrapper.servicesImpl;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Service;
import zhinquir.com.webscrapper.models.WebPage;
import zhinquir.com.webscrapper.repository.WebPageRepository;
import zhinquir.com.webscrapper.services.WebScrapperService;
import zhinquir.com.webscrapper.utilities.Utilities;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScrapperServiceImpl implements WebScrapperService {

    private final WebPageRepository repository;

    public WebScrapperServiceImpl(WebPageRepository repository) {
        this.repository = repository;
    }


    @Override
    public void scrapeAndSave(String url) {

        try {
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
        }catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<String> getAllLinks(String url) {
        List<String> results = new ArrayList<>();
        try {
            WebPage webPage = repository.findByUrl(url);

            if(webPage!=null)
                return results;

            Document document = Jsoup.connect(url).get(); // Carga pagina
            Elements links = document.select("a[href]"); // Obtiene todos los links de la pagina
            for (Element link : links) {
                String linkHref =  link.attr("href");

                if(linkHref.startsWith("/"))
                    linkHref = "https://" + Utilities.extractDomain(url)+linkHref;

                if (!results.contains(linkHref))
                    results.add(linkHref);
            }

        }catch (Exception e){
            System.out.println(e.getMessage());
        }
        return results;
    }
}
