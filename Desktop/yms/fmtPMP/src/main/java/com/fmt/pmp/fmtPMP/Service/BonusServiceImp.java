package com.fmt.pmp.fmtPMP.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fmt.pmp.fmtPMP.DAO.BonusDAO;
import com.fmt.pmp.fmtPMP.Model.Bonus;

@Service
public class BonusServiceImp implements BonusService {
	@Autowired
	private BonusDAO BonusDAO;

	@Override
	public Bonus getBonusById(int BonusId) {
		Bonus obj = BonusDAO.getBonusById(BonusId);
		return obj;
	}

	@Override
	public List<Bonus> getAllBonuss() {
		return BonusDAO.getAllBonuss();
	}

	@Override
	@Transactional
	public Bonus createBonus(Bonus theTransaction) {
		return BonusDAO.createBonus(theTransaction);
	}

	@Override
	public void updateBonus(Bonus Bonus) {
		BonusDAO.updateBonus(Bonus);
	}

	@Override
	public void deleteBonus(int BonusId) {
		BonusDAO.deleteBonus(BonusId);
	}
}
