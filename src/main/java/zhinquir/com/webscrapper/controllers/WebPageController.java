package zhinquir.com.webscrapper.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import zhinquir.com.webscrapper.models.WebPage;
import zhinquir.com.webscrapper.repository.WebPageRepository;

import java.util.List;

@RestController
public class WebPageController {

    @Autowired
    WebPageRepository repository;

    /**
     * http://localhost:8080/api/search?query=chocolate
     * @param query
     * @return
     */
    @GetMapping("/api/search")
    public List<WebPage> search(@RequestParam("query") String query){
        return repository.findByText(query);
    }
}
