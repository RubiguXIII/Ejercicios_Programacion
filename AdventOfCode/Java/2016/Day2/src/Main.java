import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class Main {
    public static void main(String[] args) {
        StringBuilder codigo = new StringBuilder("");
        int[] tecla = {1,1};
        int[][] teclado = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };

        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2016\\Day2\\src\\input.txt");

        String linea;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while((linea = leer.readLine()) != null){
                linea.trim();
                for (int i = 0; i < linea.length(); i++) {
                    char instruccion = linea.charAt(i);

                    switch (instruccion){
                        case 'U':
                            if (tecla[0] != 0){
                                tecla[0]--;
                            }
                            break;
                        case 'D':
                            if (tecla[0] != 2){
                                tecla[0]++;
                            }
                            break;
                        case 'R':
                            if (tecla[1] != 2){
                                tecla[1]++;
                            }
                            break;
                        case 'L':
                            if (tecla[1] != 0){
                                tecla[1]--;
                            }
                            break;
                    }
                }
                codigo.append(teclado[tecla[0]][tecla[1]]);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Codigo de Baño: " + codigo);
    }
}
