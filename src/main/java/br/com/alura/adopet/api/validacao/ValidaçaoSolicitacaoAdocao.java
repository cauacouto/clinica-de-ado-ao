package br.com.alura.adopet.api.validacao;

import br.com.alura.adopet.api.dto.SolicitacaoDto;

public interface ValidaçaoSolicitacaoAdocao {

    void validar(SolicitacaoDto dto);
}
