package med.voll.api.consulta;

import med.voll.api.endereco.Endereco;
import med.voll.api.medico.Especialidade;
import med.voll.api.medico.Medico;

import java.time.LocalDateTime;

public record DadosDetalhamentoConsulta(Long id, Long idMedico, Long idPaciente, LocalDateTime data) {

//    public DadosDetalhamentoConsulta(Consulta consulta){
//        this(consulta.getId(), consulta.getMedico(), consulta.getPaciente(), consulta.getData() );
//
//    }


}
