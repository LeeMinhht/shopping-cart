package poly.edu.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Service;
import poly.edu.domain.Authority;
import poly.edu.repository.AuthorityRepository;
import poly.edu.service.AuthorityService;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
public class AuthorityServiceImpl implements AuthorityService {
    @Autowired
    AuthorityRepository authorityRepository;

    @Override
    public List<Authority> findAll() {
        return authorityRepository.findAll();
    }

    @Override
    public List<Authority> findAll(Sort sort) {
        return authorityRepository.findAll(sort);
    }

    @Override
    public List<Authority> findAllById(Iterable<Integer> integers) {
        return authorityRepository.findAllById(integers);
    }

    @Override
    public <S extends Authority> List<S> saveAll(Iterable<S> entities) {
        return authorityRepository.saveAll(entities);
    }

    @Override
    public void flush() {
        authorityRepository.flush();
    }

    @Override
    public <S extends Authority> S saveAndFlush(S entity) {
        return authorityRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Authority> List<S> saveAllAndFlush(Iterable<S> entities) {
        return authorityRepository.saveAllAndFlush(entities);
    }

    @Override
    @Deprecated
    public void deleteInBatch(Iterable<Authority> entities) {
        authorityRepository.deleteInBatch(entities);
    }

    @Override
    public void deleteAllInBatch(Iterable<Authority> entities) {
        authorityRepository.deleteAllInBatch(entities);
    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {
        authorityRepository.deleteAllByIdInBatch(integers);
    }

    @Override
    public void deleteAllInBatch() {
        authorityRepository.deleteAllInBatch();
    }

    @Deprecated
    public Authority getOne(Integer integer) {
        return authorityRepository.getOne(integer);
    }

    @Override
    @Deprecated
    public Authority getById(Integer integer) {
        return authorityRepository.getById(integer);
    }

    @Override
    public Authority getReferenceById(Integer integer) {
        return authorityRepository.getReferenceById(integer);
    }

    @Override
    public <S extends Authority> List<S> findAll(Example<S> example) {
        return authorityRepository.findAll(example);
    }

    @Override
    public <S extends Authority> List<S> findAll(Example<S> example, Sort sort) {
        return authorityRepository.findAll(example, sort);
    }

    @Override
    public Page<Authority> findAll(Pageable pageable) {
        return authorityRepository.findAll(pageable);
    }

    @Override
    public <S extends Authority> S save(S entity) {
        return authorityRepository.save(entity);
    }

    @Override
    public Optional<Authority> findById(Integer integer) {
        return authorityRepository.findById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return authorityRepository.existsById(integer);
    }

    @Override
    public long count() {
        return authorityRepository.count();
    }

    @Override
    public void deleteById(Integer integer) {
        authorityRepository.deleteById(integer);
    }

    @Override
    public void delete(Authority entity) {
        authorityRepository.delete(entity);
    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {
        authorityRepository.deleteAllById(integers);
    }

    @Override
    public void deleteAll(Iterable<? extends Authority> entities) {
        authorityRepository.deleteAll(entities);
    }

    @Override
    public void deleteAll() {
        authorityRepository.deleteAll();
    }

    @Override
    public <S extends Authority> Optional<S> findOne(Example<S> example) {
        return authorityRepository.findOne(example);
    }

    @Override
    public <S extends Authority> Page<S> findAll(Example<S> example, Pageable pageable) {
        return authorityRepository.findAll(example, pageable);
    }

    @Override
    public <S extends Authority> long count(Example<S> example) {
        return authorityRepository.count(example);
    }

    @Override
    public <S extends Authority> boolean exists(Example<S> example) {
        return authorityRepository.exists(example);
    }

    @Override
    public <S extends Authority, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return authorityRepository.findBy(example, queryFunction);
    }
}
