package zhinquir.com.webscrapper.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import zhinquir.com.webscrapper.models.WebPage;

import java.util.List;

@Repository
public interface WebPageRepository extends JpaRepository<WebPage, Integer> {

    @Query(
            "SELECT wp FROM WebPage wp " +
                    "WHERE UPPER(wp.domain) LIKE UPPER(CONCAT('%', :text, '%')) " +
                    "OR UPPER(wp.description) LIKE UPPER(CONCAT('%', :text, '%')) " +
                    "OR UPPER(wp.title) LIKE UPPER(CONCAT('%', :text, '%')) " +
                    "OR UPPER(wp.url) LIKE UPPER(CONCAT('%', :text, '%')) "+
                    "ORDER BY wp.rank ASC"
    )
    List<WebPage> findByText(@Param("text") String text);
    WebPage findByUrl(String url);


}
