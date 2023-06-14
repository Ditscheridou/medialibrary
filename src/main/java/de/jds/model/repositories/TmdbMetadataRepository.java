package de.jds.model.repositories;

import de.jds.model.domain.Video;
import info.movito.themoviedbapi.TmdbApi;
import info.movito.themoviedbapi.model.MovieDb;

public class TmdbMetadataRepository implements MetadataRepository<Video, MovieDb> {

	private final TmdbApi api = new TmdbApi("4e9e55ddf1f707728347b22756f743d9");

	@Override
	public MovieDb getMetadata(Video media) {
		return api.getSearch().searchMovie(media.name(), 0, "de", false, 0).getResults().get(0);
	}
}
