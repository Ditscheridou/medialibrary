package de.jds.model.services;

import de.jds.model.domain.Video;
import de.jds.model.repositories.CrudRepository;
import de.jds.model.repositories.FileSystemVideoRepository;
import de.jds.model.repositories.MetadataRepository;
import de.jds.model.repositories.TmdbMetadataRepository;
import info.movito.themoviedbapi.model.MovieDb;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import static java.util.stream.Collectors.toSet;

public class VideoService implements MediaService<Video> {

	private final CrudRepository<Video, String> videoRepository;
	private final MetadataRepository<Video, MovieDb> metadataService;

	public VideoService() {
		this.videoRepository = new FileSystemVideoRepository();
		metadataService = new TmdbMetadataRepository();
	}

	@Override
	public void addNew(Video media) {
		videoRepository.save(media);
	}

	@Override
	public void remove(Video media) {
		videoRepository.delete(media);
	}

	@Override
	public Set<CompletableFuture<Video>> getAll() {
		return videoRepository.findAll().stream().map(video -> CompletableFuture.supplyAsync(() -> {
			MovieDb movieDb = metadataService.getMetadata(video);
			video.setMetadata(movieDb);
			return video;
		})).collect(toSet());
	}
}
