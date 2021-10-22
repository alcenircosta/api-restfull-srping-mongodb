package com.example.workshopmongo.services;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.workshopmongo.domain.Post;
import com.example.workshopmongo.repositoriy.PostRepository;
import com.example.workshopmongo.servicesexception.ObjectNotFoundException;

@Service
public class PostService {
	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}

	public List<Post> findByTitle(String txt) {
		// method with @QueryMethods
		// return repository.findByTitleContainingIgnoreCase(txt);

		// Method with @Query
		return repository.searchTitle(txt);
	}

	public List<Post> fullSearch(String txt, Date minDate, Date maxDate) {
		maxDate = new Date(maxDate.getTime() + 24 * 60 * 60 * 1000);
		return repository.fullSearch(txt, minDate, maxDate);
	}
}
