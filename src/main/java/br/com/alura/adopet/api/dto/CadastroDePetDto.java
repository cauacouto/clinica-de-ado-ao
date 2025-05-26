package br.com.alura.adopet.api.dto;

import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.model.TipoPet;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CadastroDePetDto(@NotNull Long id, @NotBlank String nome , @NotBlank String raca, @NotBlank Integer idade, Abrigo abrigo,
                               TipoPet tipo, @NotBlank String cor, @NotNull Float peso) {

}
