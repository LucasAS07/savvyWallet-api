package io.lrsystem.savvywallet.api.resource;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import io.lrsystem.savvywallet.api.event.RecursoCriadoEvent;
import io.lrsystem.savvywallet.api.model.Categoria;
import io.lrsystem.savvywallet.api.repository.CategoriaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categoria")
public class CategoriaResource {

    @Autowired
    private CategoriaRepository categoriaRepository;

	@Autowired
	private ApplicationEventPublisher publisher;
    
    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')")
    public List<Categoria> listar() {
        return categoriaRepository.findAll();
    }
    	
	@PostMapping
    @PreAuthorize("hasAuthority('ROLE_CADASTRAR_CATEGORIA')")
	public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		
		publisher.publishEvent(new RecursoCriadoEvent(this, response, categoriaSalva.getCodigo()));

		return ResponseEntity.status(HttpStatus.CREATED).body(categoriaSalva);
	}

    @GetMapping("/{codigo}")
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_CATEGORIA')")
    public ResponseEntity<Categoria> buscarPeloCodigo(@PathVariable Long codigo) {
        Optional<Categoria> categoria = categoriaRepository.findById(codigo);

        return categoria.isPresent() ? ResponseEntity.ok(categoria.get()) : ResponseEntity.notFound().build();
    }
    
}
