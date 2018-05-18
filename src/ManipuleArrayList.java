import java.util.ArrayList;

public class ManipuleArrayList {

    /**Cette methode recoit un ArrayList d'ArrayList de String et le transpose.
     *
     * Cette methode prend les elements_i de chacun des ArrayList composant l'ArrayList recu pour creer la i^eme liste
     * dans l'Array liste de retour. les elements impossible a trouver (toutes les listes ne sont pas necessairement
     * egale seront considere comme nul et seront un element "" dans la liste de retour. Un element x_ij sera x_ji dans
     * L'ArrayList retourne.
     *
     *
     * @param listeOrigine
     * @return
     */
    public static ArrayList<ArrayList<String>> transpose (ArrayList<ArrayList<String>> listeOrigine){
        int nbLigne = 0;
        int nbColonne = listeOrigine.size();
        ArrayList<ArrayList<String>> arrayTranspose = new ArrayList<>();
        for(int i = 0; i < listeOrigine.size(); i++){
            if(listeOrigine.get(i).size() > nbLigne){
                nbLigne = listeOrigine.get(i).size();
            }
        }
        for(int j = 0; j < nbLigne; j++){
            arrayTranspose.add(new ArrayList<>());
        }
        for(int j = 0; j < nbLigne; j++){
            for(int i = 0; i < nbColonne; i++){
                if(listeOrigine.get(i).size() > j){
                    arrayTranspose.get(j).add(listeOrigine.get(i).get(j));
                }else{
                    arrayTranspose.get(j).add("");
                }
            }
        }
        return arrayTranspose;
    }

    /**
     *
     * @param liste
     * @param <E>
     * @return
     */
    public static <E> ArrayList<ArrayList<E>> inverseLigne (ArrayList<ArrayList<E>> liste){
        ArrayList<E> temp;
        int i = 0;
        while(i < liste.size()-(i+1)){
            temp = liste.get(i);
            liste.set(i,liste.get(liste.size()-(i+1)));
            liste.set(liste.size()-(i+1),temp);
            i++;
        }
        return liste;
    }
}
