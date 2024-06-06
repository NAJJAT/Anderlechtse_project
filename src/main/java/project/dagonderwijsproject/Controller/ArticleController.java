package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import project.dagonderwijsproject.Modle.NewsArticle;
import project.dagonderwijsproject.Service.NewsArticleService;

@Controller
public class ArticleController {

    @Autowired
    private NewsArticleService articleService;

    @GetMapping("/new")
    public String newArticle() {
        return "new";
    }
    @GetMapping("/about")
        public String about() {
        return "about";
    }
    /*
    //post Object
    @PostMapping("/save")
    public NewsArticle saveArticle (@RequestBody NewsArticle article) {
        articleService.saveArticle(article);
        return article;
    }
*/
    @GetMapping("/article/{id}")
    public String EditArticle(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveArticle(@RequestParam String name, @RequestParam String category, @RequestParam String content, @RequestParam String reporterName, @RequestParam String reporterEmail, Model model) {
        NewsArticle article = new NewsArticle();
        article.setName(name);
        article.setCategory(category);
        article.setContent(content);
        article.setReporterName(reporterName);
        article.setReporterEmail(reporterEmail);
        if (name.isEmpty() || category.isEmpty() || content.isEmpty() || reporterName.isEmpty() || !reporterEmail.contains("@")) {
            model.addAttribute("error", "All fields are required and email must be valid.");
            return "new";
        }
        articleService.saveArticle(article);
        return "redirect:/";
    }

    }


