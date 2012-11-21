package org.shmztko.model;

import java.util.Date;

import net.java.ao.Entity;

public interface Statistic extends Entity {

	public String getGameName();
	public void setGameName(String gameName);

	public String getGameFormat();
	public void setGameFormat(String gameFormat);

	public String getScore();
	public void setScore(String score);

	public Date getPlayedAt();
	public void setPlayedAt(Date playedAt);

	public int getNumberOfPlayers();
	public void setNumberOfPlayers(int numberOfPlayers);

	public User getUser();
	public void setUser(User user);
}
