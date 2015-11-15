package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.DomainPack.SimpleDomain;
import fer.hr.nenr.FuzzySetPack.IFuzzySet;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

/**
 * Created by Ivan on 11.11.2015..
 */
public abstract class FilledLogicDBv2 extends LogicDB {
    private static int domainSize=100;

    private static int lJakoBlizu=1;
    private static int hJakoBlizu=7;

    private static int lBlizu=3;
    private static int pBlizu=7;
    private static int hBlizu=10;

    private static int lDaleko=7;
    private static int hDaleko=10;

    private static int lMiruje = 5;
    private static int hMiruje =15;

    private static int lSpor=5;
    private static int pSpor=20;
    private static int hSpor=35;

    private static int lNorm=15;
    private static int pNorma=35;
    private static int hNorma=65;

    private static int lBrz=55;
    private static int pBrz=65;
    private static int hBrz=75;

    private static int lJBrz=65;
    private static int hJBrz=80;



    public static IFuzzySet jakoBlizu(){
        return l(lJakoBlizu,hJakoBlizu);
    }

    public static IFuzzySet blizu(){
        return triangle(lBlizu,pBlizu,hBlizu);
    }

    public static IFuzzySet daleko(){
        return gamma(lDaleko,hDaleko);
    }

    public static IFuzzySet miruje(){
        return l(lMiruje,hMiruje);
    }

    public static IFuzzySet spor(){
        return triangle(lSpor,pSpor,hSpor);
    }

    public static IFuzzySet normalna(){
        return  triangle(lNorm,pNorma,hNorma);
    }

    public static IFuzzySet brz(){
        return triangle(lBrz,pBrz,hBrz);
    }
    public static IFuzzySet jakoBrz(){
        return gamma(lJBrz,hJBrz);
    }

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * +                    IZLAZ                              +
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */
    private static int lJakoLijevo = 93;
    private static int hJakoLijevo= 95;

    private static int lLijevo = 85;
    private static int pLijevo = 90;
    private static int hLijevo = 95;

    private static int lNemaSkretanja =15;
    private static int pNemaSkretanja=50;
    private static int hNemaSkretanja=85;

    private static int lDesno= 5;
    private static int pDesno = 10;
    private static int hDesno = 20;

    private static int lJakoDesno=5;
    private static int hJakoDesno = 7;



    private static int lUsporiJako = 0;
    private static int hUsporiJako= 20;

    private static int lUspori = 15;
    private static int pUspori = 30;
    private static int hUspori = 45;

    private static int lNeMijenjajAkc =35;
    private static int pNeMijenjajAkc=50;
    private static int hNeMijenjajAkc=65;

    private static int lUbrzaj= 55;
    private static int pUbrzaj= 70;
    private static int hUbrzaj = 85;

    private static int lUbrzajJako=80;
    private static int hUbrzajJako= 99;

    public static IFuzzySet JakoLijevo(){
        return  gamma(lJakoLijevo,hJakoLijevo);
    }
    public static IFuzzySet Lijevo(){
        return  triangle(lLijevo,pLijevo,hLijevo);
    }

    public static IFuzzySet NemaSkretanja(){
        return triangle(lNemaSkretanja,pNemaSkretanja,hNemaSkretanja);
    }

    public static IFuzzySet Desno(){
        return triangle(lDesno,pDesno,hDesno);
    }

    public static IFuzzySet JakoDesno(){
        return l(lJakoDesno,hJakoDesno);
    }


    public static IFuzzySet UsporiJako(){
        return  l(lUsporiJako,hUsporiJako);
    }
    public static IFuzzySet Uspori(){
        return  triangle(lUspori,pUspori,hUspori);
    }

    public static IFuzzySet NeMijenjajAkc(){
        return triangle(lNeMijenjajAkc,pNeMijenjajAkc,hNeMijenjajAkc);
    }

    public static IFuzzySet Ubrzaj(){
        return triangle(lUbrzaj,pUbrzaj,hUbrzaj);
    }

    public static IFuzzySet UbrzajJako(){
        return gamma(lUbrzajJako,hUbrzajJako);
    }

}
