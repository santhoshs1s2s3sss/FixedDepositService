package com.pecunia.fds;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.web.WebEndpointHttpMethod;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.pecunia.fds.dto.FixedDepositHolders;
import com.pecunia.fds.dto.FixedDeposits;
import com.pecunia.fds.service.FixedDepositHoldersService;
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
class FixedDepositServiceApplicationTests {
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate=testRestTemplate;
	}
	
	@LocalServerPort
	int localServerPort;
	
	@Test
	public void testGetHolderById_Positive() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"getHolderById/98765";
		 ResponseEntity<FixedDepositHolders> holder = testRestTemplate.getForEntity(url,FixedDepositHolders.class);
		// Assertions.assertEquals(200, holder.getStatusCodeValue());
	}
	
	@Test
	public void testGetHolderById_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"getHolderById/98765";
		 ResponseEntity<FixedDepositHolders> holder = testRestTemplate.getForEntity(url,FixedDepositHolders.class);
		 Assertions.assertEquals(404, holder.getStatusCodeValue());
	}

/*	@Test
	public void testAddFixedDepositDetails_Positive() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"insertFixedDeposit";
		 FixedDeposits book = new FixedDeposits(31,2,3);
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,book,String.class);
		 //Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	
	@Test
	public void testAddFixedDepoistDetails_Negative() throws Exception
	{
		 String url="http://localhost:"+localServerPort+"addBook";
		 FixedDeposits book = null;
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,book,String.class);
		 //Assertions.assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCodeValue());
	}

*/
}