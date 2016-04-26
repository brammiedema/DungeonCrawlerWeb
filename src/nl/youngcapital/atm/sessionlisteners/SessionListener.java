package nl.youngcapital.atm.sessionlisteners;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import nl.youngcapital.atm.data.DataAccessObject;
import nl.youngcapital.atm.player.PlayerData;
import nl.youngcapital.atm.rest.RestApi;

@WebListener
public class SessionListener implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent createSessionEvent) {
		System.out.println("sessionCreated");
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent invalidateSessionEvent) {
		if (invalidateSessionEvent.getSession().getAttribute("dao") instanceof DataAccessObject) {
			DataAccessObject dao = (DataAccessObject) invalidateSessionEvent.getSession().getAttribute("dao");
			PlayerData pd = dao.findByName(
					(String) invalidateSessionEvent.getSession().getAttribute(RestApi.DEFAULT_PLAYER_ID_TAG));
			pd.setCurrentSessionId(null);
			dao.update(pd);
			System.out.println("Session destoryed correctly");
		} else{
			throw new IllegalStateException("Session not correctly destroyed");
		}
	}
}