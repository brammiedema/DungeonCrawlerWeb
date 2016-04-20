package nl.youngcapital.atm.rest;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.atm.combatsystem.CombatSystem;
import nl.youngcapital.atm.combatsystem.FightableCharacter;
import nl.youngcapital.atm.data.DataAccessObject;
import nl.youngcapital.atm.events.ChestEvent;
import nl.youngcapital.atm.events.Encounter;
import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.inventory.InventoryManager;
import nl.youngcapital.atm.itembehaviour.Lootable;
import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;
import nl.youngcapital.atm.nonplayercharacters.Shop;
import nl.youngcapital.atm.player.Player;
import nl.youngcapital.atm.world.Square;
import nl.youngcapital.atm.world.World;

@RequestMapping("/api")
@RestController
public class RestApi {
	public final static String DEFAULT_PLAYER_TAG = "player";
	public final static String DEFAULT_NPC_TAG = "npc";
	public final static String DEFAULT_TARGET_TAG = "target";
	public final static String DEFAULT_WORLD_TAG = "world";
	public final static String DEFAULT_COMBAT_TAG = "combat";
	public final static String DEFAULT_SHOP_TAG = "shop";

	public final static String lOGGED_IN_CHARACTER_FOUND_MESSAGE = "An active character is present, please save or logout and try again.";
	public final static String NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE = "no active player found, please login or create a character";
	public final static String IN_COMBAT_MESSAGE = "you are in combat resolve before taking this action";

	@RequestMapping("/load/{id}")
	public String load(@PathVariable(value = "id") String id, HttpSession session) {

		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}
		if (hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}

		System.out.println("id: " + id);

		Player p = new Player(DataAccessObject.findById(Long.parseLong(id)));

		session.setAttribute(DEFAULT_PLAYER_TAG, p);

		return "load successful";
	}

	@RequestMapping("/save")
	public String create(HttpSession session) {

		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}
		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}

		Player p = (Player) session.getAttribute(DEFAULT_PLAYER_TAG);

		DataAccessObject.create(p.getPlayerData());
		session.setAttribute(DEFAULT_PLAYER_TAG, p);

		return "player saved: " + p.getPlayerData().getName();
	}

	@RequestMapping("/create")
	public String create(String name, HttpSession session) {

		if (hasPlayer(session)) {
			return lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}

		Player p = new Player(name);
		session.setAttribute(DEFAULT_PLAYER_TAG, p);

		return "Thanks for making the character named: "
				+ ((Player) session.getAttribute(DEFAULT_PLAYER_TAG)).getPlayerData().getName();
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}

		String name = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG)).getPlayerData().getName();

		session.invalidate();

		return "logged out " + name;
	}

	@RequestMapping("/shop")
	public String shop(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}
		if (availableShop(session)) {

		}

		String name = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG)).getPlayerData().getName();

		session.invalidate();

		return "logged out " + name;
	}

	@RequestMapping("/welcome")
	public String welcome(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}

		System.out.println(((Player) session.getAttribute(DEFAULT_PLAYER_TAG)).getPlayerData().getName());
		return "welcome, " + ((Player) session.getAttribute(DEFAULT_PLAYER_TAG)).getPlayerData().getName();
	}

	@RequestMapping("/attack")
	public String attack(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}

		Player p = (Player) session.getAttribute(DEFAULT_PLAYER_TAG);
		NonPlayableCharacter t = (NonPlayableCharacter) session.getAttribute(DEFAULT_NPC_TAG);

		CombatSystem cs = CombatSystem.getInstance();

		if (p.getHealth() < 0) {
			session.setAttribute(DEFAULT_COMBAT_TAG, false);

			return "you are dead, only hardcore mode available your data has been deleted.... or is it?";
		} else if (t.getHealth() < 0) {

			return "Your enemy falls before you.";
		}

		cs.fight(p, t);
		cs.fight(t, p);
		return "the outcome is: player hp: " + p.getHealth() + " target hp: " + t.getHealth();
	}

	@RequestMapping("/reset")
	public void reset(HttpSession session) {
		session.invalidate();

	}

	@RequestMapping("/move")
	public String move(String direction, HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		World world = getWorld(session);
		Player p = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG));

		switch (direction.toLowerCase()) {

		case "north":
			world.moveCharacterNorth(p);
			break;

		case "south":
			world.moveCharacterSouth(p);
			break;

		case "east":
			world.moveCharacterEast(p);
			break;

		case "west":
			world.moveCharacterWest(p);
			break;

		default:
			break;
		}

		return world.getSquare(p.getPlayerData().getX(), p.getPlayerData().getY(), p.getPlayerData().getZ())
				.getDescription();
	}

	@RequestMapping("/directions")
	public String openDirections(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}

		World world = getWorld(session);
		Player p = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG));
		return world.getPossibleDirections(p.getPlayerData().getX(), p.getPlayerData().getY(),
				p.getPlayerData().getZ());
	}

	@RequestMapping("/getLoot")
	public String lootableItems(HttpSession session) {
		
		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		if (inCombat(session)) {
			return IN_COMBAT_MESSAGE;
		}

		Player p = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG));
		World world = getWorld(session);

		Square sq = world.getSquare(p.getPlayerData().getX(), p.getPlayerData().getY(), p.getPlayerData().getZ());
		
		if (sq.getEvent() instanceof Lootable){
			Lootable loot = (Lootable) sq.getEvent();
			InventoryManager.getInstance().addItem(p.getPlayerData().getCs().getInventory(), loot.take());
			
		}else{
			return "Failed to pick up item";
		}
		
		return "You took the item" ;
	}

	@RequestMapping("/look")
	public String look(HttpSession session) {

		if (!hasPlayer(session)) {
			return NO_lOGGED_IN_CHARACTER_FOUND_MESSAGE;
		}
		StringBuilder sb = new StringBuilder();

		Player p = ((Player) session.getAttribute(DEFAULT_PLAYER_TAG));
		World world = getWorld(session);

		Square sq = world.getSquare(p.getPlayerData().getX(), p.getPlayerData().getY(), p.getPlayerData().getZ());

		if (sq.hasEvent()) {
			Event ev = sq.getEvent();

			if (ev instanceof Encounter) {
				Encounter en = (Encounter) ev;

				sb.append("You see a " + en.getDescription());

				FightableCharacter t = en.getNonPlayableCharacter();
				session.setAttribute(DEFAULT_NPC_TAG, t);

				if (en.isFriendly()) {
					sb.append(en.getDescription() + " appears to be friendly");
					sb.append("What do you do?");
					session.setAttribute(DEFAULT_COMBAT_TAG, false);

					if (en instanceof Shop) {
						session.setAttribute(DEFAULT_SHOP_TAG, true);
					} else {
						session.setAttribute(DEFAULT_SHOP_TAG, false);
					}

				} else {
					sb.append(en.getDescription() + " charges you! DEFEND!");
					session.setAttribute(DEFAULT_COMBAT_TAG, true);
					session.setAttribute(DEFAULT_SHOP_TAG, false);

				}

			}
		} else {
			sb.append("There is nothing to do.");
		}

		return sb.toString();
	}

	private boolean inCombat(HttpSession session) {

		if (session.getAttribute(DEFAULT_COMBAT_TAG) == null) {
			return false;
		}

		return (boolean) session.getAttribute(DEFAULT_COMBAT_TAG);

	}

	private boolean availableShop(HttpSession session) {
		if (session.getAttribute(DEFAULT_SHOP_TAG) == null) {
			return false;
		}

		return (boolean) session.getAttribute(DEFAULT_SHOP_TAG);
	}

	private World getWorld(HttpSession session) {
		if (session.getAttribute(DEFAULT_WORLD_TAG) == null) {
			session.setAttribute(DEFAULT_WORLD_TAG, new World());
		}

		return (World) session.getAttribute(DEFAULT_WORLD_TAG);
	}

	private boolean hasPlayer(HttpSession session) {

		return session.getAttribute(DEFAULT_PLAYER_TAG) != null;
	}
}
