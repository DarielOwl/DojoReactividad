import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import sofka.correo.Correo;

import java.util.ArrayList;
import java.util.List;
import Reactividad.Operadores;

import static Reactividad.Operadores.*;


public class Main {

    public static void main(String[] args) {
        //Creamos los 30 correos
        List<Correo> correos = new ArrayList<Correo>();

        correos.add(new Correo("darieldesosagmail.com", "gmail",true));
        correos.add(new Correo("darieldesosa1@gmail.com", "gmail",true));
        correos.add(new Correo("martin1@hotmail.com", "hotmail",true));
        correos.add(new Correo("martin2@hotmail.com", "hotmail",true));
        correos.add(new Correo("martin3@hotmail.com", "hotmail",true));
        correos.add(new Correo("pepe1@outlook.com", "outlook",true));
        correos.add(new Correo("pepe2@outlook.com", "outlook",true));
        correos.add(new Correo("pepe3@outlook.com", "outlook",true));
        correos.add(new Correo("Pedrooutlookcom", "outlook",true));
        correos.add(new Correo("Pedro@yahoo.com", "yahoo",true));
        correos.add(new Correo("Fernando@gmail.com", "gmail",true));
        correos.add(new Correo("Pedro12@outlook.com", "outlook",true));
        correos.add(new Correo("AnaMaria5@yahoo.com", "yahoo",true));
        correos.add(new Correo("PabloIng@gmail.com", "gmail",true));
        correos.add(new Correo("Peon578@youtlook.com", "outlook",true));
        correos.add(new Correo("Laurta58@yahoo.com", "yahoo",true));
        correos.add(new Correo("MrStark@yahoo.com", "yahoo",true));
        correos.add(new Correo("ClarkKent1938@gmail.com", "gmail",true));
        correos.add(new Correo("Bosniac@yahoo.com", "yahoo",true));
        correos.add(new Correo("Ocampe123@hotmail.com", "hotmail",true));
        correos.add(new Correo("Pedro5698@yaho.com", "yahoo",true));
        correos.add(new Correo("Pedro@yahoo.com", "yahoo",true));
        correos.add(new Correo("Marijuan@outlook.com", "outlook",true));
        correos.add(new Correo("Emperador@gmail.com", "gmail",true));
        correos.add(new Correo("Pedro@yahoo.com", "yahoo",true));
        correos.add(new Correo("AnaMaria5@yahoo.com", "yahoo",true));
        correos.add(new Correo("Pedro@gmail.com", "gmail",true));
        correos.add(new Correo("Laurta58@yahoo.com", "yahoo",true));
        correos.add(new Correo("Pedro@yahoo.com", "yahoo",true));


        /*------------Ejercicio 1------------*/

        //Flux de los correos
        Flux<Correo> FluxCorreo = flux(correos);

        //a) Distinct: para ver si hay correo repetidos, si hay correos repetidos eliminarlos
        Flux<Correo> CorreosDistintos = correosDistintos(FluxCorreo);
        //System.out.println("\nCorreos Distintos:");
        //CorreosDistintos.subscribe(c -> System.out.print(c.toString()));


        //b) Filtro: para saber si hay correos con dominio gmail, hotmail y outlook.
        Flux<Correo> CorreosFiltrados = correosFiltrados(FluxCorreo);
        //System.out.println("\nCorreos Filtrados:");
        //CorreosFiltrados.subscribe(c -> System.out.print(c.toString()));

        //c) Map: para saber si todos los correos cumple con todas las condiciones (Que cuente con el @ y el dominio)
        Flux<Correo> CorreosVerificados = correoVerificar(FluxCorreo);
        //System.out.println("\nCorreos Verificados:");
        //CorreosVerificados.subscribe(c -> System.out.println(c.toString()));

        //d) Saber la cantidad de correos que hay, sin usar un ciclo
        Mono<Long> CorreoTotal = cantidadCorreos(FluxCorreo);
        //System.out.println("\nCorreos en Total:");
        //CorreoTotal.subscribe(c -> System.out.println(c.toString()));

        //e) Saber la cantidad de correos gmail, hotmail y outlook sin usar un ciclo

        //Cantidad de los correos de Outlook
        Mono<Long> CorreoCantidadOutlook = cantidadCorreosOutlook(FluxCorreo);
        //System.out.println("\nCorreos Outlook:");
        //CorreoCantidadOutlook.subscribe(c -> System.out.println(c.toString()));

        //Cantidad de los correos de Hotmail
        Mono<Long> CorreoCantidadHotmail = cantidadCorreosHotmail(FluxCorreo);
        //System.out.println("\nCorreos Hotmail:");
        //CorreoCantidadHotmail.subscribe(c -> System.out.println(c.toString()));

        //Cantidad de los correos de Gmail
        Mono<Long> CorreoCantidadGmail = cantidadCorreosGmail(FluxCorreo);
        //System.out.println("\nCorreos Gmail:");
        //CorreoCantidadGmail.subscribe(c -> System.out.println(c.toString()));

        // f) Determinar si se envió un correo o no a cada uno de ellos
        // si se le envió cambiar el estado en la lista
        Flux<Correo> CorreosEnviados = correoEnviar(FluxCorreo);
        System.out.println("\nCorreos Enviados:");
        CorreosEnviados.subscribe(c -> System.out.println(c.toString()));


    }


}
