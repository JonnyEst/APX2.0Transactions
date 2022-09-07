package com.bbva.wikj;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.idTwo.AutoSalidaGet;
import com.bbva.wikj.lib.r001.WIKJR001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transaction version 2
 *
 */
public class WIKJT00102COTransaction extends AbstractWIKJT00102COTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJT00102COTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		LOGGER.info("Starting execute WIKJT00101COTransaction {}", getData());
		WIKJR001 wikjr001 = (WIKJR001)getServiceLibrary(WIKJR001.class);

		//TODO

		AutoSalidaGet autoSalidaGet = wikjr001.execute2(getData());

		if(getAdviceList().isEmpty()){
			LOGGER.info("Result execute successful");
			setData(autoSalidaGet);
			this.setSeverity(Severity.OK);
		}else{
			LOGGER.info("Result execute fail");
			this.setSeverity(Severity.ENR);
		}
	}

}
