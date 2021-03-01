package br.com.projetoIntegrador.projetoEcoIntegrador.controller;

import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import br.com.projetoIntegrador.projetoEcoIntegrador.Repository.UsuarioRepository;
import br.com.projetoIntegrador.projetoEcoIntegrador.model.Usuario;


@RestController
@RequestMapping("/usuario")
@CrossOrigin("*")
public class UsuarioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<Usuario>> getAll() {
		return ResponseEntity.ok(usuarioRepository.findAll());
	}
	
	@GetMapping("/{idUsuario}")
	public ResponseEntity<Usuario> getByUsuario(@PathVariable long idUsuario) {
		return usuarioRepository.findById(idUsuario)
				.map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
	}
	
	@GetMapping("/usuario/{nomeUsuario}")
	public ResponseEntity<List<Usuario>> getByNomeUsuario(@PathVariable String nomeUsuario) {
		return ResponseEntity.ok(usuarioRepository.findAllByNomeUsuarioContainingIgnoreCase(nomeUsuario));
	}
	
	@PostMapping
	public ResponseEntity<Usuario> post(@Valid @RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioRepository.save(usuario));
	}                                 //Obs.Status que volta no postman EX:200 ok
	
	@PutMapping  //Obs,execulta um serviço nesse caso put(colocar)
	public ResponseEntity<Usuario> put(@RequestBody Usuario usuario) {
		return ResponseEntity.status(HttpStatus.OK).body(usuarioRepository.save(usuario));
	}
		
	@DeleteMapping("/{idUsuario}")
	public void delete(@PathVariable long idUsuario) {
		usuarioRepository.deleteById(idUsuario);
	}
	
}