package br.com.smartparker.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import br.com.smartparker.model.Moto;
import br.com.smartparker.model.MotoFilter;
import br.com.smartparker.repository.MotoRepository;
import br.com.smartparker.specification.MotoSpecification;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/moto")
@Slf4j
public class MotoController {

    @Autowired
    private MotoRepository repository;

    // 1.Read
    @GetMapping
    public Page<Moto> index(MotoFilter filter,
            @PageableDefault(size = 5, sort = "nome") Pageable pageable) {
        return repository.findAll(MotoSpecification.withFilters(filter), pageable);
    }

    // 1.1 Read {id}
    @GetMapping("{id}")
    public Moto get(@PathVariable Long id) {
        return getMoto(id);
    }

    // 2.Create
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Moto create(@RequestBody @Valid Moto moto) {
        return repository.save(moto);
    }

    // 3.Update
    @PutMapping("{id}")
    public Moto update(@PathVariable Long id, @RequestBody @Valid Moto moto) {
        return repository.findById(id)
                .map(existing -> {
                    existing.setNome(moto.getNome());
                    existing.setFabricante(moto.getFabricante());
                    existing.setCilindrada(moto.getCilindrada());
                    existing.setPlaca(moto.getPlaca());
                    existing.setStatus(moto.getStatus());
                    existing.setQrCode(moto.getQrCode());
                    return repository.save(existing);
                })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Moto não encontrada."));
    }

    // 4.Delete
    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable Long id) {
        repository.deleteById(id);
    }

    private Moto getMoto(Long id) {
        return repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        "Moto de id " + id + " não encontrada!"));
    }
}
