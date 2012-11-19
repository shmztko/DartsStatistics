package org.shmztko.model;

import java.util.Date;

import net.java.ao.Entity;

public interface Statistic extends Entity {

	public User getUser();
	public void setUser(User user);

	public String getGameName();
	public void setGameName(String gameName);

	public double getScore();
	public void setScore(double score);

	public Date getPlayedAt();
	public void setPlayedAt(Date playedAt);
}
