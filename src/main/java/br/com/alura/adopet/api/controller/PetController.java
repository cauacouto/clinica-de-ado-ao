package br.com.alura.adopet.api.controller;

import br.com.alura.adopet.api.dto.DadosDetalhamentoPet;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private PetRepository repository;

    @GetMapping
    public ResponseEntity<List<DadosDetalhamentoPet>> listarTodosDisponiveis() {
        List<Pet> pets = repository.findAll();
        List<DadosDetalhamentoPet> disponiveis = new ArrayList<>();
        for (Pet pet : pets) {
            if (pet.getAdotado() == false) {
                disponiveis .add(new DadosDetalhamentoPet(pet));

            }
        }
        return ResponseEntity.ok(disponiveis);
    }

}
