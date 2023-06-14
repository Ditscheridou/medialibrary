package de.jds.model.services;

import de.jds.model.domain.Media;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public interface MediaService<T extends Media> {

	void addNew(T media);

	void remove(T media);

	Set<CompletableFuture<T>> getAll();
}
