import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2017\\Day2\\src\\input.txt");

        String linea;
        String[] lineaPartes;
        int diferencia = 0;

        try (BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            while ((linea = leer.readLine()) != null) {
                lineaPartes = linea.trim().split("\\s+");

                ArrayList<Integer> numeros = new ArrayList<>();
                for (String parte : lineaPartes) {
                    numeros.add(Integer.parseInt(parte));
                }
                Collections.sort(numeros);

                // 1º Parte
                // diferencia += Math.abs(numeros.get(0) - numeros.get(numeros.size() - 1));

                // 2º Parte
                for (int i = 0; i < numeros.size(); i++) {
                    for (int j = i + 1; j < numeros.size(); j++) {
                        int mayor = Math.max(numeros.get(i), numeros.get(j));
                        int menor = Math.min(numeros.get(i), numeros.get(j));

                        if (mayor % menor == 0) {
                            diferencia += mayor / menor;
                            break; //Salimos del bucle interno al encontrar un par válido
                        }
                    }
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Diferencia Total: " + diferencia);
    }
}
