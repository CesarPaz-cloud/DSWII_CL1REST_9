package pe.edu.cibertec.DSWII_CL1REST_9.service;

import org.springframework.stereotype.Service;
import pe.edu.cibertec.DSWII_CL1REST_9.model.MensajeResponse;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

    public MensajeResponse sacarDNI(Integer añonacimiento){
        LocalDate hoy = LocalDate.now();
        Integer añoactual = hoy.getYear();
        Integer edad = añoactual-añonacimiento;
        String mensaje;
        if (edad >= 18) {
            mensaje = "Necesita sacar su DNI";
        }
        else {
            mensaje = "No necesita sacar su DNI";
        }
        return MensajeResponse.builder()
                .resultado(mensaje).build();
    }

    public MensajeResponse obtenerNumerosPares(){
        List<Integer> numerosPares = new ArrayList<>();
        for (int i = 20; i >= 10; i--){
            if(i % 2 == 0){
                numerosPares.add(i);
            }
        }
        return MensajeResponse.builder().resultado("Numeros Pares: "+numerosPares).build();
    }

    public MensajeResponse obtenerTotalPagar(int cantidad, Double precio){
        Double valor = cantidad * precio;
        Double totalpagar;
        if(valor > 200) {
            totalpagar = valor * 0.2;
        } else {
            totalpagar = valor;
        }
        return MensajeResponse.builder().resultado("El total a pagar es: "+totalpagar).build();
    }





}