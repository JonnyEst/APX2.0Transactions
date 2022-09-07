package com.bbva.wikj;

import com.bbva.elara.domain.transaction.*;
import com.bbva.elara.domain.transaction.request.TransactionRequest;
import com.bbva.elara.domain.transaction.request.body.CommonRequestBody;
import com.bbva.elara.domain.transaction.request.header.CommonRequestHeader;
import com.bbva.elara.test.osgi.DummyBundleContext;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;

import com.bbva.wikj.dto.apx2.AutoDTOIN;
import com.bbva.wikj.dto.apx2.AutoDTOOUT;
import com.bbva.wikj.lib.r001.WIKJR001;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Test for transaction WIKJT00101COTransaction
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
		"classpath:/META-INF/spring/elara-test.xml",
		"classpath:/META-INF/spring/WIKJT00101COTest.xml" })
public class WIKJT00101COTransactionTest {

	//NEW
	private final Severity[] finalSeverity = { null };
	List<String> http = new ArrayList<>();

	@Autowired
	private WIKJT00101COTransaction transaction;

	@Resource(name = "dummyBundleContext")
	private DummyBundleContext bundleContext;

	//NEW
	@Mock
	private WIKJR001 wikjR001;

	@Spy
	private Context context;

	@Mock
	private CommonRequestHeader header;

	@Mock
	private TransactionRequest transactionRequest;

	@Before
	public void initializeClass() throws Exception {

		//NEW
		transaction = new WIKJT00101COTransaction() {
			@Override
			protected <T> T getServiceLibrary(Class<T> serviceInterface) {
				return (T) wikjR001;
			}
		};



		// Initializing mocks
		MockitoAnnotations.initMocks(this);
		// Start BundleContext
		this.transaction.start(bundleContext);
		// Setting Context
		this.transaction.setContext(new Context());
		// Set Body
		CommonRequestBody commonRequestBody = new CommonRequestBody();
		commonRequestBody.setTransactionParameters(new ArrayList<>());
		this.transactionRequest.setBody(commonRequestBody);
		// Set Header Mock
		this.transactionRequest.setHeader(header);
		// Set TransactionRequest
		this.transaction.getContext().setTransactionRequest(transactionRequest);
	}

	//NEW
	@Test
	public void executeValidTest(){
		// Example to Mock the Header
		// Mockito.doReturn("ES").when(header).getHeaderParameter(RequestHeaderParamsName.COUNTRYCODE);
		Mockito.when(wikjR001.execute(entityInputDTO())).thenReturn(entityOutputDTO());

		this.addParameter("data", entityInputDTO());
		this.transaction.execute();

		Assert.assertNull(finalSeverity[0]);
		//Assert.assertNotNull(this.transaction);
	}

	@Test
	public void executeInvalidTestOther() {

		Advice advice = new Advice("WIKJ12042000", "Invalid Frequency", AdviceType.W, null);
		http.add(Severity.ENR.toString());
		context.getAdviceList().add(advice);
		transaction.setContext(context);

		Mockito.when(wikjR001.execute(entityInputDTO())).thenReturn(entityOutputDTO());

		this.addParameter("productInput", entityInputDTO());
		this.transaction.execute();

		Assert.assertEquals( transaction.getSeverity().toString(), http.get(0));
	}

	//NEW

	private AutoDTOIN entityInputDTO() {
		AutoDTOIN autoDTOIN = new AutoDTOIN();
		autoDTOIN.setPrecio("69999999");
		autoDTOIN.setPuertas(4);
		autoDTOIN.setTrasmision("Auto");

		return autoDTOIN;
	}

	private AutoDTOOUT entityOutputDTO() {

		AutoDTOOUT autoDTOOUT = new AutoDTOOUT();

		autoDTOOUT.setDescuentoCompraSinIVA(321);

		return autoDTOOUT;
	}








	//OLD

	@Test
	public void testNotNull(){
	    // Example to Mock the Header
		// Mockito.doReturn("ES").when(header).getHeaderParameter(RequestHeaderParamsName.COUNTRYCODE);
	//	Assert.assertNotNull(this.transaction);
	//	this.transaction.execute();
	}

	// Add Parameter to Transaction
	private void addParameter(final String parameter, final Object value) {
	//	final TransactionParameter tParameter = new TransactionParameter(parameter, value);
	//	transaction.getContext().getParameterList().put(parameter, tParameter);
	}

	// Get Parameter from Transaction
	//private Object getParameter(final String parameter) {
	//	final TransactionParameter param = transaction.getContext().getParameterList().get(parameter);
	//	return param != null ? param.getValue() : null;
	//}
}
