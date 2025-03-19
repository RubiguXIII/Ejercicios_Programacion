import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashSet;

public class MainParte2 {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2015\\Day3\\src\\input.txt");
        String linea;

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            linea = leer.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        HashSet<String> registroCasas = new HashSet<>();

        int[] santa = {0, 0};
        int[] roboSanta = {0, 0};

        //Casa Inicial
        registroCasas.add("0,0");

        //Procesar movimientos
        for (int i = 0; i < linea.length(); i++) {
            int[] actual = (i % 2 == 0) ? santa : roboSanta; // Alternar entre Santa y Robo-Santa
            char direccion = linea.charAt(i);

            switch (direccion) {
                case '^': actual[1]++; break;
                case 'v': actual[1]--; break;
                case '>': actual[0]++; break;
                case '<': actual[0]--; break;
            }

            //Registrar casa
            String coordenada = actual[0] + "," + actual[1];
            registroCasas.add(coordenada);
        }

        System.out.println("Número total de casas visitadas: " + registroCasas.size());
    }
}
