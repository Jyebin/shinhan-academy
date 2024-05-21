package ko.co.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class TestSample {
	
	@Before
	public void before() {
		System.out.println("before");
	}
	
	@Test
	public void test() {
		System.out.println("테스트");
		int count = 20;
		assertEquals(30,count);
		assertTrue(true);
	}
	
	@Test
	public void test2() {
		System.out.println("테스트2");
	}
	
	@After
	public void after() {
		System.out.println("after");
	}
	@BeforeClass
	public static void beforeClass() {
		System.out.println("처음 한번만");
	}
	
	@AfterClass
	public static void afterClass() {
		System.out.println("마지막 한번만");
	}
}
//JUnit창을 봤을 때 초록색으로 뜨면 테스트에 성공한 것