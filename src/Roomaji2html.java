import java.util.ArrayList;


public class Roomaji2html {

    /** Converti un ArrayList de String en un String composant un tableau html des roomaji qui le composait en kana
     *
     * Prend en parametre un String; si le String est composee uniquement de Roomaji valide et de '.' et ' ', orientee
     * droite a gauche et de haut en bas, retourne un String representant un tableau html des Kana equivalent, oriente
     * de haut en bas et de droite a gauche.
     * Retourne le texte de l'erreur dans tous les autres cas.
     *
     * @param listeLigneRoomaji Un ArrayList de String contenant exclusivement des Roomaji, des '.' et des ' '.
     * @return    Un String de ces Roomaji converti en leur Kana equivalent, pret a l'affichage html.
     */
    public static String convertir(ArrayList<String> listeLigneRoomaji){
        StringBuilder resultat = new StringBuilder();
        Kana kana = new Kana();
        ArrayList<ArrayList<String>> tableau = new ArrayList<>();
        try{
            for(String ligne : listeLigneRoomaji){
                tableau.add(trouverSyllabes(ligne));
            }
            tableau = ManipuleArrayList.inverseLigne(tableau);
            tableau = ManipuleArrayList.transpose(tableau);
            for(ArrayList<String> arr : tableau){
                resultat.append("        <tr>");
                for(String str : arr){
                    resultat.append("<td>").append(kana.getKana(str)).append("</td>");
                }
                resultat = resultat.append("</tr>\n");
            }
        }catch(SyllabeImpossible e){
            System.err.println(e);
            System.exit(-1);
        }
        return resultat.toString();
    }


    /**Recoit un String contenant une ligne en Roomaji, et retourne un ArrayList de chacune des syllabes en majuscule.
     *
     * Parcour un String, et la decoupe en morceau du premier charactere [A-Z] jusqu'a la premiere voyelle [A-E-I-O-U]
     * ou la premiere apostrophe, conservant les '.' avec la syllabes qu'ils accompagnaient et retirant les ' '.
     *
     * @param ligne Un String representant une ligne de texte Roomaji, avec ' ' et '.'
     * @return  un ArrayList de String contenant, en ordre, chaque syllabes qui composaient la String (les '.' etant
     *          dans le meme element que la syllabe le precedent).
     * @throws  SyllabeImpossible   Lorsqu'une syllabe serait plus grande que 3 characteres ou que la ligne ne se
     *                              pas par une syllabe valide (avec ou sans '.' ou ' ' a la fin)
     */
    private static ArrayList<String> trouverSyllabes(String ligne) throws SyllabeImpossible{
        ArrayList<String> listeSyllabes = new ArrayList<>();
        ligne = ligne.toUpperCase();
        int debut = 0;
        for(int i = 0; i < ligne.length(); i++){
            if(ligne.charAt(debut) == '.'){
                listeSyllabes.set(listeSyllabes.size()-1,listeSyllabes.get(listeSyllabes.size()-1) + ".");
                debut++;
            }else if(ligne.charAt(debut) == ' '){
                debut++;
            }else if(i-debut > 2){
                throw new SyllabeImpossible("Il semble y avoir une syllabe de plus de 3 characteres...");
            }else if(ligne.charAt(i) == 'A' || ligne.charAt(i) == 'E' || ligne.charAt(i) == 'I'
                    || ligne.charAt(i) == 'O' || ligne.charAt(i) == 'U'|| ligne.charAt(i) == '\''){
                listeSyllabes.add(ligne.substring(debut,i+1));
                debut = i+1;
            }else if(i == ligne.length()-1){
                throw new SyllabeImpossible("La ligne ne termine pas par une syllabe valide...");
            }
        }
        return listeSyllabes;
    }
}
