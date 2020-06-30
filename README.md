# Object Oriented Design Term Project

This project contains three different card games. It contains war, multiplayer 52 pickup and singleplayer 52 pickup. 

Initially, we were provided with a multiplayer game of 52 pickup. Our goal was to implement the singleplayer version of the game and war by making the **least** amount of changes necessary. 


HOW TO PLAY:

Put these two URLs in the browser
  
Host:
http://localhost:8080/cards362/?host&game=WAR&player=1
 
Player 2:
http://localhost:8080/cards362/?player=2
  
After clicking the deal button, two piles will appear. The bottom deck is player 1's deck, and the top belongs to player 2.
  
To play, each player must click on their respective deck. So if I'm player 1, I click on the
 bottom deck and a card will be revealed. 
 
When both players have revealed 1 card, the winner must click on the card they revealed using their browser and both cards will be placed into their deck. So in example player 2 (top player) would click on their king they revealed in order to put the card at the bottom of their deck. In the event of a tie, player 1 must click on the revealed card and wins by default. The winner must go first and reveal a card before the other player can go. So again, player 2 would click their facedown deck to reveal a card for the next round.

If the winner places a card after they won the last round, and the other player attempts to draw a card and nothing happens, have the winner place another card down. (It seems to fix a small bug that occurs).
 
