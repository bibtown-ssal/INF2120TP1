import java.util.ArrayList;
import java.io.*;

public class Principal {
    public static final String CHEMIN_FIC = "";


    /**Prend le fichier a l'endroit indiquer en parametre et entre chacune de ses lignes dans l'ArrayList indique en
     * parametre
     *
     * @param fichier           Un ArrayList dans lequel on veut entrer le contenu d'un fichier, une ligne par element
     *                          dans l'ArrayList
     * @param cheminFichier     chemin relatif ou absolu, sous forme de String, pointant vers le fichier que l'on veut
     *                          lire
     */
    protected static void lireFichier(ArrayList<String> fichier, String cheminFichier){
        BufferedReader fic = null;
        try{
            fic = new BufferedReader(new FileReader(cheminFichier));
            while(fic.ready()){
                fichier.add(fic.readLine());
            }
        }catch(FileNotFoundException e) {
            System.out.println("Fichier non trouve");
        }catch(IOException e){
            System.out.println("Erreur dans la lecture du fichier");
        }finally {
            if (fic != null) {
                try {
                    fic.close();
                } catch (IOException e) {
                    System.out.println("Erreur dans la liberation du fichier");
                }
            }
        }
    }


    public static void main(String [] Args){
        ArrayList<String> fichier = new ArrayList<>();
        lireFichier(fichier,CHEMIN_FIC);
    }
}
