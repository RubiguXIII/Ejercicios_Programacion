import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class MainParte2 {
    public static void main(String[] args) {
        StringBuilder codigo = new StringBuilder("");
        int[] tecla = {2,0};
        char[][] teclado = {
                {' ',' ','1',' ',' '},
                {' ','2','3','4',' '},
                {'5','6','7','8','9'},
                {' ','A','B','C',' '},
                {' ',' ','D',' ',' '}
        };

        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2016\\Day2\\src\\input.txt");

        String linea;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            while((linea = leer.readLine()) != null){
                linea.trim();
                for (int i = 0; i < linea.length(); i++) {
                    char instruccion = linea.charAt(i);
                    int filaBuena = tecla[0];
                    int columnaBuena = tecla[1];

                    switch (instruccion){
                        case 'U': filaBuena--; break;
                        case 'D': filaBuena++; break;
                        case 'R': columnaBuena++; break;
                        case 'L': columnaBuena--; break;
                    }

                    if (filaBuena >= 0 && filaBuena < 5 && columnaBuena >= 0 && columnaBuena < 5 && teclado[filaBuena][columnaBuena] != ' '){
                        tecla[0] = filaBuena;
                        tecla[1] = columnaBuena;
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
