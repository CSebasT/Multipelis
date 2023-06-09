package modelo.logica;

import java.util.Calendar;


public class MultipelisEjecutable {

    public static void main(String[] args) throws Exception {
        Cliente cliente01 = new Cliente("1752995819","Sebastian", "Tufino","Llano Chico","0987654321","sebas@gmail.com");
        Cliente cliente02 = new Cliente("1726547209","Ismael","Toaquiza","Los Pedernales S32 y Ambato", "0912345678","ismael@gmail.com");

        Calendar calendar01 = Calendar.getInstance();
        calendar01.set(Calendar.YEAR, 2023);
        calendar01.set(Calendar.MONTH, 05);
        calendar01.set(Calendar.DAY_OF_MONTH, 26);

        Calendar calendar02 = Calendar.getInstance();
        calendar02.set(Calendar.YEAR, 2023);
        calendar02.set(Calendar.MONTH, 05);
        calendar02.set(Calendar.DAY_OF_MONTH, 26);


        Genero genero01 = new Genero(1L, calendar01, "Terror", 0.2);
        Genero genero02 = new Genero(2L,calendar02,"Accion", 0.2);

        Pelicula pelicula01 = new Pelicula("0001", "Mi película 1", 50, 2022, "Una película emocionante 1", genero01);
        Pelicula pelicula02 = new Pelicula("0002", "Mi pelicula 2", 50, 2022, "Una película emocionante 2", genero02);

        Ejemplar ejemplar01 = new Ejemplar("0001", true, pelicula01, 2.0, 0, false );
        Ejemplar ejemplar02 = new Ejemplar("0002", true, pelicula02, 2.0, 0, false);

        Alquiler alquiler01 = new Alquiler(cliente01, ejemplar01, 10);
        Alquiler alquiler02 = new Alquiler(cliente02, ejemplar02, 10);


        System.out.println("Cliente 01: \n" + cliente01);

        System.out.println("Cliente 02: \n" + cliente02);

        System.out.println("Alquiler 01: \n" + alquiler01);
        System.out.println("Ejemplar 01: \n" + ejemplar01);



        System.out.println("Alquiler 02: \n" + alquiler02);
        System.out.println("Ejemplar 02: \n" + ejemplar02);

        alquiler01.finalizar(4);
        alquiler02.finalizar(3);
        System.out.println("\nDevolucion realizada:\n");


        System.out.println("Alquiler 01: \n" + alquiler01);
        System.out.println("Ejemplar 01: \n" + ejemplar01);

        System.out.println("Alquiler 02: \n" + alquiler02);
        System.out.println("Ejemplar 02: \n" + ejemplar02);


    }

}
