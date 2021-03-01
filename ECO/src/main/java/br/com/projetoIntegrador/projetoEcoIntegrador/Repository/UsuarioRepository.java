package br.com.projetoIntegrador.projetoEcoIntegrador.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.projetoIntegrador.projetoEcoIntegrador.model.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long>{
	
	    //para FindAllbynameUsuario encontrar todos nomes de nomeUsuario, uma infomaçao na list(lista)
        public List<Usuario> findAllByNomeUsuarioContainingIgnoreCase(String nomeUsuario);
		
}
