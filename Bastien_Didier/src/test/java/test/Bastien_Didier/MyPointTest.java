package test.Bastien_Didier;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Random;

import org.junit.Test;
import org.mockito.Mock;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import test.Bastien_Didier.MyPoint;


public class MyPointTest {

		
	@Test
	public void Constructor() {
		
		MyPoint pOrigine = new MyPoint();
		assertTrue(pOrigine.getX() == 0);
		assertTrue(pOrigine.getY() == 0);
		
		
	}
	
	@Test
	public void Test_getX() {
		
		MyPoint pOrigine 	= new MyPoint();
		MyPoint p2 		 	= new MyPoint();
		MyPoint pOrigine1 	= new MyPoint();
		MyPoint p3 		 	= new MyPoint();
		MyPoint p20 		= new MyPoint();
	
		p2.setX(12);
		p3.setX(-1);
		p20.setX(2048);
		pOrigine1.setX(15.2151);
		
		assertTrue(pOrigine.getX() == 0);
		assertTrue(p2.getX() == 12);
		assertTrue(p20.getX() == 2048);
		assertTrue(pOrigine1.getX() == 15.2151);
		
	}
	
	@Test
	public void Test_getY() {
			
			MyPoint pOrigine 	= new MyPoint();
			MyPoint p2 		 	= new MyPoint();
			MyPoint pOrigine1 	= new MyPoint();
			MyPoint p3 		 	= new MyPoint();
			MyPoint p20 		= new MyPoint();
		
				
			p2.setY(12);
			p3.setY(-1);
			p20.setY(2048);
			pOrigine1.setY(15.2151);
			
			
			assertTrue(pOrigine.getY() == 0);
			assertTrue(p2.getY() == 12);
			assertTrue(p20.getY() == 2048);
			assertTrue(pOrigine1.getY() == 15.2151);
			
	}
	
	@Test
	public void Test_setY() {
		
		MyPoint pOrigine 	= new MyPoint();
		
		pOrigine.setY(12);
		pOrigine.setY(Math.sqrt(-42));

		
		assertTrue(pOrigine.getY() == 12);
		
	}
	
	@Test
	public void Test_setX() {
		
		MyPoint pOrigine 	= new MyPoint();
		
		pOrigine.setX(12);
		pOrigine.setX(Math.sqrt(-42));
		
		assertTrue(pOrigine.getX() == 12);
		
	}
	
	@Test
	public void Constructor3()
	{
		
		MyPoint p = new MyPoint();
		MyPoint p2 = new MyPoint(p);
		MyPoint p12 = new MyPoint(12,5);
		MyPoint p1 = new MyPoint(p12);
		
		
		assertTrue(p2.getX() == 0);
		assertTrue(p2.getY() == 0);
		assertTrue(p1.getX() == 12);
		assertTrue(p1.getY() == 5);
		
		
	}
	
	@Test
	public void Test_Scale() {
		
		MyPoint p = new MyPoint();
		MyPoint p12 = new MyPoint(12,5);
		MyPoint p123 = new MyPoint(12,5);
		
		MyPoint pClone = p.scale(0);
		MyPoint p12Clone = p12.scale(2);
		MyPoint p123Clone = p123.scale(-1);
		
		
		assertTrue(pClone.getX() == 0);
		assertTrue(pClone.getY() == 0);
		assertTrue(p12Clone.getX() == 12*2);
		assertTrue(p12Clone.getY() == 5*2);
		assertTrue(p123Clone.getX() == 12*-1);
		assertTrue(p123Clone.getY() == 5*-1);
		
		
	}
	
	@Test
	public void Test_horizontalSymmetry() {
		
		MyPoint p = new MyPoint();
		MyPoint p1 = new MyPoint();
		MyPoint p2 = new MyPoint();
		MyPoint p5 = new MyPoint(-1,5);
		MyPoint p3 = new MyPoint();
		
		p2 	=  p1.horizontalSymmetry(p1);
		p3 	=  p5.horizontalSymmetry(p5);
		
		try {
			p 	=  p.horizontalSymmetry(null);
		}catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
		
		 assertTrue(p2.getY() == p1.getY() && p2.getX() == p1.getX());
		 assertTrue(p3.getY() == 5 && p3.getX() == -1);
	
	}
	
	@Test public void testCentralSymmetryNULL ( ) {
		try {
			
			new MyPoint ( 10 , 20 ).centralSymmetry ( null ) ;
			
		}
		catch(IllegalArgumentException e)
		{
			assertTrue(true);
		}
		catch(Exception e)
		{
			fail("Not good exception raised");
			
		}
		assertTrue(true);
	}
	
	
	 @Mock
	Random random1;
	
	@Mock
	Random random2;
	
	 @Test
    public void testSetPoint(){
	 
		MyPoint p = new MyPoint();
		random1 = mock(Random.class);
		random2 = mock(Random.class);
		when(random1.nextDouble()).thenReturn(1d);
		when(random2.nextDouble()).thenReturn(2d);
		p.setPoint(random1, random2);

		assertTrue(1d == p.getX());
		assertTrue(2d == p.getY());
	
    }
}
