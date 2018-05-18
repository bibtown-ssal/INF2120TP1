import java.util.ArrayList;


public class Roomaji2html {

    /** Converti un ArrayList de String en un String composant un tableau html des roomaji qui le composait en kana
     *
     * @param listeLigneRoomaji
     * @return
     */
    public static String convertir(ArrayList<String> listeLigneRoomaji){
        String resultat = "";
        ArrayList<ArrayList<String>> tableau = new ArrayList<>();
        try{
            for(String ligne : listeLigneRoomaji){
                tableau.add(trouverSyllabes(ligne));
            }
        }catch(SyllabeImpossible e){
            resultat = e.getMessage();
        }
        tableau = ManipuleArrayList.inverseLigne(tableau);
        tableau = ManipuleArrayList.transpose(tableau);

        for(ArrayList<String> arr : tableau){
            resultat = resultat + "<tr>";
            for(String str : arr){
                resultat = resultat + "<td>" + str + "</td>";
            }
            resultat = resultat + "</tr>";
        }

        return resultat;
    }


    /**Recoit un String contenant une ligne en Roomaji, et retourne un ArrayList de chacune des syllabes.
     *
     * Parcour un String, et la decoupe en morceau du premier charactere [A-Z] jusqu'a la premiere voyelle [A-E-I-O-U]
     * ou la premiere apostrophe.
     *
     * @param ligne
     * @return
     * @throws  SyllabeImpossible   Lorsqu'une syllabe serait plus grande que 3 characteres
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
                throw new SyllabeImpossible("Il semble y avoir une syllabe de plus de 3 characteres..." + ligne + debut + i);
            }else if(ligne.charAt(i) == 'A' || ligne.charAt(i) == 'E' || ligne.charAt(i) == 'I'
                    || ligne.charAt(i) == 'O' || ligne.charAt(i) == 'U'|| ligne.charAt(i) == '\''){
                listeSyllabes.add(ligne.substring(debut,i+1));
                debut = i+1;
            }
        }
        return listeSyllabes;
    }




}
