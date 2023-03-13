package com.fmt.pmp.fmtPMP.DAO;

import java.util.List;

import com.fmt.pmp.fmtPMP.Model.Bonus;

public interface BonusDAO {
	List<Bonus> getAllBonuss();

	Bonus getBonusById(int BonusId);

	Bonus createBonus(Bonus Bonus);

	void updateBonus(Bonus Bonus);

	void deleteBonus(int BonusId);
}
