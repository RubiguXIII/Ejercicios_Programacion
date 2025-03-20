import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        File archivo = new File("C:\\Users\\Usuario01\\Documents\\02_CURSOS\\Programacion\\00_Ejercicios\\AdventOfCode\\Java\\2015\\Day5\\src\\input.txt");

        String linea;
        int contadorVocales;
        int contadorBuenas = 0;
        try(BufferedReader leer = new BufferedReader(new FileReader(archivo))){
            //1ºParte
            /*
            Pattern patternVocales = Pattern.compile("[aeiou]");
            Pattern patternRepetidas = Pattern.compile("(.)\\1");
            Pattern patternNoContener = Pattern.compile("ab|cd|pq|xy");
            */

            //2ºParte
            Pattern primeraCondicion = Pattern.compile("(\\w\\w).*\\1");
            Pattern segundaCondicion = Pattern.compile("(\\w).\\1");

            while ((linea = leer.readLine()) != null){
                //1ºParte
                /*
                contadorVocales = 0;

                Matcher vocalesMatcher = patternVocales.matcher(linea);
                Matcher repetidasMatcher = patternRepetidas.matcher(linea);
                Matcher noContenerMatcher = patternNoContener.matcher(linea);

                while (vocalesMatcher.find()){
                    contadorVocales++;
                }

                //Condiciones
                boolean primeraCondicion = contadorVocales >= 3;
                boolean segundaCondicion = repetidasMatcher.find();
                boolean terceraCondicion = !noContenerMatcher.find();

                if (primeraCondicion && segundaCondicion && terceraCondicion){
                    contadorBuenas++;
                }
                */

                //2ºParte
                Matcher matcherPrimera = primeraCondicion.matcher(linea);
                Matcher matcherSegunda = segundaCondicion.matcher(linea);

                boolean primeraCondicionB = matcherPrimera.find();
                boolean segundaCondcionB = matcherSegunda.find();

                if (primeraCondicionB && segundaCondcionB){
                    contadorBuenas++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("Contador Buenas: " + contadorBuenas);
    }
}
