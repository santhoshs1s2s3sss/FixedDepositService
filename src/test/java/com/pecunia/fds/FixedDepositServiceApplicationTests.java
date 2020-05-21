package com.pecunia.fds;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;

import com.pecunia.fds.dto.FixedDepositHolders;
import com.pecunia.fds.dto.FixedDeposits;
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class FixedDepositServiceApplicationTests 
{
	@Autowired
	TestRestTemplate testRestTemplate;
	public void setTestRestTemplate(TestRestTemplate testRestTemplate)
	{
		this.testRestTemplate = testRestTemplate;
	}
	@LocalServerPort
	    int serverPort;
	
	@Test
	public void fixedDepositHolders_Positive() throws Exception
	{
		String url = "http://localhost:"+serverPort+"getFixedDepositDetails/fixeddepositholderid/11111";
		ResponseEntity<FixedDepositHolders> fdh = testRestTemplate.getForEntity(url, FixedDepositHolders.class);
		Assertions.assertEquals(200, fdh.getStatusCodeValue());
	}
	@Test
	public void fixedDepositHolders_Negative() throws Exception
	{
		String url = "http://localhost:"+serverPort+"getFixedDepositDetails/fixeddepositholderid/11111";
		ResponseEntity<String> message = testRestTemplate.getForEntity(url, String.class);
		Assertions.assertEquals(404, message.getStatusCodeValue());
	}
	@Test
	public void addFixedDeposit_Positive() throws Exception
	{
		String url = "http://localhost:"+serverPort+"addFixedDeposit";
		FixedDeposits fd=new FixedDeposits(12345,100,20);
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,fd,String.class);
		Assertions.assertEquals(200, response.getStatusCodeValue());
	}
	@Test
	public void addFixedDeposit_Negative() throws Exception
	{
		String url = "http://localhost:"+serverPort+"addFixedDeposit";
		FixedDeposits fd=null;
		 ResponseEntity<String> response = testRestTemplate.postForEntity(url,fd,String.class);
		Assertions.assertEquals(404, response.getStatusCodeValue());
	}
}
