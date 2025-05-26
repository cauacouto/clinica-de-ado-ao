package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Pet;

public record PetDto(Long id, String Nome, String raca, Integer idade) {

    public PetDto(Pet pet) {
        this(pet.getId(), pet.getNome(), pet.getRaca(), pet.getIdade());
    }
}
