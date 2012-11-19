package org.shmztko.model;

import net.java.ao.Entity;
import net.java.ao.OneToMany;

public interface User extends Entity {

	public String getCardName();
	public void setCardName(String cardName);

	public String getEmail();
	public void setEmail(String email);

	public String getLoginUrl();
	public void setLoginUrl(String loginUrl);

	@OneToMany
	public Statistic[] getStatistics();
}
