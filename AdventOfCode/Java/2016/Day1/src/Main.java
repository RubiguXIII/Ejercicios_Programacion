import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2016\\Day1\\src\\input.txt");

        //Lo que necesitamos
        int[] coordenadas = {0,0};
        char direccion; // R - L
        int distancia; // N para las coordenadas[x,y]
        char orientacion = 'N'; // Comenzamos mirando hacia el Norte
        int bloques;

        //2ºParte
        HashSet<String> registroCoordenadas = new HashSet<>();
        registroCoordenadas.add("0,0");

        String linea;
        String[] instrucciones;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            linea = leer.readLine();
            instrucciones = linea.split(",");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        for (String instruccion : instrucciones){
            instruccion = instruccion.trim();//Le quito los espacios
            direccion = instruccion.charAt(0);
            distancia = Integer.parseInt(instruccion.substring(1));

            //Cambiar Orientaciones
            switch (orientacion){
                case 'N':
                    orientacion = (direccion == 'R') ? 'E' : 'O';
                    break;
                case 'S':
                    orientacion = (direccion == 'R') ? 'O' : 'E';
                    break;
                case 'E':
                    orientacion = (direccion == 'R') ? 'S' : 'N';
                    break;
                case 'O':
                    orientacion = (direccion == 'R') ? 'N' : 'S';
                    break;
            }

            //Aplicar las coordenadas
            for (int i = 0; i < distancia; i++) { // La comprobación de la segunda parte, la hacemos paso aumentando la distancia
                // de uno en uno, ya que sino nos podemos saltar la coordenada repetida
                switch (orientacion){
                    case 'N':
                        coordenadas[1]++;
                        break;
                    case 'S':
                        coordenadas[1]--;
                        break;
                    case 'E':
                        coordenadas[0]++;
                        break;
                    case 'O':
                        coordenadas[0]--;
                        break;
                }
                String coordenada = coordenadas[0] + "," + coordenadas[1];
                if (registroCoordenadas.contains(coordenada)){
                    bloques = Math.abs(coordenadas[0]) + Math.abs(coordenadas[1]);
                    System.out.println("La primera ubicacion que se repite es: " + coordenada);
                    System.out.println("Santa ha recorrido: " + bloques + " bloques.");
                    return;
                }
                registroCoordenadas.add(coordenada);
            }
        }

        /*bloques = Math.abs(coordenadas[0]) + Math.abs(coordenadas[1]);
        System.out.println("Coordenadas Actuales: " + coordenadas[0] + "," + coordenadas[1]);
        System.out.println("Santa ha recorrido: " + bloques + " bloques.");*/
    }
}
