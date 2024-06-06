package project.dagonderwijsproject.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dagonderwijsproject.Modle.NewsArticle;
import project.dagonderwijsproject.Repository.NewsArticleRepository;

import java.util.List;

@Service
public class NewsArticleService {

    @Autowired
    private NewsArticleRepository repository;

    public List<NewsArticle> getLatestArticles() {
        return repository.findTop10ByOrderByIdDesc();
    }

    public NewsArticle getArticleById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public void saveArticle(NewsArticle article) {
        repository.save(article);
    }
    public NewsArticle getArticle(Long id) {
        return repository.findById(id).orElse(null);
    }

}