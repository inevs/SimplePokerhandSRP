package de.itagile.poker;

import java.util.Arrays;
import java.util.Comparator;

public class SimplePokerhandEvaluator {
    public String evaluate(String hand) {
        String[] cards = hand.split(" ");
        Arrays.sort(cards, new Comparator<String>() {
            @Override
            public int compare(String card1, String card2) {
                Integer rank1 = getRank(card1);
                Integer rank2 = getRank(card2);
                return rank1.compareTo(rank2);
            }

            private Integer getRank(String card) {
                String rankString = card.substring(1);
                int rank = 0;
                switch (rankString) {
                    case "J": rank = 11; break;
                    case "Q": rank = 12; break;
                    case "K": rank = 13; break;
                    case "A": rank = 14; break;
                    default: rank = Integer.parseInt(rankString);
                }
                return rank;
            }
        });
        return cards[1];
    }
}
