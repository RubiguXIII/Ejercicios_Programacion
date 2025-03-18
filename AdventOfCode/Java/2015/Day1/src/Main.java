import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    static int pisos = 0;
    static int posicion;
    static  boolean entroSotano = false;
    public static void main(String[] args) {
        //Leer el archivo
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2015\\Day1\\src\\input.txt");

        String linea;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            linea = leer.readLine();
            //System.out.println(linea);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        //Leemos caracter a caracter de la Línea y comprobamos las dos posibles opciones
        //Dentro comprobamos si ya ha entrado en el piso -1, en caso de entrar se cambia el flag y guardamos la posicion
        char caracter;
        for (int i = 0; i < linea.length(); i++) {
            caracter = linea.charAt(i);
            if (caracter == '('){
                pisos++;
                if (entroSotano == false && pisos == -1){
                    posicion = i+1;
                    entroSotano = true;
                }
            }else {
                pisos--;
                if (entroSotano == false && pisos == -1){
                    posicion = i+1;
                    entroSotano = true;
                }
            }
        }

        //Imprimimos el resultado de los pisos y la primera vez que entra al sótano
        System.out.println("Piso: " + pisos);
        System.out.println("Movimiento en el que Santa entra al Sótano: " + posicion);
    }
}
