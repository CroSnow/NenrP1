package fer.hr.nenr.SailorMoon.MISO.IfThenDBPack;

import fer.hr.nenr.DomainPack.IDomain;
import fer.hr.nenr.DomainPack.SimpleDomain;
import fer.hr.nenr.SailorMoon.MISO.IfThenDBPack.Rule.IRule;

/**
 * Created by Ivan on 11.11.2015..
 */
public class FilledLogicDB extends LogicDB {
    private static int domainSize=100;

    private static int lJakoBlizu=10;
    private static int hJakoBlizu=20;

    private static int lBlizu=15;
    private static int pBlizu=20;
    private static int hBlizu=35;

    private static int lDaleko=30;
    private static int hDaleko=40;

    private static int lMiruje = 0;
    private static int hMiruje =4;

    private static int lSpor=2;
    private static int pSpor=10;
    private static int hSpor=20;

    private static int lNorm=15;
    private static int pNorma=35;
    private static int hNorma=55;

    private static int lBrz=50;
    private static int pBrz=60;
    private static int hBrz=70;

    private static int lJBrz=65;
    private static int hJBrz=75;

    public FilledLogicDB() {
        super(new SimpleDomain(0,domainSize));
    }

    public IRule jakoBlizu(){
        return super.l(lJakoBlizu,hJakoBlizu);
    }

    public IRule blizu(){
        return super.triangle(lBlizu,pBlizu,hBlizu);
    }

    public IRule daleko(){
        return super.gamma(lDaleko,hDaleko);
    }

    public IRule miruje(){
        return super.l(lMiruje,hMiruje);
    }

    public IRule spor(){
        return super.triangle(lSpor,pSpor,hSpor);
    }

    public IRule normalna(){
        return  super.triangle(lNorm,pNorma,hNorma);
    }

    public IRule brz(){
        return super.triangle(lBrz,pBrz,hBrz);
    }
    public IRule jakoBrz(){
        return super.gamma(lJBrz,hJBrz);
    }

    /**
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     * +                    IZLAZ                              +
     * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++
     */

    private static int lJakoLijevo = 10;
    private static int hJakoLijevo= 20;

    private static int lLijevo = 15;
    private static int pLijevo = 30;
    private static int hLijevo = 45;

    private static int lNemaSkretanja =35;
    private static int pNemaSkretanja=50;
    private static int hNemaSkretanja=65;

    private static int lDesno= 55;
    private static int pDesno = 70;
    private static int hDesno = 85;

    private static int lJakoDesno=80;
    private static int hJakoDesno = 90;

    private static int lUsporiJako = 10;
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
    private static int hUbrzajJako= 90;

    public IRule JakoLijevo(){
        return  super.l(lJakoLijevo,hJakoLijevo);
    }
    public IRule Lijevo(){
        return  super.triangle(lLijevo,pLijevo,hLijevo);
    }

    public IRule NemaSkretanja(){
        return super.triangle(lNemaSkretanja,pNemaSkretanja,hNemaSkretanja);
    }

    public IRule Desno(){
        return super.triangle(lDesno,pDesno,hDesno);
    }

    public IRule JakoDesno(){
        return super.gamma(lJakoDesno,hJakoDesno);
    }


    public IRule UsporiJako(){
        return  super.l(lUsporiJako,hUsporiJako);
    }
    public IRule Uspori(){
        return  super.triangle(lUspori,pUspori,hUspori);
    }

    public IRule NeMijenjajAkc(){
        return super.triangle(lNeMijenjajAkc,pNeMijenjajAkc,hNeMijenjajAkc);
    }

    public IRule Ubrzaj(){
        return super.triangle(lUbrzaj,pUbrzaj,hUbrzaj);
    }

    public IRule UbrzajJako(){
        return super.gamma(lUbrzajJako,hUbrzajJako);
    }

}
