package nl.youngcapital.atm.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import nl.youngcapital.atm.player.PlayerData;

@Repository
public class DataAccessObject {

	@PersistenceContext
	private EntityManager em;

	@Transactional
	public boolean create(PlayerData pd) {
		if (pd == null) {
			throw new IllegalStateException();
		}
		if (findByName(pd.getName()) == null) {
			em.persist(pd);
			return true;
		} else {
			return false;
		}

	}

	@Transactional
	public PlayerData findById(long id) {

		PlayerData pd = em.find(PlayerData.class, id);

		return pd;
	}

	@Transactional
	public PlayerData findByName(String name) {
		Query q =  em.createQuery("SELECT pd FROM PlayerData pd WHERE pd.name LIKE :name")
				.setParameter("name", name);
		PlayerData pd = null;
		try {
			pd = (PlayerData) q.getSingleResult();
		} catch (Exception e) {

		}
		
		
		return pd;
	}

	@Transactional
	public void delete(PlayerData pd) {
		em.remove(em.contains(pd) ? pd : em.merge(pd));

	}

	@Transactional
	public void update(PlayerData pd) {
		em.merge(pd);

	}

}
