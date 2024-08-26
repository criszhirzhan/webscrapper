package zhinquir.com.webscrapper.servicesImpl;

import org.springframework.stereotype.Service;
import zhinquir.com.webscrapper.services.SpiderService;
import zhinquir.com.webscrapper.services.WebScrapperService;

import java.util.List;

@Service
public class SpiderServiceImpl implements SpiderService {

    private final WebScrapperService webScrapperService;

    public SpiderServiceImpl(WebScrapperService webScrapperService) {
        this.webScrapperService = webScrapperService;
    }

    @Override
    public void start() {
        String initialLink = "https://elpais.com/internacional/";
        scrapeLinksAndSave(initialLink);
    }


    public void scrapeLinksAndSave(String url) {

        // Buscar todos los links del link inicial, entra a cada uno de los links y luego a los links de links
        // para ir obteniendo toda la informacion en modo de red de telarana
        String initialLink = "https://elpais.com";
        List<String> links = webScrapperService.getAllLinks(initialLink);

        links.stream().forEach(link -> {
            webScrapperService.scrapeAndSave(link);
            scrapeLinksAndSave(url);
        });
    }
}
