package com.bbva.wikj;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.wikj.dto.apx2.idTwo.AutoSalidaGet;
import com.bbva.wikj.dto.apx2.idTwo.IdClass;


/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractWIKJT00102COTransaction extends AbstractTransaction {

	public AbstractWIKJT00102COTransaction(){
	}

	protected IdClass getData(){
		return (IdClass)getParameter("data");
	}

	protected void setData(final AutoSalidaGet autoSalidaGet){
		this.addParameter("data", autoSalidaGet);
	}

}
