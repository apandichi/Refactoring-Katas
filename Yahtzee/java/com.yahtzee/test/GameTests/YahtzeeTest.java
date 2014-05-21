package GameTests;

import Game.Yahtzee;
import org.junit.*;
import static org.junit.Assert.*;

public class YahtzeeTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        int actual = Yahtzee.chance(2, 3, 4, 5, 1);
        assertEquals(expected, actual);
        Assert.assertEquals(16, Yahtzee.chance(3, 3, 4, 5, 1));
    }

    @Test
    public void yahtzee_scores_50() {
        int expected = 50;
        int actual = Yahtzee.yahtzee(4, 4, 4, 4, 4);
        assertEquals(expected, actual);
        Assert.assertEquals(50, Yahtzee.yahtzee(6, 6, 6, 6, 6));
        Assert.assertEquals(0, Yahtzee.yahtzee(6, 6, 6, 6, 3));
    }

    @Test public void test_1s() {
        assertTrue(Yahtzee.ones(1, 2, 3, 4, 5) == 1);
        Assert.assertEquals(2, Yahtzee.ones(1, 2, 1, 4, 5));
        Assert.assertEquals(0, Yahtzee.ones(6, 2, 2, 4, 5));
        Assert.assertEquals(4, Yahtzee.ones(1, 2, 1, 1, 1));
    }

    @Test
    public void test_2s() {
        Assert.assertEquals(4, Yahtzee.twos(1, 2, 3, 2, 6));
        Assert.assertEquals(10, Yahtzee.twos(2, 2, 2, 2, 2));
    }

    @Test
    public void test_threes() {
        Assert.assertEquals(6, Yahtzee.threes(1, 2, 3, 2, 3));
        Assert.assertEquals(12, Yahtzee.threes(2, 3, 3, 3, 3));
    }

    @Test
    public void fours_test() 
    {
        Assert.assertEquals(12, new Yahtzee(4, 4, 4, 5, 5).fours());
        Assert.assertEquals(8, new Yahtzee(4, 4, 5, 5, 5).fours());
        Assert.assertEquals(4, new Yahtzee(4, 5, 5, 5, 5).fours());
    }

    @Test
    public void fives() {
        Assert.assertEquals(10, new Yahtzee(4, 4, 4, 5, 5).fives());
        Assert.assertEquals(15, new Yahtzee(4, 4, 5, 5, 5).fives());
        Assert.assertEquals(20, new Yahtzee(4, 5, 5, 5, 5).fives());
    }

    @Test
    public void sixes_test() {
        Assert.assertEquals(0, new Yahtzee(4, 4, 4, 5, 5).sixes());
        Assert.assertEquals(6, new Yahtzee(4, 4, 6, 5, 5).sixes());
        Assert.assertEquals(18, new Yahtzee(6, 5, 6, 6, 5).sixes());
    }

    @Test
    public void one_pair() {
        Assert.assertEquals(6, Yahtzee.score_pair(3, 4, 3, 5, 6));
        Assert.assertEquals(10, Yahtzee.score_pair(5, 3, 3, 3, 5));
        Assert.assertEquals(12, Yahtzee.score_pair(5, 3, 6, 6, 5));
    }

    @Test
    public void two_Pair() {
        Assert.assertEquals(16, Yahtzee.two_pair(3, 3, 5, 4, 5));
        Assert.assertEquals(0, Yahtzee.two_pair(3, 3, 5, 5, 5));
    }

    @Test
    public void three_of_a_kind() 
    {
        Assert.assertEquals(9, Yahtzee.three_of_a_kind(3, 3, 3, 4, 5));
        Assert.assertEquals(15, Yahtzee.three_of_a_kind(5, 3, 5, 4, 5));
        Assert.assertEquals(0, Yahtzee.three_of_a_kind(3, 3, 3, 3, 5));
    }

    @Test
    public void four_of_a_knd() {
        Assert.assertEquals(12, Yahtzee.four_of_a_kind(3, 3, 3, 3, 5));
        Assert.assertEquals(20, Yahtzee.four_of_a_kind(5, 5, 5, 4, 5));
        Assert.assertEquals(0, Yahtzee.three_of_a_kind(3, 3, 3, 3, 3));
    }

    @Test
    public void smallStraight() {
        Assert.assertEquals(15, Yahtzee.smallStraight(1, 2, 3, 4, 5));
        Assert.assertEquals(15, Yahtzee.smallStraight(2, 3, 4, 5, 1));
        Assert.assertEquals(0, Yahtzee.smallStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void largeStraight() {
        Assert.assertEquals(20, Yahtzee.largeStraight(6, 2, 3, 4, 5));
        Assert.assertEquals(20, Yahtzee.largeStraight(2, 3, 4, 5, 6));
        Assert.assertEquals(0, Yahtzee.largeStraight(1, 2, 2, 4, 5));
    }

    @Test
    public void fullHouse() {
        Assert.assertEquals(18, Yahtzee.fullHouse(6, 2, 2, 2, 6));
        Assert.assertEquals(0, Yahtzee.fullHouse(2, 3, 4, 5, 6));
    }
}