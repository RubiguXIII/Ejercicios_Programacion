import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Main {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        String claveSecreta = "iwrupvqb";
        int numero = 0;

        MessageDigest md = MessageDigest.getInstance("MD5");//Con este objeto podemos hacer hashesh

        //Un bucle para ir variando el numero e ir comprobando si se cumple la condición de que el hash empieza
        //con 00000
        while (true){
            String claveNumero = claveSecreta + numero;

            //Necesitamos operar con bytes
            byte[] bytesHash = md.digest(claveNumero.getBytes());//md.digest() nos da un array de bytes

            //Con este array ahora lo tenemos que pasar a hexadecimal
            StringBuilder hexHash = new StringBuilder();
            for (byte b : bytesHash){
                hexHash.append(String.format("%02x", b));
            }

            //Hay que tener en cuenta aquí, que debemos convertir el stringbuilder en un string, para tener los métodos
            //relativos a este tipo de datos
            if (hexHash.toString().startsWith("000000")){//5 ceros Parte1º - 6 ceros Parte2º
                System.out.println("El número más pequeño que genera un hash con un comienzo en 00000 es: " + numero);
                break;
            }

            //Si no se cumple la condición
            numero++;//Número aumenta
            md.reset();
        }
    }
}
