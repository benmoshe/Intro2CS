package week10.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import week10.LinkOfString;

class LinkOfStringTest {

	@Test
	void testLinkOfStringString() {
		String data = "abc";
		LinkOfString f = new LinkOfString(data);
		assertEquals(data, f.getData());
	}

	@Test
	void testIsLast() {
		String data = "abc";
		LinkOfString f = new LinkOfString(data);
		assertTrue(f.isLast());
	}
	/////// Make sure you know how to implement the additional JUnits - below ///
	/**
	@Test
	void testLinkOfStringStringLinkOfString() {
		fail("Not yet implemented");
	}

	@Test
	void testGetData() {
		fail("Not yet implemented");
	}

	@Test
	void testGetNext() {
		fail("Not yet implemented");
	}

	

	@Test
	void testSetNext() {
		fail("Not yet implemented");
	}
	*/
}
