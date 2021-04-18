package a2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class A2Test {

	@Test
	void testAreMidsDiff() {
		assertEquals(false, A2.areMidsDiff(""));
		assertEquals(false, A2.areMidsDiff("$"));
		assertEquals(true, A2.areMidsDiff("23"));
		assertEquals(false, A2.areMidsDiff("44"));
		assertEquals(true, A2.areMidsDiff("22AB"));
		assertEquals(false, A2.areMidsDiff("2AAB"));
		assertEquals(false, A2.areMidsDiff("A22"));
		assertEquals(false, A2.areMidsDiff("AAA"));
		assertEquals(true, A2.areMidsDiff("AABC"));
		assertEquals(false, A2.areMidsDiff("abcdefaabcdefg"));
		assertEquals(true, A2.areMidsDiff("abcdef$abcdefg"));
		assertEquals(false, A2.areMidsDiff("aaaaaaaaaaaaaaaa"));
		assertEquals(true, A2.areMidsDiff("aaaaaaa$aaaaaaaa"));
		assertEquals(false, A2.areMidsDiff("abcdefgAAAabcdefg"));

	}

	@Test
	void testProtectLittles() {
		assertEquals("", A2.protectLittles(""));
		assertEquals(".bB", A2.protectLittles("b"));
		assertEquals("B", A2.protectLittles("B"));
		assertEquals("å", A2.protectLittles("å"));
		assertEquals("$", A2.protectLittles("$"));
		assertEquals("1.aABCDEF.xX", A2.protectLittles("1aBCDEFx"));
		assertEquals("1Z$B.bB.yY", A2.protectLittles("1Z$Bby"));
		assertEquals(".aA.bB.cC.dD.eE.fF.gG.hH.iI.jJ.kK", A2.protectLittles("abcdefghijk"));
		assertEquals(".lL.mM.nN.oO.pP", A2.protectLittles("lmnop"));
		assertEquals(".qQ.rR.sS.tT.uU.vV.wW.xX.yY.zZ", A2.protectLittles("qrstuvwxyz"));
	}

	@Test
	void testPutCapsLast() {
		assertEquals("", A2.putCapsLast(""));
		assertEquals("%", A2.putCapsLast("%"));
		assertEquals("z", A2.putCapsLast("z"));
		assertEquals("A", A2.putCapsLast("A"));
		assertEquals("Îccc", A2.putCapsLast("Îccc"));
		assertEquals("cccI", A2.putCapsLast("Iccc"));
		assertEquals("abcdxy$zxABCDZ", A2.putCapsLast("abcdxy$zABCDxZ"));
		assertEquals("1z$aàēĤƀ", A2.putCapsLast("1z$aàēĤƀ"));
		assertEquals(".$%!ABCDEFGHIJKLMNOPQRSTUVWXYZ", A2.putCapsLast("ABCDE.FGHIJKLMNO$PQ%RSTUV!WXYZ"));
	}

	@Test
	void testExactly1() {
		assertEquals(true, "".contains(""));
		assertEquals(true, A2.exactly1("", ""));
		assertEquals(false, A2.exactly1("a", ""));
		assertEquals(false, A2.exactly1("", "a"));
		assertEquals(true, A2.exactly1("abcb", "c"));
		assertEquals(false, A2.exactly1("acbcb", "c"));
		assertEquals(false, A2.exactly1("abbb", "c"));
		assertEquals(true, A2.exactly1("abbc", "ab"));
		assertEquals(false, A2.exactly1("aaa", "a"));
		assertEquals(false, A2.exactly1("abbbabc", "ab"));
		assertEquals(true, A2.exactly1("abbba bc", "ab"));
		assertEquals(false, A2.exactly1("what if what if what", "what"));
		assertEquals(false, A2.exactly1("what if what if what", "what if"));
		assertEquals(false, A2.exactly1("what if what if what", "what if what"));
		assertEquals(true, A2.exactly1("what if what if what", "what if what if"));
	}

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

	/**
	 * Return n if s consists of n >= 0 catenations of x with itself. <br>
	 * Otherwise, return -1.<br>
	 * Examples: <br>
	 * For nCat("", "") return 0<br>
	 * For nCat("", "fg") return 0 ("" is "gf" catenated with itself 0 times)<br>
	 * For nCat("xxx", "") return -1<br>
	 * For nCat("x", "x") return 1<br>
	 * For nCat("xx", "x") return 2 <br>
	 * For nCat("ccbbbb", "bb") return -1 <br>
	 * For nCat("bbbbcc", "bb") return -1 <br>
	 * For nCat("bbbbbb", "bb") return 3 <br>
	 * For nCat("bbbbbb", "bbb") return 2 <br>
	 * For nCat("bbbbbb", "bbbb") return -1 <br>
	 * For nCat("bbbbbb", "bbbbb") return -1 <br>
	 * For nCat("bbbbbb", "bbbbbb") return 1 <br>
	 * For nCat("bbbbbb", "bbbbbbb") return -1 <br>
	 * For nCat("xyzxyz", "xyz") return 2 <br>
	 * For nCat("xyzxyz", "xyzxyz") return 1 <br>
	 * For nCat(s, s) (for any s not the empty string) return 1
	 */
	@Test
	void testNCat() {
		assertEquals(1, A2.nCat("a", "a"));
		assertEquals(0, A2.nCat("", "fg"));
		assertEquals(-1, A2.nCat("xxx", ""));
		assertEquals(1, A2.nCat("x", "x"));
		assertEquals(-1, A2.nCat("ccbbbb", "bb"));
		assertEquals(3, A2.nCat("bbbbbb", "bb"));
		assertEquals(3, A2.nCat("xyzxyzxyz", "xyz"));
		assertEquals(1, A2.nCat("xyz", "xyz"));
	}

	/**
	 * For s = "" return 0<br>
	 * For s = "xxxxxxxxx" return 1 <br>
	 * For s = "xyxyxyxy" return 2 <br>
	 * For s = "012012012012" return 3 <br>
	 * For s = "hellohellohello" return 5 <br>
	 * For s = "hellohelloworld" return 15 <br>
	 * For s = "hellohell" return 9
	 */
	@Test
	void testShortest() {
		assertEquals(0, A2.shortest(""));
		assertEquals(1, A2.shortest("xxxxxxxxx"));
		assertEquals(2, A2.shortest("xyxyxyxy"));
		assertEquals(3, A2.shortest("012012012012"));
		assertEquals(5, A2.shortest("hellohellohello"));
		assertEquals(15, A2.shortest("hellohelloworld"));
		assertEquals(9, A2.shortest("hellohell"));

	}

}
