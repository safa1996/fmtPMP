package com.fmt.pmp.fmtPMP.Export;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import com.fmt.pmp.fmtPMP.Model.Pmp;

public class ResultatExport {
	Pmp _root;

	public ResultatExport(Pmp _root) {
		this._root = _root;
	}
	   public String getDateJourFormate()
	   {

	      String pattern = "dd MMMMM yyyy  ";
	      SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern, new Locale("fr", ""));

	      return simpleDateFormat.format(new Date());

	   }
	   public String getTitre()
	   {
		   return this._root.getTitre();
	   }
	   
	   public String getDescription()
	   {
		   return this._root.getDescription();
	   }
}
