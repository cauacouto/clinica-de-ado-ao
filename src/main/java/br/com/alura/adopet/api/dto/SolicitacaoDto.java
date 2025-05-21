package br.com.alura.adopet.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record SolicitacaoDto(@NotNull Long id, @NotNull Long idPet, @NotNull Long idTuto, @NotBlank String motivo) {
}
