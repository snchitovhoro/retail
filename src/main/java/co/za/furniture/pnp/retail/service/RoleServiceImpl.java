package co.za.furniture.pnp.retail.service;

import co.za.furniture.pnp.retail.DAO.RoleJpaDao;
import co.za.furniture.pnp.retail.model.Role;
import com.sun.xml.bind.v2.model.core.ID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityNotFoundException;
import javax.persistence.Query;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class RoleServiceImpl implements RoleService{
    @Qualifier("RoleJpaDao")
    @Autowired
    public RoleJpaDao roleDAO;

    @Override
    public List<Role> findAll() {
        return roleDAO.findAll();
    }

    @Override
    public List<Role> findAll(Sort sort) {
        return roleDAO.findAll(sort);
    }

    /**
     * Returns a {@link Page} of entities meeting the paging restriction provided in the {@code Pageable} object.
     *
     * @param pageable
     * @return a page of entities
     */
    @Override
    public Page<Role> findAll(Pageable pageable) {
        return roleDAO.findAll(pageable);
    }

    @Override
    public List<Role> findAllById(Iterable<ID> ids) {
        return roleDAO.findAllById(ids);
    }

    /**
     * Returns the number of entities available.
     *
     * @return the number of entities.
     */
    @Override
    public long count() {
        return roleDAO.count();
    }

    /**
     * Deletes the entity with the given id.
     *
     * @param id must not be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal id} is {@literal null}
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void deleteById(ID id) {
        roleDAO.deleteById(id);
    }

    /**
     * Deletes a given entity.
     *
     * @param entity must not be {@literal null}.
     * @throws IllegalArgumentException in case the given entity is {@literal null}.
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void delete(Role entity) {
        roleDAO.delete(entity);

    }

    /**
     * Deletes the given entities.
     *
     * @param entities must not be {@literal null}. Must not contain {@literal null} elements.
     * @throws IllegalArgumentException in case the given {@literal entities} or one of its entities is {@literal null}.
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void deleteAll(Iterable<? extends Role> entities) {
        roleDAO.deleteAll(entities);
    }

    /**
     * Deletes all entities managed by the repository.
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void deleteAll() {
        roleDAO.deleteAll();
    }

    /**
     * Saves a given entity. Use the returned instance for further operations as the save operation might have changed the
     * entity instance completely.
     *
     * @param entity must not be {@literal null}.
     * @return the saved entity; will never be {@literal null}.
     * @throws IllegalArgumentException in case the given {@literal entity} is {@literal null}.
     */
    @Override
    @Modifying(flushAutomatically = true)
    public <S extends Role> S save(S entity) {
        return roleDAO.save(entity);
    }

    @Override
    @Modifying(flushAutomatically = true)
    public <S extends Role> List<S> saveAll(Iterable<S> entities) {
        return roleDAO.saveAll(entities);
    }

    /**
     * Retrieves an entity by its id.
     *
     * @param id must not be {@literal null}.
     * @return the entity with the given id or {@literal Optional#empty()} if none found.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     */
    @Override
    public Optional<Role> findById(ID id) {
        return Optional.empty();
    }

    /**
     * Returns whether an entity with the given id exists.
     *
     * @param id must not be {@literal null}.
     * @return {@literal true} if an entity with the given id exists, {@literal false} otherwise.
     * @throws IllegalArgumentException if {@literal id} is {@literal null}.
     */
    @Override
    public boolean existsById(ID id) {
        return roleDAO.existsById(id);
    }

    /**
     * Flushes all pending changes to the database.
     */
    @Override
    public void flush() {
        roleDAO.flush();
    }

    /**
     * Saves an entity and flushes changes instantly.
     *
     * @param entity
     * @return the saved entity
     */
    @Override
    @Modifying(flushAutomatically = true)
    public <S extends Role> S saveAndFlush(S entity) {
        return roleDAO.saveAndFlush(entity);
    }

    /**
     * Deletes the given entities in a batch which means it will create a single {@link Query}. Assume that we will clear
     * the {@link EntityManager} after the call.
     *
     * @param entities
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void deleteInBatch(Iterable<Role> entities) {
        roleDAO.deleteInBatch(entities);
    }

    /**
     * Deletes all entities in a batch call.
     */
    @Override
    @Modifying(flushAutomatically = true)
    public void deleteAllInBatch() {
        roleDAO.deleteAllInBatch();
    }

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
    @Override
    public Role getOne(ID id) {
        return roleDAO.getOne(id);
    }

    /**
     * Returns a single entity matching the given {@link Example} or {@literal null} if none was found.
     *
     * @param example must not be {@literal null}.
     * @return a single entity matching the given {@link Example} or {@link Optional#empty()} if none was found.
     * @throws IncorrectResultSizeDataAccessException if the Example yields more than one result.
     */
    @Override
    public <S extends Role> Optional<S> findOne(Example<S> example) {
        return roleDAO.findOne(example);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example) {
        return findAll(example);
    }

    @Override
    public <S extends Role> List<S> findAll(Example<S> example, Sort sort) {
        return roleDAO.findAll(example, sort);
    }

    /**
     * Returns a {@link Page} of entities matching the given {@link Example}. In case no match could be found, an empty
     * {@link Page} is returned.
     *
     * @param example  must not be {@literal null}.
     * @param pageable can be {@literal null}.
     * @return a {@link Page} of entities matching the given {@link Example}.
     */
    @Override
    public <S extends Role> Page<S> findAll(Example<S> example, Pageable pageable) {
        return roleDAO.findAll(example, pageable);
    }

    /**
     * Returns the number of instances matching the given {@link Example}.
     *
     * @param example the {@link Example} to count instances for. Must not be {@literal null}.
     * @return the number of instances matching the {@link Example}.
     */
    @Override
    public <S extends Role> long count(Example<S> example) {
        return roleDAO.count(example);
    }

    /**
     * Checks whether the data store contains elements that match the given {@link Example}.
     *
     * @param example the {@link Example} to use for the existence check. Must not be {@literal null}.
     * @return {@literal true} if the data store contains elements that match the given {@link Example}.
     */
    @Override
    public <S extends Role> boolean exists(Example<S> example) {
        return roleDAO.exists(example);
    }
}
