package io.lrsystem.savvywallet.api.security;

import io.lrsystem.savvywallet.api.model.Usuario;
import io.lrsystem.savvywallet.api.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class AppUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<Usuario> usuarioOptional = usuarioRepository.findByEmail(email);
        Usuario usuario = usuarioOptional.orElseThrow(
                () -> new UsernameNotFoundException("Usuario ou senha incorreto!"));
        return new UsuarioSistema(usuario, getPermissoes(usuario));
    }

    private Collection<? extends GrantedAuthority> getPermissoes(Usuario usuario) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        usuario.getPermissoes().forEach(p -> authorities.add(
                new SimpleGrantedAuthority(p.getDescricao().toUpperCase())));
        return authorities;
    }
}
