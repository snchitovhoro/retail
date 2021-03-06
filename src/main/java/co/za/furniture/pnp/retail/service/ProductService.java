package co.za.furniture.pnp.retail.service;

import co.za.furniture.pnp.retail.model.Product;
import co.za.furniture.pnp.retail.model.Role;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import java.util.List;
import java.util.Optional;

public interface ProductService {

     List<Product> findAll();
     List<Product> findAll(Sort sort);


     /**
      * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
      *
      * @param pageable
      * @return a page of entities
      */
      Page<Product> findAll(Pageable pageable);
      List<Product> findAllById(Iterable<ID> ids);

     /**
      * Returns the number of entities available.
      *
      * @return the number of entities.
      */
      long count();

     /**
      * Deletes the entity with the given id.
      *
      * @param id must not be {@literal null}.
      * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
      */
      void deleteById(ID id);

     /**
      * Deletes a given entity.
      *
      * @param entity must not be {@literal null}.
      * @throws IllegalArgumentException in case the given entity is {@literal null}.
      */

     void delete(Product entity);
     /**
      * Deletes the given entities.
      *
      * @param entities must not be {@literal null}. Must not contain {@literal null} elements.
      * @throws IllegalArgumentException in case the given {@literal entities} or one of its entities is {@literal null}.
      */

     void deleteAll(Iterable<? extends Product> entities);

     /**
      * Deletes all entities managed by the repository.
      */
      void deleteAll();

     /**
      * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
      * entity instance completely.
      *
      * @param entity must not be {@literal null}.
      * @return the saved entity; will never be {@literal null}.
      * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
      */

     <S extends Product> S save(S entity);

     <S extends Product> List<S> saveAll(Iterable<S> entities);

     /**
      * Retrieves an entity by its id.
      *
      * @param id must not be {@literal null}.
      * @return the entity with the given id or {@literal Optional#empty()} if none found.
      * @throws IllegalArgumentException if {@literal id} is {@literal null}.
      */

     Optional<Product> findById(ID id);

     /**
      * Returns whether an entity with the given id exists.
      *
      * @param id must not be {@literal null}.
      * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
      * @throws IllegalArgumentException if {@literal id} is {@literal null}.
      */

     boolean existsById(ID id);

     /**
      * Flushes all pending changes to the database.
      */
      void flush();
     /**
      * Saves an entity and flushes changes instantly.
      *
      * @param entity
      * @return the saved entity
      */

     <S extends Product> S saveAndFlush(S entity);


     /**
      * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
      * the {@link EntityManager} after the call.
      *
      * @param entities
      */

     void deleteInBatch(Iterable<Role> entities);

     /**
      * Deletes all entities in a batch call.
      */

     void deleteAllInBatch();

     /**
      * Returns a reference to the entity with the given identifier. Depending on how the JPA persistence provider is
      * implemented this is very likely to always return an instance and throw an
      * {@link EntityNotFoundException} on first access. Some of them will reject invalid identifiers
      * immediately.
      *
      * @param id must not be {@literal null}.
      * @return a reference to the entity with the given identifier.
      * @see EntityManager#getReference(Class, Object) for details on when an exception is thrown.
      */

     Product getOne(ID id);

     /**
      * Returns a single entity matching the given {@link Example} or {@literal null} if none was found.
      *
      * @param example must not be {@literal null}.
      * @return a single entity matching the given {@link Example} or {@link Optional#empty()} if none was found.
      * @throws IncorrectResultSizeDataAccessException if the Example yields more than one result.
      */

     <S extends Product> Optional<S> findOne(Example<S> example);

     <S extends Product> List<S> findAll(Example<S> example);

     <S extends Product> List<S> findAll(Example<S> example, Sort sort);

     /**
      * Returns a {@link Page} of entities matching the given {@link Example}. In case no match could be found, an empty
      * {@link Page} is returned.
      *
      * @param example  must not be {@literal null}.
      * @param pageable can be {@literal null}.
      * @return a {@link Page} of entities matching the given {@link Example}.
      */

     <S extends Product> Page<S> findAll(Example<S> example, Pageable pageable);

     /**
      * Returns the number of instances matching the given {@link Example}.
      *
      * @param example the {@link Example} to count instances for. Must not be {@literal null}.
      * @return the number of instances matching the {@link Example}.
      */

     <S extends Product> long count(Example<S> example);

     /**
      * Checks whether the data store contains elements that match the given {@link Example}.
      *
      * @param example the {@link Example} to use for the existence check. Must not be {@literal null}.
      * @return {@literal true} if the data store contains elements that match the given {@link Example}.
      */

     <S extends Product> boolean exists(Example<S> example);
     }
