package fr.imt.cours.perez.rmi.server;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.rmi.RemoteException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SearchQueryTest {
	
	/*
	 * Test the method "String query(String search)" with the nominal case
	 * Use the JUnit 5 Assertions.assertEquals()
	 * */
	@Test
	public void testQueryNominalCase() throws RemoteException {
		//Create the searchQuery object
		SearchQuery searchQuery = new SearchQuery();
		
		//Assertion
		//assertEquals( [value expected], [returned value by the method under test])
		Assertions.assertEquals("Found", searchQuery.query("Reflection in Java"));
	}
	
	/*
	 * Test the method "String query(MyOwnObject myOwnObject)" with the nominal case
	 * Use Mockito to mock the object "MyOwnObject" and thus have an isolated and independant test
	 * Use the JUnit 5 Assertions.assertEquals()
	 * */
	@Test
	public void testQueryWithOwnObject() throws RemoteException, MyOwnException {
		SearchQuery searchQuery = new SearchQuery();

		MyOwnObject myOwnObject = mock(MyOwnObject.class);
		when(myOwnObject.returnQueryString()).thenReturn("Reflection in Java");
		
		Assertions.assertEquals("Found", searchQuery.query(myOwnObject));
	}
	
	/*
	 * Test the method "String query(String search)" with the nominal case
	 * Use the Hamcrest to have a semantic complement with JUnit 5
	 * */
	@Test
	public void testQueryNominalCaseWithHamcrest() throws RemoteException {
		SearchQuery searchQuery = new SearchQuery();
		
		//assertThat( [returned value by the method under test],  [hamcrest matcher])
		//Here the "hamcrest matcher" is "is([value expected])"
		assertThat(searchQuery.query("Reflection in Java"), is("Found"));
		//Assertions.assertEquals("Found", searchQuery.query("Reflection in Java"));
	}
	
	/*
	 * Test the method "String query(MyOwnObject myOwnObject)" with the exception case
	 * Verify that the good exception is thrown and the message in the exception is correct
	 * Use JUnit 5 Assertions.assertThrows()
	 */
	@Test
	public void testQueryException() throws RemoteException {
		SearchQuery searchQuery = new SearchQuery();
		
		MyOwnObject myOwnObject = null;
		
		//assertThrows( [Exception class expected], [lambda expression with the method that throws an exception], [exception message expected])
		Assertions.assertThrows(MyOwnException.class, ()->{searchQuery.query(myOwnObject);}, "My own exception is thrown !");
	}
}
