package io.lrsystem.savvywallet.api.resource;

import io.lrsystem.savvywallet.api.model.Cidade;
import io.lrsystem.savvywallet.api.repository.CidadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cidade")
public class CidadeResource {

    @Autowired
    private CidadeRepository cidadeRepository;

    @GetMapping
    @PreAuthorize("hasAuthority('ROLE_PESQUISAR_PESSOA')")
    public List<Cidade> listar(@RequestParam Long estado){
        return cidadeRepository.findByEstadoCodigo(estado);
    }

}
