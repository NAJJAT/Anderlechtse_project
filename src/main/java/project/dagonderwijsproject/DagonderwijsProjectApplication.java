package project.dagonderwijsproject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import project.dagonderwijsproject.Modle.NewsArticle;
import project.dagonderwijsproject.Service.NewsArticleService;

@SpringBootApplication
public class DagonderwijsProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(DagonderwijsProjectApplication.class, args);
    }



}
