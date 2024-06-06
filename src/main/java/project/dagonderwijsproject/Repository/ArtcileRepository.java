package project.dagonderwijsproject.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import project.dagonderwijsproject.Modle.Article;

@Repository
public interface ArtcileRepository  extends JpaRepository<Article, Long> {


}
