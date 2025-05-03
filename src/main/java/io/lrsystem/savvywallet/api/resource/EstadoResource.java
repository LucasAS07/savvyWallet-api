package io.lrsystem.savvywallet.api.resource;

import io.lrsystem.savvywallet.api.model.Estado;
import io.lrsystem.savvywallet.api.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/estado")
public class EstadoResource {

    @Autowired
    private EstadoRepository estadoRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
    public List<Estado> listar(){
        return estadoRepository.findAll();
    }

}
