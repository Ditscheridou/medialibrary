package de.jds.model.repositories;

import de.jds.model.domain.Media;

public interface MetadataRepository<T extends Media<?>, R> {

	R getMetadata(T media);
}
