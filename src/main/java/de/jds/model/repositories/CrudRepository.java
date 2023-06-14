package de.jds.model.repositories;

import java.util.Set;

public interface CrudRepository<T, ID> {

	void save(T entity);

	void delete(T entity);

	void deleteById(ID id);

	T findById(ID id);

	Set<T> findAll();
}
