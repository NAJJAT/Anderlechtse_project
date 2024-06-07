package project.dagonderwijsproject.Modle;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class NewsArticle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
    @NotBlank
        private String name;
    @NotBlank
        private String category;
    @NotBlank
        private String content;
    @NotBlank
        private String reporterName;
    @NotBlank
        private String reporterEmail;

}