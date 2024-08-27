package zhinquir.com.webscrapper.jobs;

import org.springframework.scheduling.annotation.Scheduled;
import zhinquir.com.webscrapper.services.SpiderService;

public class WebScrapperJob {

    private final SpiderService spiderService;

    public WebScrapperJob(SpiderService spiderService) {
        this.spiderService = spiderService;
    }

    @Scheduled(cron = "0 0 17 * * MON")
    public void executeJob(){
        spiderService.start();
    }
}
