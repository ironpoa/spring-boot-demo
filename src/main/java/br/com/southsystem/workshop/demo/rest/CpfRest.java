package br.com.southsystem.workshop.demo.rest;

import br.com.southsystem.workshop.demo.service.CpfService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/cpf")
public class CpfRest {
    private final CpfService cpfService;

    public CpfRest(CpfService cpfService) {
        this.cpfService = cpfService;
    }

    @GetMapping("/{name}")
    public ResponseEntity<Map<String, String>> findAll(@PathVariable("name") String name) {
        return cpfService.findByName(name)
            .map(cpf -> new ResponseEntity<>(cpf, HttpStatus.OK))
            .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
}
