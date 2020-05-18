package com.pecunia.fds.service;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import com.pecunia.fds.dto.FixedDepositHolders;
import com.pecunia.fds.dto.FixedDeposits;

public class TestHolderService {
	  @Autowired
      FixedDepositHoldersService fixedDepositService;
	  @Autowired
	  FixedDepositsService fds;
      
      
      @Test
      public void testGetHolderById_Positive() throws Exception
      {
    	    Optional<FixedDepositHolders> holder = fixedDepositService.getFixedDepositHolders(2222);
    	    Assertions.assertEquals(true,holder.isPresent());
      }
      
      @Test
      public void testGetHolderById_Negative() throws Exception
      {
    	  Optional<FixedDepositHolders> holder = fixedDepositService.getFixedDepositHolders(2222);
    	    Assertions.assertEquals(false,holder.isPresent());
      }
      
     // @Test
/*      public void testInsertBook_Positive() throws Exception
      {
    	  FixedDeposits book = new FixedDeposits(111,4,3);
    	  FixedDeposits b =  fds.insertFixedDeposit(book);
    	  Assertions.assertEquals(b.getFixedDepositId(), book.getFixedDepositId());
      }
*/    
}
