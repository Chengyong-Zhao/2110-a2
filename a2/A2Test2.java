package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A2Test2 {

	@Test
	void testAreAnagrams() {
		assertEquals(true, A2.areAnagrams("", ""));
		assertEquals(true, A2.areAnagrams("noon", "noon"));
		assertEquals(true, A2.areAnagrams("mary", "army"));
		assertEquals(true, A2.areAnagrams("tom marvolo riddle", "i am lordvoldemort"));
		assertEquals(false, A2.areAnagrams("tommarvoloriddle", "i am lordvoldemort"));
		assertEquals(false, A2.areAnagrams("world", "hello"));
		assertEquals(false, A2.areAnagrams("a", "A"));
	}
}
