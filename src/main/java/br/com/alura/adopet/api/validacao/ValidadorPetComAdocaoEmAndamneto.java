package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.SolicitacaoDto;
import br.com.alura.adopet.api.model.StatusAdocao;
import br.com.alura.adopet.api.repository.AdocaoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class ValidadorPetComAdocaoEmAndamneto implements ValidaçaoSolicitacaoAdocao {

    @Autowired
    private AdocaoRepository adocaoRepository;


    public void validar(SolicitacaoDto dto) {

        boolean PetTemAdocaoEmAndamneto = adocaoRepository.existsByPetIdAndStatus(dto.idPet(),
                StatusAdocao.AGUARDANDO_AVALIACAO);
        if (PetTemAdocaoEmAndamneto) {
                throw new ValidationException("Pet já está aguardando avaliação para ser adotado!");
            }
        }
    }

