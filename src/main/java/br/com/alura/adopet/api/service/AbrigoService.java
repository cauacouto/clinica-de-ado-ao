package br.com.alura.adopet.api.service;

import br.com.alura.adopet.api.dto.AbrigoDto;
import br.com.alura.adopet.api.dto.CadastraDto;
import br.com.alura.adopet.api.dto.PetDto;
import br.com.alura.adopet.api.model.Abrigo;
import br.com.alura.adopet.api.repository.AbrigoRepository;
import br.com.alura.adopet.api.repository.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AbrigoService {
    @Autowired
    private AbrigoRepository abrigoRepository;

    @Autowired
    private PetRepository petRepository;

    public List<AbrigoDto> listar() {
        return abrigoRepository
                .findAll()
                .stream()
                .map(AbrigoDto::new)
                .toList();
    }


    public void cadastrar(CadastraDto dto) {
        boolean JaCadastrado = abrigoRepository.existsByNomeOrAndTelefoneOrAndEmail(dto.Nome(), dto.Telefone(), dto.Email());
        if (JaCadastrado) {
            throw new IllegalArgumentException("Abrigo já cadastrado");
        }
        abrigoRepository.save(new Abrigo(dto));
    }

    public List<PetDto> ListarPetsDoAbrigo(String idOuNome) {
        Abrigo abrigo = carregarAbrigo(idOuNome);

        return petRepository
                .findByAbrigo(abrigo)
                .stream()
                .map(PetDto::new)
                .toList();

    }

    public Abrigo carregarAbrigo(String idOuNome) {
        Optional<Abrigo> optional;
        try {
            Long id = Long.parseLong(idOuNome);
            optional = abrigoRepository.findById(id);
        } catch (NumberFormatException exception) {
            optional = abrigoRepository.findByNome(idOuNome);
        }
return optional.orElseThrow(() -> new IllegalArgumentException("Abrigo não encontrado"));
    }

}
