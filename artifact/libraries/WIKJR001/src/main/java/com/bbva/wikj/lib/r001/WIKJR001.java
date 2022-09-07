package com.bbva.wikj.lib.r001;

import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.idTwo.AutoSalidaGet;
import com.bbva.wikj.dto.apx2.idTwo.IdClass;

import java.util.List;

/**
 * The  interface WIKJR001 class...
 */
public interface WIKJR001 {

	AutoDTOOUT execute(AutoDTOIN autoDTOIN);

	AutoSalidaGet execute2(IdClass idClass);
	/**
	 * The execute method...
	 */

}
