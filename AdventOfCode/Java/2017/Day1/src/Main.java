import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2017\\Day1\\src\\input.txt");

        int suma = 0;
        String linea;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))) {
            linea = leer.readLine();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        int saltos = linea.length()/2;
        int anterior = Character.getNumericValue(linea.charAt(0));
        for (int i = 1; i < linea.length(); i++) {
            int actual = Character.getNumericValue(linea.charAt(i));

            if (actual == anterior) {
                suma += actual;
            }
            anterior = actual;
        }

        if (Character.getNumericValue(linea.charAt(0)) == Character.getNumericValue(linea.charAt(linea.length() - 1))) {
            suma += Character.getNumericValue(linea.charAt(0));
        }

        System.out.println("El resultado de la suma es: " + suma);
    }
}
