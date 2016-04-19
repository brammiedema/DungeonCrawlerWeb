package nl.youngcapital.atm.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import nl.youngcapital.atm.player.PlayerData;

public abstract class DataAccessObject {

	final private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("dungeoncrawler");

	public static void create(PlayerData pd) {

		System.out.println("create player entity");
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();

		if (pd.getId() == null || findById(pd.getId()).equals(null)) {
			em.persist(pd);
		} else {
			pd = em.merge(pd);
		}

		t.commit();
		em.close();
	}

	public static PlayerData findById(long id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		t.begin();
		PlayerData pd = (PlayerData) em.find(PlayerData.class, id);
		t.commit();
		em.close();
		return pd;
	}

	public static void update(PlayerData sp) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction t = em.getTransaction();
		sp = em.merge(sp);
		t.commit();
		em.close();
	}

}
