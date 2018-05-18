import java.util.Map;
import java.util.TreeMap;

public class Kana{
    public Map <String, String> kana = new TreeMap<>();

    public Kana() {
        kana.put("A", "&#12354;");
        kana.put("I", "&#12356;");
        kana.put("U", "&#12358;");
        kana.put("E", "&#12360;");
        kana.put("O", "&#12362;");
        kana.put("KA", "&#12363;");
        kana.put("KI", "&#12365;");
        kana.put("KU", "&#12367;");
        kana.put("KE", "&#12369;");
        kana.put("KO", "&#12371;");
        kana.put("SA", "&#12373;");
        kana.put("SHI", "&#12375;");
        kana.put("SU", "&#12377;");
        kana.put("SE", "&#12379;");
        kana.put("SO", "&#12381;");
        kana.put("TA", "&#12383;");
        kana.put("CHI", "&#12385;");
        kana.put("TSU", "&#12388;");
        kana.put("TE", "&#12390;");
        kana.put("TO", "&#12392;");
        kana.put("NA", "&#12394;");
        kana.put("NI", "&#12395;");
        kana.put("NU", "&#12396;");
        kana.put("NE", "&#12397;");
        kana.put("NO", "&#12398;");
        kana.put("HA", "&#12399;");
        kana.put("HI", "&#12402;");
        kana.put("FU", "&#12405;");
        kana.put("HE", "&#12408;");
        kana.put("HO", "&#12411;");
        kana.put("MA", "&#12414;");
        kana.put("MI", "&#12415;");
        kana.put("MU", "&#12416;");
        kana.put("ME", "&#12417;");
        kana.put("MO", "&#12418;");
        kana.put("YA", "&#12420;");
        kana.put("YU", "&#12422;");
        kana.put("YO", "&#12424;");
        kana.put("RA", "&#12425;");
        kana.put("RI", "&#12426;");
        kana.put("RU", "&#12427;");
        kana.put("RE", "&#12428;");
        kana.put("RO", "&#12429;");
        kana.put("WA", "&#12431;");
        kana.put("WI", "&#12432;");
        kana.put("WE", "&#12433;");
        kana.put("WO", "&#12434;");
        kana.put("GA", "&#12364;");
        kana.put("GI", "&#12366;");
        kana.put("GU", "&#12368;");
        kana.put("GE", "&#12370;");
        kana.put("GO", "&#12372;");
        kana.put("ZA", "&#12374;");
        kana.put("JI", "&#12376;");
        kana.put("ZU", "&#12378;");
        kana.put("ZE", "&#12380;");
        kana.put("ZO", "&#12382;");
        kana.put("DA", "&#12384;");
        kana.put("DI", "&#12386;");
        kana.put("DZU", "&#12389;");
        kana.put("DE", "&#12391;");
        kana.put("DO", "&#12393;");
        kana.put("BA", "&#12400;");
        kana.put("BI", "&#12403;");
        kana.put("BU", "&#12406;");
        kana.put("BE", "&#12409;");
        kana.put("BO", "&#12412;");
        kana.put("PA", "&#12401;");
        kana.put("PI", "&#12404;");
        kana.put("PU", "&#12407;");
        kana.put("PE", "&#12410;");
        kana.put("PO", "&#12413;");
        kana.put("KYA", "&#12365;&#12419;");
        kana.put("KYU", "&#12365;&#12421;");
        kana.put("KYO", "&#12365;&#12423;");
        kana.put("SHA", "&#12375;&#12419;");
        kana.put("SHU", "&#12375;&#12421;");
        kana.put("SHO", "&#12375;&#12423;");
        kana.put("CHA", "&#12385;&#12419;");
        kana.put("CHU", "&#12385;&#12421;");
        kana.put("CHO", "&#12385;&#12423;");
        kana.put("NYA", "&#12395;&#12419;");
        kana.put("NYU", "&#12395;&#12421;");
        kana.put("NYO", "&#12395;&#12423;");
        kana.put("HYA", "&#12402;&#12419;");
        kana.put("HYU", "&#12402;&#12421;");
        kana.put("HYO", "&#12402;&#12423;");
        kana.put("MYA", "&#12415;&#12419;");
        kana.put("MYU", "&#12415;&#12421;");
        kana.put("MYO", "&#12415;&#12423;");
        kana.put("RYA", "&#12426;&#12419;");
        kana.put("RYU", "&#12426;&#12421;");
        kana.put("RYO", "&#12426;&#12423;");
        kana.put("GYA", "&#12366;&#12419;");
        kana.put("GYU", "&#12366;&#12421;");
        kana.put("GYO", "&#12366;&#12423;");
        kana.put("JA", "&#12376;&#12419;");
        kana.put("JU", "&#12376;&#12421;");
        kana.put("JO", "&#12376;&#12423;");
        kana.put("DJA", "&#12386;&#12419;");
        kana.put("DJU", "&#12386;&#12421;");
        kana.put("DJO", "&#12386;&#12423;");
        kana.put("BYA", "&#12403;&#12419;");
        kana.put("BYU", "&#12403;&#12421;");
        kana.put("BYO", "&#12403;&#12423;");
        kana.put("PYA", "&#12404;&#12419;");
        kana.put("PYU", "&#12404;&#12421;");
        kana.put("PYO", "&#12404;&#12423;");
        kana.put("N'","&#12435;");
        kana.put("", "");
    }

    public String getKana(String key) throws SyllabeImpossible{
        String result = kana.get(key);
        if(result == null){
            result = kana.get(key.substring(0,key.length()-1))+".";
        }
        if(result.equals( "null.")){
            throw new SyllabeImpossible("Il y a une syllabe sans kana dans le fichier source.");
        }

        return result;
    }

}
