package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Bonus;

public interface BonusService {
	 List<Bonus> getAllBonuss();
	    Bonus getBonusById(int BonusId);
	    Bonus createBonus(Bonus Bonus);
	    void updateBonus(Bonus Bonus);
	    void deleteBonus(int BonusId);
}
