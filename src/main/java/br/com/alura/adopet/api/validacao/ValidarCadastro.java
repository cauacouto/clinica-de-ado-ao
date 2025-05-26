package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.CadastraDto;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidarCadastro {
    @Autowired
    private AbrigoRepository repository;

    private boolean nomeJaCadastrado;
    private boolean telefoneJaCadastrado;
    private boolean emailJaCadastrado;




    public void validarCadastro(CadastraDto dto) {
        if (nomeJaCadastrado || telefoneJaCadastrado || emailJaCadastrado) {
            throw new IllegalArgumentException("Nome, telefone ou email já cadastrados");
        }
    }
}
