package Reactividad;
import sofka.correo.Correo;

import java.util.List;
import java.util.regex.*;
import java.util.stream.Collectors;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Operadores {

    public void reactor(){
        Mono.just(new Correo("darieldesosa@gmail.com", "gmail"))
                .subscribe();
    }

    public static Flux<Correo> flux(List<Correo> correos){
        return Flux.fromIterable(correos);
    }

    public static void Fluxmono(Flux<Correo> flux_correos){
        flux_correos.collectList();
    }

    //a) Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
    public static Flux<Correo> correosDistintos(Flux<Correo> FluxCorreo){
        return FluxCorreo.distinct((correo) -> correo.getNombre());
    }

    //b) Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
    public static Flux<Correo> correosFiltrados(Flux<Correo> FluxCorreo){
        return FluxCorreo.filter(correo -> correo.getTipoCorreo() == "outlook");
    }

    //c) Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
    public static Flux<Correo> correoVerificar(Flux<Correo> FluxCorreo){
        String regx = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$";
        Pattern pattern = Pattern.compile(regx);
        return FluxCorreo.map(correo -> {
            Matcher matcher = pattern.matcher(correo.getNombre());
            correo.setValido(matcher.matches());
            return correo;
        });
    }

    //d) Saber la cantidad de correos que hay, sin usar un ciclo
    public static Mono<Long> cantidadCorreos(Flux<Correo> FluxCorreo){
        return FluxCorreo.count();
    }

    //e) Saber la cantidad de correos gmail, hotmail y outlook sin usar un ciclo
    public static Mono<Long> cantidadCorreosOutlook(Flux<Correo> FluxCorreo){
        return FluxCorreo
                .filter(correo -> correo.getTipoCorreo() == "outlook")
                .count();
    }

    public static Mono<Long> cantidadCorreosHotmail(Flux<Correo> FluxCorreo){
        return FluxCorreo
                .filter(correo -> correo.getTipoCorreo() == "hotmail")
                .count();
    }

    public static Mono<Long> cantidadCorreosGmail(Flux<Correo> FluxCorreo){
        return FluxCorreo
                .filter(correo -> correo.getTipoCorreo() == "gmail")
                .count();
    }

    // f) Determinar si se envió un correo o no a cada uno de ellos
    // si se le envió cambiar el estado en la lista
    public static Flux<Correo> correoEnviar(Flux<Correo> FluxCorreo){
        return FluxCorreo.map(correo -> {
            if(correo.getEnviado()){ //si es true modificar
                correo.setEnviado(false);
            }
            return correo;
        });
    }


}
