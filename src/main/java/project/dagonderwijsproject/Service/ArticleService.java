package project.dagonderwijsproject.Service;

import project.dagonderwijsproject.Modle.Article;
import org.springframework.beans.factory.annotation.Autowired;
import project.dagonderwijsproject.Repository.ArtcileRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArtcileRepository articleRepository;

    public List<Article> getAllArticles(){
        return this.articleRepository.findAll();
    }

    public Article getArticleById(long id){
        return this.articleRepository.findById(id).get();
    }

    public  Article saveArticle(Article article){
        return this.articleRepository.save(article);
    }

    public  Article updateArticle(Article article){
        return this.articleRepository.save(article);
    }

}
