package poly.edu.service;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import poly.edu.domain.Authority;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public interface AuthorityService {
    List<Authority> findAll();

    List<Authority> findAll(Sort sort);

    List<Authority> findAllById(Iterable<Integer> integers);

    <S extends Authority> List<S> saveAll(Iterable<S> entities);

    void flush();

    <S extends Authority> S saveAndFlush(S entity);

    <S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities);

    @Deprecated
    void deleteInBatch(Iterable<Authority> entities);

    void deleteAllInBatch(Iterable<Authority> entities);

    void deleteAllByIdInBatch(Iterable<Integer> integers);

    void deleteAllInBatch();

    @Deprecated
    Authority getById(Integer integer);

    Authority getReferenceById(Integer integer);

    <S extends Authority> List<S> findAll(Example<S> example);

    <S extends Authority> List<S> findAll(Example<S> example, Sort sort);

    Page<Authority> findAll(Pageable pageable);

    <S extends Authority> S save(S entity);

    Optional<Authority> findById(Integer integer);

    boolean existsById(Integer integer);

    long count();

    void deleteById(Integer integer);

    void delete(Authority entity);

    void deleteAllById(Iterable<? extends Integer> integers);

    void deleteAll(Iterable<? extends Authority> entities);

    void deleteAll();

    <S extends Authority> Optional<S> findOne(Example<S> example);

    <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable);

    <S extends Authority> long count(Example<S> example);

    <S extends Authority> boolean exists(Example<S> example);

    <S extends Authority, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction);
}
