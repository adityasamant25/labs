package com.example;

import org.assertj.core.api.BDDAssertions;
import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    @Test
    public void should_return_marcin_from_poland() {
    
    	//given
    	Country country = Country.POLAND;
    	
    	//when
    	Person person = new MyFactory().build(country);
    	
    	//then
    	BDDAssertions.then(person.name).isEqualTo("Marcin");
    }
}
