package zhinquir.com.webscrapper.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zhinquir.com.webscrapper.models.WebPage;
import zhinquir.com.webscrapper.repository.WebPageRepository;
import zhinquir.com.webscrapper.services.SpiderService;
import zhinquir.com.webscrapper.services.WebScrapperService;

import java.io.IOException;
import java.util.List;

@RestController
public class WebPageController {

    private final WebPageRepository repository;
    private final WebScrapperService webScrapperService;

    private final SpiderService spiderService;

    // Inyección de dependencia por constructor
    public WebPageController(WebPageRepository repository, WebScrapperService webScrapperService, SpiderService spiderService) {
        this.repository = repository;
        this.webScrapperService = webScrapperService;
        this.spiderService = spiderService;
    }

    /**
     * http://localhost:8080/api/search?query=chocolate
     * @param query
     * @return
     */
    @GetMapping("/api/search")
    public List<WebPage> search(@RequestParam("query") String query){
        return repository.findByText(query);
    }

    @GetMapping("/api/webscrapper")
    public void scrapeAndSave(@RequestParam("url") String url) throws IOException {
         webScrapperService.scrapeAndSave(url);
    }

    @GetMapping("/api/start")
    public void startSpider() {
       spiderService.start();
    }
}
