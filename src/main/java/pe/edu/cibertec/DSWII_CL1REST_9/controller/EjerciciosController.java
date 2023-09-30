package pe.edu.cibertec.DSWII_CL1REST_9.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.DSWII_CL1REST_9.model.MensajeResponse;
import pe.edu.cibertec.DSWII_CL1REST_9.service.EjerciciosService;

@AllArgsConstructor
@RestController
@RequestMapping(path = "api/v1/ejercicio")
public class EjerciciosController {

    private EjerciciosService ejerciciosService;

    @GetMapping("estacionamiento")
    public ResponseEntity<MensajeResponse> pagoEstacionamiento(@RequestParam Integer horas,
                                                               @RequestParam Integer minutos) {
        return new ResponseEntity<>(ejerciciosService.pagoEstacionamiento(horas, minutos), HttpStatus.OK);
    }

    @GetMapping("promedioNotas")
    public ResponseEntity<MensajeResponse> promedioNotas(@RequestParam Integer nota1,
                                                          @RequestParam Integer nota2,
                                                          @RequestParam Integer nota3,
                                                          @RequestParam Integer nota4) {
        return new ResponseEntity<>(ejerciciosService.promedioNotas(nota1, nota2, nota3, nota4), HttpStatus.OK);
    }


}
