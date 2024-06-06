package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import project.dagonderwijsproject.Modle.Article;
import project.dagonderwijsproject.Service.ArticleService;

import javax.management.BadAttributeValueExpException;
import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private ArticleService articleService;

    // maak methoed  to  see all  articles in datebase
    @GetMapping("/details")
    public String details(Article article){
        return "new";
    }

    @GetMapping("/allArticle")
    public String index(Article article){
        List<Article> articles = articleService.getAllArticles();
        article.addAttributes("articles", articles);
        return "index";
    }


        //maak een nieuwe article aan
    @GetMapping("/new")
    public String showForm(ModelMap model) {
        Article article = new Article(1, "title", "content", "category", "reporterName", "reporterEmail");
        model.addAttribute("article", article);

        return "/new";
    }

    @PostMapping("/add")
    public String addArticle(@ModelAttribute ("article") Article article, BindingResult bindingResult){
        articleService.saveArticle(article);
        return  "/index";

    }
    @GetMapping("/about")
    public String about() {
        return "about";
    }
}
