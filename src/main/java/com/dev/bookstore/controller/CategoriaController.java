package com.dev.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.bookstore.domain.dto.CategoriaDTO;
import com.dev.bookstore.domain.entity.Categoria;
import com.dev.bookstore.domain.vo.CategoriaVO;
import com.dev.bookstore.serveci.CategoriaService;

import jakarta.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/categorias")
public class CategoriaController {

	@Autowired
	private CategoriaService categoriaService;

	@PostMapping
	public ResponseEntity<CategoriaDTO> create(@Valid @RequestBody final CategoriaVO vo) {
		CategoriaDTO create = categoriaService.create(vo);
		return ResponseEntity.ok().body(create);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoriaDTO> update(@PathVariable final Long id, @Valid @RequestBody final CategoriaVO vo) {
		CategoriaDTO update = categoriaService.update(id, vo);
		return ResponseEntity.ok().body(update);
	}

	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll() {
		List<CategoriaDTO> cat = categoriaService.findAll();
		return ResponseEntity.ok().body(cat);

	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Categoria> findById(@PathVariable Long id) {
		Categoria cat = categoriaService.findById(id);
		return ResponseEntity.ok().body(cat);

	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable final Long id) {
		categoriaService.delete(id);
		return ResponseEntity.noContent().build();

	}

}
