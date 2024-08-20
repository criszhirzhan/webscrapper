package zhinquir.com.webscrapper.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "webpage")
public class WebPage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String domain;
    private String url;
    private String title;
    private String description;
    private String picture;
    private Integer rank;
}
