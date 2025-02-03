package br.com.elo.service;

import br.com.elo.domain.Cidade;
import br.com.elo.dto.CidadeDto;
import br.com.elo.exception.BDException;
import br.com.elo.repository.CidadeRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Slf4j
@RequiredArgsConstructor
@Service
public class CidadeService {

    //@Autowired
    //private  CidadeRepository cidadeRepository;

    private final CidadeRepository cidadeRepository;

    private  final ModelMapper modelMapper;

    private final RestTemplate restTemplate;

    public CidadeDto inserirCidade(CidadeDto cidadeDto){
        CidadeDto cidadePers = null;
       try {

           Cidade cidade   = modelMapper.map(cidadeDto, Cidade.class);
           cidade = cidadeRepository.save(cidade);
           cidadePers = modelMapper.map(cidade, CidadeDto.class);

       }catch (Exception e){
           log.error("Erro na camada de servico ao realizar a insercao no banco de dados: " + e.getMessage());
           throw new BDException(e.getMessage());
       }
      return cidadePers;
    }

    public CidadeDto buscarPorNome(String dcNome){
        CidadeDto cidadePers = null;
        try {
            Cidade cidadeBd = cidadeRepository.search(dcNome);
            cidadePers = modelMapper.map(cidadeBd, CidadeDto.class);
        }catch (Exception e){
            log.error("Erro na camada de servico ao buscar cidade por nome: " + e.getMessage());
            throw new BDException(e.getMessage());
        }

        return cidadePers;
    }

    public Integer deletePorId(Integer id){

        try {
         cidadeRepository.deleteById(id);
        }catch (Exception e){
            log.error("Erro na camada de servico ao buscar cidade por nome: " + e.getMessage());
            throw new BDException(e.getMessage());
        }
         return id;
    }


}
