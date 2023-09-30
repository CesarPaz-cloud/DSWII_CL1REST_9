package pe.edu.cibertec.DSWII_CL1REST_9.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1REST_9.model.MensajeResponse;

@Service
public class EjerciciosService {

    public MensajeResponse pagoEstacionamiento(Integer horas, Integer minutos) {
        Double precioHora = 1.500;
        Double precioPorHoras = horas * precioHora;
        Double precioPorMinutos = 0.0;
        if (minutos > 60) {
            if (minutos % 60 == 0) {
                precioPorMinutos = (minutos / 60) * precioHora;
            } else {
                precioPorMinutos = (minutos / 60) * precioHora + precioHora;
            }
        } else {
            precioPorMinutos = precioHora;
        }
        Double precioTotal = precioPorHoras + precioPorMinutos;
        return MensajeResponse.builder()
                .resultado("Precio estacionamiento: " + precioTotal)
                .build();
    }


    public MensajeResponse promedioNotas(Integer nota1,
                                         Integer nota2,
                                         Integer nota3,
                                         Integer nota4) {

        int[] notas = {nota1, nota2, nota3, nota4};
        int[] notas2 = new int[3];
        int menor = notas[0];
        int j = 0;
        for (int i = 0; i < notas.length; i++) {
            if (notas[i] < menor) menor = notas[i];
        }

        for (int i = 0; i < notas.length; i++) {
            if (notas[i] == menor) {
                continue;
            } else {
                notas2[j] = notas[i];
                j++;
            }
        }

        Double promedioNotas = notas2[0]*0.2 + notas2[1]*0.3 + notas2[2]*0.5;

        return MensajeResponse.builder()
                .resultado("Promedio Notas: " + promedioNotas)
                .build();

    }



}