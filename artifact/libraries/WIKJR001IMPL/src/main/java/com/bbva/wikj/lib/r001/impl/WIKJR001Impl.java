package com.bbva.wikj.lib.r001.impl;

import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.VendedorDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * The WIKJR001Impl class...
 */
public class WIKJR001Impl extends WIKJR001Abstract {

	private static final Logger LOGGER = LoggerFactory.getLogger(WIKJR001Impl.class);

	@Override
	public AutoDTOOUT execute(AutoDTOIN autoDTOIN) {

		VendedorDTO vendedorDTO = new VendedorDTO();
		vendedorDTO.setNombre(vendedorDTO.getNombre());
		vendedorDTO.setTelefono(vendedorDTO.getTelefono());

		AutoDTOOUT autoDTOOUT = new AutoDTOOUT();
		autoDTOOUT.setAño(autoDTOIN.getAño());
		autoDTOOUT.setColor(autoDTOIN.getColor());
		autoDTOOUT.setKilometros(autoDTOIN.getKilometros());
		autoDTOOUT.setMarca(autoDTOIN.getMarca());
		autoDTOOUT.setModelo(autoDTOIN.getModelo());
		autoDTOOUT.setPuertas(autoDTOIN.getPuertas());
		autoDTOOUT.setTrasmision(autoDTOIN.getTrasmision());
		autoDTOOUT.setPrecio(autoDTOIN.getPrecio());
		autoDTOOUT.setVendedorDTO(vendedorDTO);
		autoDTOOUT.setDescuentoCompraSinIVA(metodoIva(autoDTOIN));

		return autoDTOOUT;
	}

	public static int metodoIva(AutoDTOIN autoDTOIN){
		int precioDescuento=0;
		int precio = Integer.parseInt(autoDTOIN.getPrecio());

		precioDescuento = (int)(precio * 0.10);
		precio = precio-precioDescuento;
		return  precio;
	}

}
