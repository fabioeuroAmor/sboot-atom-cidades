package br.com.elo.controller.v1;


import br.com.elo.dto.CidadeDto;
import br.com.elo.json.Response;
import br.com.elo.servece.CidadeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1/cidades")
public class CidadeV1Controller {

    //@Autowired
    //private CidadeService cidadeService;

    private final CidadeService cidadeService;

    @PostMapping()
    public ResponseEntity<Response> inserirCidade(@RequestParam(value = "dcTemperatura", required = true) Double dcTemperatura, @RequestParam(value = "estado", required = true) String estado,
                                                  @RequestParam(value = "dcNome", required = true) String dcNome) {
        Response response = new Response();
        CidadeDto cidadeDto = null;

        try {
            cidadeDto = new CidadeDto();
            cidadeDto.setDcTemperatura(dcTemperatura);
            cidadeDto.setEstado(estado);
            cidadeDto.setDcNome(dcNome);
            response.setModeloRetorno(cidadeService.inserirCidade(cidadeDto));
            response.setMensagensRetorno("inserção realizada com sucesso!");

        } catch (Exception e) {
            log.error("Erro ao cosumir o servico: " + e.getMessage());
            response.setModeloRetorno(e.getMessage());
            return (ResponseEntity<Response>) ResponseEntity.status(500);

        }
        return  ResponseEntity.ok(response);
    }


}
