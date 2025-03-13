package com.calculator.service;

import com.calculator.sevice.CalcService;
import org.junit.Assert;
import org.junit.Test;

public class CalcServiceTest {
    @Test
    public void sumTest(){
        CalcService calcService = new CalcService();
        int firstOperand = 2;
        int secondOperand = 3;
        int expected = 5;
        
        int result = calcService.sum(firstOperand, secondOperand);
        Assert.assertEquals(expected, result);
    }
    @Test
    public void sumNullTest(){
        CalcService calcService = new CalcService();
        Integer firstOperand = null;
        int secondOperand = 3;

        Assert.assertThrows(NullPointerException.class, () -> calcService.sum(firstOperand, secondOperand));
    }
}
