package zhinquir.com.webscrapper.services;

import java.io.IOException;

public interface WebScrapperService {

    public void scrapeAndSave(String url) throws IOException;
}
