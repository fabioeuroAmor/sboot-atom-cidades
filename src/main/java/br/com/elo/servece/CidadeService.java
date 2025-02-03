package br.com.elo.servece;

import br.com.elo.domain.Cidade;
import br.com.elo.dto.CidadeDto;
import br.com.elo.exception.BDException;
import br.com.elo.repository.CidadeRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class CidadeService {

    //@Autowired
    //private  CidadeRepository cidadeRepository;

    private final CidadeRepository cidadeRepository;

    public CidadeDto inserirCidade(CidadeDto cidadeDto){
        CidadeDto cidadePers = null;
       try {

           ModelMapper modelMapper = new ModelMapper();
           Cidade cidade   = modelMapper.map(cidadeDto, Cidade.class);
           cidade = cidadeRepository.save(cidade);
           cidadePers = modelMapper.map(cidade, CidadeDto.class);

       }catch (Exception e){
           log.error("Erro na camada de servico ao realizar a insercao no banco de dados: " + e.getMessage());
           throw new BDException(e.getMessage());
       }
      return cidadePers;
    }


}
