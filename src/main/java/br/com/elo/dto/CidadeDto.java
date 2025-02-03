package br.com.elo.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CidadeDto {

    Integer idCidade;

    Double dcTemperatura;

    String estado;

    String dcNome;

}
