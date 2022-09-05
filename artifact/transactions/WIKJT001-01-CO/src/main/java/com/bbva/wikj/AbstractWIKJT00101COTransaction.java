package com.bbva.wikj;

import com.bbva.elara.transaction.AbstractTransaction;
import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.VendedorDTO;

/**
 * In this class, the input and output data is defined automatically through the setters and getters.
 */
public abstract class AbstractWIKJT00101COTransaction extends AbstractTransaction {

	public AbstractWIKJT00101COTransaction(){
	}

	/**
	 * Return value for input parameter data
	 */
	protected AutoDTOIN getData(){
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
		//return (AutoDTOIN) getParameter("data");
	}

	/**
	 * Set value for output parameter data
	 */
	protected void setData(final AutoDTOOUT field){
		this.addParameter("data", field);
	}

}
