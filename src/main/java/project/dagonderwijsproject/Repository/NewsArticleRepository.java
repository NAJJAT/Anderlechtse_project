package project.dagonderwijsproject.Repository;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.FluentQuery;
import project.dagonderwijsproject.Modle.NewsArticle;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface NewsArticleRepository extends JpaRepository<NewsArticle, Long> {
    List<NewsArticle> findTop10ByOrderByIdDesc();

    @Override
    void flush();

    @Override
    <S extends NewsArticle> S saveAndFlush(S entity);

    @Override
    <S extends NewsArticle> List<S> saveAllAndFlush(Iterable<S> entities);

    @Override
    default void deleteInBatch(Iterable<NewsArticle> entities) {
        JpaRepository.super.deleteInBatch(entities);
    }

    @Override
    void deleteAllInBatch(Iterable<NewsArticle> entities);

    @Override
    void deleteAllByIdInBatch(Iterable<Long> longs);

    @Override
    void deleteAllInBatch();

    @Override
    NewsArticle getOne(Long aLong);

    @Override
    NewsArticle getById(Long aLong);

    @Override
    NewsArticle getReferenceById(Long aLong);

    @Override
    <S extends NewsArticle> List<S> findAll(Example<S> example);

    @Override
    <S extends NewsArticle> List<S> findAll(Example<S> example, Sort sort);

    @Override
    <S extends NewsArticle> List<S> saveAll(Iterable<S> entities);

    @Override
    List<NewsArticle> findAll();

    @Override
    List<NewsArticle> findAllById(Iterable<Long> longs);

    @Override
    <S extends NewsArticle> S save(S entity);

    @Override
    Optional<NewsArticle> findById(Long aLong);

    @Override
    boolean existsById(Long aLong);

    @Override
    long count();

    @Override
    void deleteById(Long aLong);

    @Override
    void delete(NewsArticle entity);

    @Override
    void deleteAllById(Iterable<? extends Long> longs);

    @Override
    void deleteAll(Iterable<? extends NewsArticle> entities);

    @Override
    void deleteAll();

    @Override
    List<NewsArticle> findAll(Sort sort);

    @Override
    Page<NewsArticle> findAll(Pageable pageable);

    @Override
    <S extends NewsArticle> Optional<S> findOne(Example<S> example);

    @Override
    <S extends NewsArticle> Page<S> findAll(Example<S> example, Pageable pageable);

    @Override
    <S extends NewsArticle> long count(Example<S> example);

    @Override
    <S extends NewsArticle> boolean exists(Example<S> example);

    @Override
    <S extends NewsArticle, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);

}
