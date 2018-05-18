import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Principale {
    private static final String CHEMIN_FIC_INPUT = "fichierInput.txt";
    private static final String CHEMIN_FIC_OUTPUT = "fichierOutput.html";
    private static final String DEBUT_HTML =
              "<!DOCTYPE html>\n"
            + "<html>\n"
            + "    <head>\n"
            + "        <title>Tp1</title>\n"
            + "    </head>\n"
            + "    <body>\n"
            + "        <hr>\n"
            + "        <table>\n";
    private static final String FIN_HTML =
              "        </table>\n"
            + "        <hr>\n"
            + "    </body>\n"
            + "</html>";

    /**Prend le fichier a l'endroit indiquer en parametre et ajoute chacune de ses lignes a l'ArrayList indique en
     * parametre.
     *
     * Ouvre et lit le fichier a l'adresse indiquee, mets chaque ligne (indentifiee par la presence d'un '\n', d'un
     * '\r' ou d'en '\r\n', ou en atteignant la fin du fichier. Chaque ligne est convertie en String et ajoutee a
     * l'ArrayList
     *
     * @param fichier           Un ArrayList dans lequel on veut entrer le contenu d'un fichier, une ligne par element
     *                          dans l'ArrayList
     * @param cheminFichier     chemin relatif ou absolu, sous forme de String, pointant vers le fichier que l'on veut
     *                          lire
     */
    private static void lireFichier(ArrayList<String> fichier, String cheminFichier){
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

    /** Cree le fichier html compose de la String passee en parametre a l'endroit passe en parametre.
     *
     * Ecrase ou creer un fichier html du nom specifie ayant le contenu envoye en parametre.
     * @param contenu   String composant l'entierete du contenu du fichier html
     * @param cheminFichier     addresse de l'emplacement ou le fichier sera creer/remplacer
     */
    private static void ecrireFichier(String contenu, String cheminFichier){
        BufferedWriter fic = null;

        try{
            fic = new BufferedWriter(new FileWriter(cheminFichier));
            fic.write(contenu);
        }catch(IOException e){
            System.out.println("Erreur dans la creation du FileWriter");
        }finally{
            try{
                fic.close();
            }catch(IOException e){
                System.out.println("Erreur dans la creation/liberation du fichier");
            }
        }
    }


    public static void main(String [] Args){
        ArrayList<String> fichier = new ArrayList<>();
        lireFichier(fichier,CHEMIN_FIC_INPUT);
        ecrireFichier(DEBUT_HTML + Roomaji2html.convertir(fichier) + FIN_HTML,CHEMIN_FIC_OUTPUT);
    }
}
