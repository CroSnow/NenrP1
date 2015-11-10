package fer.hr.nenr.SailorMoon.DefuzzyficationPack;

import fer.hr.nenr.FuzzySetPack.IFuzzySet;

/**
 * Created by Ivan on 10.11.2015..
 */
public interface IKoder{
    /***
     *
     * Prima vrijednost i modelira neizrazit skup
     * @param value vrijendost
     * @return pripadnost neizratom skupu na temelju vrijednosti
     */
    IFuzzySet code(int value);
}
