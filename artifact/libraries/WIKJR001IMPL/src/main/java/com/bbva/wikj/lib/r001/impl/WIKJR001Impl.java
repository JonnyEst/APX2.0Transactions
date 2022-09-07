package com.bbva.wikj.lib.r001.impl;

import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.VendedorDTO;
import com.bbva.wikj.dto.apx2.idTwo.AutoSalidaGet;
import com.bbva.wikj.dto.apx2.idTwo.IdClass;
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

	@Override
	public AutoSalidaGet execute2(IdClass idClass) {
		AutoSalidaGet autoSalidaGet = new AutoSalidaGet();
		AutoDTOIN autoDTOIN = new AutoDTOIN();
		autoSalidaGet.setIdProduct(idClass.getId());
		autoSalidaGet.setMarca(autoDTOIN.getMarca());
		autoSalidaGet.setModelo(autoDTOIN.getModelo());
		autoSalidaGet.setAño(autoDTOIN.getAño());
		autoSalidaGet.setColor(autoDTOIN.getColor());
		autoSalidaGet.setPuertas(autoDTOIN.getPuertas());
		autoSalidaGet.setTrasmision(autoDTOIN.getTrasmision());
		autoSalidaGet.setKilometros(autoDTOIN.getKilometros());
		autoSalidaGet.setVendedorDTO(autoDTOIN.getVendedorDTO());
		autoSalidaGet.setPrecio(autoDTOIN.getPrecio());
		autoSalidaGet.setDescuentoCompraSinIVA(metodoIva(autoDTOIN));

		return autoSalidaGet;
	}


	public static int metodoIva(AutoDTOIN autoDTOIN){
		int precioDescuento=0;
		int precio = Integer.parseInt(autoDTOIN.getPrecio());

		precioDescuento = (int)(precio * 0.10);
		precio = precio-precioDescuento;
		return  precio;
	}

}
