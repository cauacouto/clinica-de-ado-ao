package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.SolicitacaoDto;
import br.com.alura.adopet.api.model.Pet;
import br.com.alura.adopet.api.repository.PetRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class validacaoPetAdotado implements ValidaçaoSolicitacaoAdocao {

    @Autowired
    PetRepository petRepository;

    public void validar(SolicitacaoDto dto) {
        Pet pet = petRepository.getReferenceById(dto.idPet());
        if (pet.getAdotado()){
            throw new ValidationException("Pet já foi adotado!");
        }

    }

}

