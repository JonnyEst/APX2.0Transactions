package com.bbva.wikj;

import com.bbva.elara.domain.transaction.Severity;
import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.VendedorDTO;
import com.bbva.wikj.lib.r001.WIKJR001;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Transaction section of apx2 exercise
 *
 */
public class WIKJT00101COTransaction extends AbstractWIKJT00101COTransaction {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJT00101COTransaction.class);

	/**
	 * The execute method...
	 */
	@Override
	public void execute() {
		LOGGER.info("Starting execute WIKJT00101COTransaction {}", getData());
		WIKJR001 wikjr001 = (WIKJR001)getServiceLibrary(WIKJR001.class);

		//TODO

		AutoDTOOUT autoDTOOUT = wikjr001.execute(getData());

		if(autoDTOOUT!=null){
			LOGGER.info("Result execute successful");
			setData(autoDTOOUT);

			this.setSeverity(Severity.OK);
		}else{
			LOGGER.info("Result execute fail");
			this.setSeverity(Severity.ENR);
		}


	}

	/**public static AutoDTOIN getData(){
		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setNombre("Carlos");
		vendedorDTO.setTelefono("3184736182");
		vendedorDTO.setDocumento("53628190");


		AutoDTOIN autoDTOIN = new AutoDTOIN();
		autoDTOIN.setMarca("Mazda");
		autoDTOIN.setModelo("3");
		autoDTOIN.setAño(2016);
		autoDTOIN.setColor("Plateado");
		autoDTOIN.setPuertas(4);
		autoDTOIN.setTrasmision("Automatica");
		autoDTOIN.setKilometros("70533");
		autoDTOIN.setVendedorDTO(vendedorDTO);
		autoDTOIN.setPrecio("69.900.000");

		return autoDTOIN;
	}*/

}
