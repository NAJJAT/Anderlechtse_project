package project.dagonderwijsproject.Controller;

import ch.qos.logback.core.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import project.dagonderwijsproject.Modle.NewsArticle;
import project.dagonderwijsproject.Service.NewsArticleService;

@Controller
public class IndexController {

@Autowired
private NewsArticleService articleService;

@GetMapping("/")
public String index(ModelMap model) {
    model.addAttribute("articles", articleService.getLatestArticles());
    return "index";
}
}