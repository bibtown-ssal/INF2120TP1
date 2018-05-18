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
     * @param listeOrigine  Un ArrayList d'ArrayList de String
     * @return      Un ArrayList d'ArrayList de String ou on a interchange le premier niveau
     *              d'encapsulation avec le deuxieme (les lignes sont devenues colonnes et inversement)
     */
    public static ArrayList<ArrayList<String>> transpose (ArrayList<ArrayList<String>> listeOrigine){
        int nbLigne = 0;
        ArrayList<ArrayList<String>> arrayTranspose = new ArrayList<>();
        for(ArrayList<String> arr : listeOrigine){
            if(arr.size() > nbLigne){
                nbLigne = arr.size();
            }
        }
        for(int j = 0; j < nbLigne; j++){
            arrayTranspose.add(new ArrayList<>());
        }
        for(int j = 0; j < nbLigne; j++){
            for(ArrayList<String> arr : listeOrigine){
                if(arr.size() > j){
                    arrayTranspose.get(j).add(arr.get(j));
                }else{
                    arrayTranspose.get(j).add("");
                }
            }
        }
        return arrayTranspose;
    }

    /** Cette methode prend un ArrayList d'ArrayList et inverse l'ordre des ArrayList contenus.
     *
     * @param liste Un ArrayList d'ArrayList
     * @param <E>   Le Type contenu par les ArrayList contenues
     * @return      Un ArrayList avec ses ArrayList inversee, ou null si liste est null en parametre
     */
    public static <E> ArrayList<ArrayList<E>> inverseLigne (ArrayList<ArrayList<E>> liste){
        ArrayList<E> temp;
        int i = 0;
        if(liste != null) {
            while (i < liste.size() - (i + 1)) {
                temp = liste.get(i);
                liste.set(i, liste.get(liste.size() - (i + 1)));
                liste.set(liste.size() - (i + 1), temp);
                i++;
            }
        }
        return liste;
    }
}
