//java
import java.util.*;

/**
 *
 * @author duanr
 */

public class parentesis {

    public static void main(String[] pps) {
        System.out.println(parentesisBalanceados(3));
    }

    public static String parentesisBalanceados(int a) {

        String palabra = "";
        String palabra_final = "";
        String cadena[] = new String[a * 2];
        String cadena2[] = new String[a * 2];
        LinkedHashSet cadenas = new LinkedHashSet<String>();//no permite duplicados y conserva el orden de entrada

        for (int l = 0; l < a * 2; l++) {//llenamos cadena con la cantidad de llaves que vamos a ocupar
            if ((l % 2) == 0) {
                cadena[l] = "{";
                cadena2[l] = "{";
            } else {
                cadena[l] = "}";
                cadena2[l] = "}";
            }
        }
        for (var s : cadena) {
            palabra += s;
        }
        palabra += ",";
        cadenas.add(palabra);//agregamos la primera combinacion que seria la original

        int bandera = 0;
        String guarda = "";
        while (bandera != a -1) {
            for (int y = 0; y < a + a - 1; y++) {//hacemos una busqueda y recorremos los } hacia la derecha
                palabra = "";
                if (cadena[y].equals("}")) {
                    guarda = cadena[y];
                    cadena[y] = cadena[y + 1];
                    cadena[y + 1] = guarda;
                    for (var s : cadena) {//convertimos la cadena en un string
                        palabra += s;
                    }
                    palabra += ",";
                    cadenas.add(palabra);//guardamos el string en un espacio dentro de cadenas
                }

            }
            bandera++;//esta variable hara que todas las } se recorran

        }
        bandera = 0;
        guarda = "";
        while (bandera != a-1 ) {
            for (int u = cadena2.length - 1; u > 0; u--) {//hacemos una busqueda y recorremos los { hacia la izquierda
                palabra = "";
                if (cadena2[u].equals("{")) {
                    guarda = cadena2[u];
                    cadena2[u] = cadena2[u - 1];
                    cadena2[u - 1] = guarda;
                    for (var s : cadena2) {
                        palabra += s;
                    }
                    palabra += ",";
                    cadenas.add(palabra);
                }

            }
            bandera++;//esta variable hara que todas las { se recorran

        }

        for (var s : cadenas) {//fianlmente iteramos todos los valores dentro de cadenas y los concatenamos en un string para obtener el resultado final
            System.out.println("s = " + s);
           break;
        }

        return palabra_final;
    }

}
