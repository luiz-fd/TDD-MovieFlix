package com.devsuperior.movieflix.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.movieflix.entities.Movie;

public interface MovieRepository extends JpaRepository<Movie, Long> {
	
	//public Optional<Movie> findById(Long id);
	
	@Query("SELECT obj FROM Movie obj JOIN FETCH obj.genre "
			+ "WHERE (:genreId = 0 OR obj.genre.id IN :genreId) ORDER BY obj.title")
	public Page<Movie> searchByGenre(String genreId,Pageable pageable);

}
