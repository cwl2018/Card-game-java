# Card-game-java
## a gui card game using java

Setting:
1. the player has $100 starting money
2. the player plays against the computer
3. each side (player and computer) are given 3 cards each at the beginning after placing a bet
4. the player can at most change 2 cards each round.
5. the player loses if the hand is worse than the computers'


Rules to determine who has better cards:
1. JQK are regarded as special cards.
2. The one with more special cards wins.
3. If both have the same number of special cards, add the face values of the other
card(s) and take the remainder after dividing the sum by 10. The one with a bigger
remainder wins. (Note: Ace = 1).
4. The computer wins if both rule 2 and rule 3 cannot distinguish the winner.
