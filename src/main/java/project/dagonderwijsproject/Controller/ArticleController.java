package project.dagonderwijsproject.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
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


    @GetMapping("/article/{id}")
    public String EditArticle(@PathVariable Long id, Model model) {
        model.addAttribute("article", articleService.getArticle(id));
        return "redirect:/";
    }

    @PostMapping("/save")
    public String saveArticle(@Validated @ModelAttribute("article") NewsArticle article, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("error", "All fields are required and email must be valid.");
            return "new";
        }
        // Save the article using the service
        articleService.saveArticle(article);
        return "redirect:/index";
    }

    @GetMapping("/details/{id}")
    public String viewArticleDetails(@PathVariable Long id, Model model) {
        NewsArticle article = articleService.getArticleById(id);
        if (article == null) {
            return "error"; // handle article not found
        }
        model.addAttribute("article", article);
        return "details"; // view name to display article details
    }
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        NewsArticle existingarticle = articleService.getArticleById(id);
        existingarticle.setName(existingarticle.getName());
        existingarticle.setContent(existingarticle.getCategory());
        existingarticle.setContent(existingarticle.getContent());
        existingarticle.setReporterName(existingarticle.getReporterName());
        existingarticle.setReporterEmail(existingarticle.getReporterEmail());

        if (existingarticle == null) {
            model.addAttribute("error", "Article not found");
            return "error"; // You should have an error.html template to handle this
        }
        model.addAttribute("article", existingarticle);
        return "edit"; // The Thymeleaf template for editing
    }

}





