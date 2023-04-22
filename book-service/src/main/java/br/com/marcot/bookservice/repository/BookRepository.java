package br.com.marcot.bookservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.marcot.bookservice.model.Book;

public interface BookRepository extends JpaRepository<Book,Long>{

}
