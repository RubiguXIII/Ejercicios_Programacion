import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;

public class Main {
    static String linea;
    static HashMap<String, Integer> registroCasas = new HashMap<String, Integer>();//<Coordenada, Contador de Regalos>


    public static void main(String[] args) {
        registroCasas.put("0,0", 1);//LA CASA DE INICIO PARTE YA CON UN REGALO

        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2015\\Day3\\src\\input.txt");

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            linea = leer.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        char input;
        int[] coordenada = {0, 0};//Esto varía con los movimientos
        String coordenadaActual;//Esto es fijo para implementar en la clave del Hash

        //Movimientos en la línea
        for (int i = 0; i < linea.length(); i++) {
            input = linea.charAt(i);

            switch (input){
                case '^':
                    coordenada[0]++;
                    break;
                case '>':
                    coordenada[1]++;
                    break;
                case 'v':
                    coordenada[0]--;
                    break;
                case '<':
                    coordenada[1]--;
                    break;
            }

            //Registrar casas
            coordenadaActual = String.valueOf(coordenada[0]) + "," + String.valueOf(coordenada[1]);

            if (registroCasas.containsKey(coordenadaActual)){
                registroCasas.put(coordenadaActual, registroCasas.get(coordenadaActual) + 1);
            }else {
                registroCasas.put(coordenadaActual, 1);
            }
            //System.out.println("Coordenada: " + coordenadaActual);
        }

        //Como el hashmap registra todas las casas con al menos un regalo, ponemos su tamaño y ya
        System.out.println("NºCasas con al menos 1º Regalo: " + registroCasas.size());
    }
}
