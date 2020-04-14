package model;

import coms362.cards.abstractcomp.Player;

public class Timer {
    private String id;
    private String evtName;
    private int time;
    private Player player;

    public Timer(String id, String evtName, Player player, int time) {
        this.id = id;
        this.evtName = evtName;
        this.player = player;
        this.time = time;
    }
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEvtName() {
        return evtName;
    }

    public void setEvtName(String evtName) {
        this.evtName = evtName;
    }
    
    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
