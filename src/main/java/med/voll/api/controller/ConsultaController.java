package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.consulta.DadosAgendamentoConsulta;
import med.voll.api.consulta.DadosDetalhamentoConsulta;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;


@RestController
@RequestMapping("consulta")
public class ConsultaController {

    @GetMapping
    @Transactional
    public ResponseEntity agendar(@RequestBody @Valid DadosAgendamentoConsulta dados){

        return ResponseEntity.ok(new DadosDetalhamentoConsulta(null, null,null,null));

    }
}
