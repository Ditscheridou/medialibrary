package de.jds.model.repositories;

import de.jds.model.domain.Audio;

import java.util.Set;

public class FileSystemAudioRepository implements CrudRepository<Audio, String> {

	@Override
	public void save(Audio entity) {

	}

	@Override
	public void delete(Audio entity) {

	}

	@Override
	public void deleteById(String s) {

	}

	@Override
	public Audio findById(String s) {
		return null;
	}

	@Override
	public Set<Audio> findAll() {
		return null;
	}
}
