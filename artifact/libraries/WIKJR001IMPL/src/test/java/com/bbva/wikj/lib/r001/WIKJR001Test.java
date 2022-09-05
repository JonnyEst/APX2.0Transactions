package com.bbva.wikj.lib.r001;

import com.bbva.elara.configuration.manager.application.ApplicationConfigurationService;
import com.bbva.elara.domain.transaction.Context;
import com.bbva.elara.domain.transaction.ThreadContext;
import javax.annotation.Resource;

import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.dto.apx2.VendedorDTO;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.aop.framework.Advised;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/WIKJR001-app.xml",
		"classpath:/META-INF/spring/WIKJR001-app-test.xml",
		"classpath:/META-INF/spring/WIKJR001-arc.xml",
		"classpath:/META-INF/spring/WIKJR001-arc-test.xml" })
public class WIKJR001Test {

	@Spy
	private Context context;

	@Resource(name = "wikjR001")
	private WIKJR001 wikjR001;

	@Resource(name = "applicationConfigurationService")
	private ApplicationConfigurationService applicationConfigurationService;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		context = new Context();
		ThreadContext.set(context);
		getObjectIntrospection();
	}
	
	private Object getObjectIntrospection() throws Exception{
		Object result = this.wikjR001;
		if(this.wikjR001 instanceof Advised){
			Advised advised = (Advised) this.wikjR001;
			result = advised.getTargetSource().getTarget();
		}
		return result;
	}
	
	@Test
	public void executeTest(){
		//wikjR001.execute(datosAuto());
		//System.out.println(datosAuto());
		//Assert.assertEquals(0, context.getAdviceList().size());
	}

	public AutoDTOIN datosAuto(){
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


		return  autoDTOIN;
	}

}
