# Cards Toolkit Release Notes

4/19/2020 PickupSP implementation, Better addToPile support, Remote Timer support

*** 
We now support both PU52 and PU52MP. The single player implementation follows exactly the design documented in class notes. 

The classes changed or added to support PU52 are GameFactoryFactory, PickupInitCmd, P52SPRules, and P52SPGameFactory.  
 
  
***
We now support setting a timer in the browser that returns a (client-specified) event at the when the specified time expires. 

The Timer support includes a model class (Timer), a remoteEvent command (SetTimerRemote) and an inbound event (TimerEvent) to simplify use when only one timer is ever active. 

registerEvents() in the PickupRules has been enhanced to register TimerEvent for unmarshalling. The rulesDispatch hierarchy has also been modified to support dispatch of the new event. 
  
***
Prior releases have been using incomplete or partially implemented RemoteEvents extracted from an early prototype. We have completed several of the remote events, deprecated one, and added some new events to give better control how cards are inserted into a Pile or Deck. 

AddToPileRemote has been deprecated. It was incomplete, and would have duplicated the behavior of the new InsertAtPileTopRemote. 

Also new is InsertAtPileBottomRemote. This operation is necessary to meet the War requirements for handling pot sweeps. 

RemoveFromPileRemote partial implementation has been improved. It now actually removes from the named pile. Create Pile now also has the desired effect in both the model and the browser.

PickupInitCmd and PickupMove have been modified to use the new card/pile manipulation commands. 
*** 
Other modified classes: 

- some obsolete code has been removed from  the InitGameEvent handler in PickupRules. 

===

You can get a detailed view of all changes from eclipse  BEFORE YOU MERGE by right-clicking on the project and selecting compareWith > Branch, Tag, or Reference > then in the window that opens select remote tracking > origin/master. This is your MOST RELIABLE and fastest way to inventory prospective changes. Since you can browse the changes in any order and see them side by side, it is the preferred means of making sense of a new "push". 

A similar view is available from the Gitlab "History" tab. Here you can walk through commits one by one. Commits are accompanied by a commit comment that usually identifies the purpose of the commit. When dealing with a large codebase, comments are generally not "browsable" in a useful way and often not complete. The source code control system generally offers a much 
more productive means of identifing and understanding changes.

