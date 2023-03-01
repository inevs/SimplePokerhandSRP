package de.itagile.poker;

import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class PokerhandEvaluatorTest {
    SimplePokerhandEvaluator evaluator = new SimplePokerhandEvaluator();

    @Test
    public void findsHighcardOutOfTwo() throws Exception {
        assertThat(evaluator.evaluate("C2 C3"), equalTo("C3"));
        assertThat(evaluator.evaluate("C2 C4"), equalTo("C4"));
        assertThat(evaluator.evaluate("C4 C2"), equalTo("C4"));
    }

    @Test
    public void findsHighcardIgnoringColor() {
        assertThat(evaluator.evaluate("H2 C3"), equalTo("C3"));
    }


    @Test
    public void findsHighcardWith10() throws Exception {
        assertThat(evaluator.evaluate("C4 C10"), equalTo("C10"));
    }

    @Test
    public void findsHighcardWithFaceCards() throws Exception {
        assertThat(evaluator.evaluate("C10 CJ"), equalTo("CJ"));
        assertThat(evaluator.evaluate("CJ CQ"), equalTo("CQ"));
        assertThat(evaluator.evaluate("CQ CK"), equalTo("CK"));
        assertThat(evaluator.evaluate("CK CA"), equalTo("CA"));
    }
}
