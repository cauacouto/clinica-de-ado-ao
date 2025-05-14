package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;

public record DadosDetalhamentoPet(Long id, String nome, String raca, Integer idade) {

    public DadosDetalhamentoPet(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
