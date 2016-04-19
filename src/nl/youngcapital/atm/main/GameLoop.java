package nl.youngcapital.atm.main;

import java.util.Scanner;

import nl.youngcapital.atm.combatsystem.CombatSystem;
import nl.youngcapital.atm.combatsystem.FightableCharacter;
import nl.youngcapital.atm.data.DataAccessObject;
import nl.youngcapital.atm.events.Encounter;
import nl.youngcapital.atm.events.Event;
import nl.youngcapital.atm.nonplayercharacters.NonPlayableCharacter;
import nl.youngcapital.atm.nonplayercharacters.Shop;
import nl.youngcapital.atm.player.Player;
import nl.youngcapital.atm.player.PlayerData;
import nl.youngcapital.atm.world.Square;
import nl.youngcapital.atm.world.World;

public class GameLoop {

	World gw;
	private Scanner s;
	private final CombatSystem cb = CombatSystem.getInstance();

	public void run() {
		
		gw = new World();
		System.out.println("Created world");
		Player p = new Player("player1");
		System.out.println("Created Player");
		s = new Scanner(System.in);
		System.out.println("You wake up and remember nothing!");
		System.out.println("You find yourself in a strange landscape.");
		while (true) {

			System.out.println("You see these accessible directions: ");
			System.out.println(p.getPlayerData().getX() + " " + p.getPlayerData().getY() + " " + p.getPlayerData().getZ());
			System.out.println(gw.getPossibleDirections(p.getPlayerData().getX(), p.getPlayerData().getY(),
					p.getPlayerData().getZ()));
			String direction = s.next();
			if (!direction.equals("q") || !direction.equals("quit")) {

				switch (direction.toLowerCase()) {
				case "north":
					gw.moveCharacterNorth(p);
					break;

				case "south":
					gw.moveCharacterSouth(p);
					break;

				case "east":
					gw.moveCharacterEast(p);
					break;

				case "west":
					gw.moveCharacterWest(p);
					break;

				default:
					continue;
				}

			} else {
				break;
			}
			handleTurn(p);
		}

	}

	private void handleTurn(Player p) {
		System.out.println("x: " + p.getPlayerData().getX());
		System.out.println("y: " + p.getPlayerData().getY());
		System.out.println("z: " + p.getPlayerData().getZ());

		Square currentSquare = gw.getCurrentSquare(p.getPlayerData().getX(), p.getPlayerData().getY(),
				p.getPlayerData().getZ());
		if (currentSquare.hasEvent()) {
			Event ev = currentSquare.getEvent();

			if (ev instanceof Encounter) {
				Encounter en = (Encounter) ev;

				System.out.println("You see a " + en.getDescription());

				if (en.isFriendly()) {
					System.out.println(en.getDescription() + " appears to be friendly");
					System.out.println("What do you do?");
				} else {
					System.out.println(en.getDescription() + " charges you! DEFEND!");
					FightableCharacter t = en.getNonPlayableCharacter();
					// TODO:: make a function call for combat
					// combat initated
					while (cb.fight(t, p)) {

						cb.fight(p, t);
						System.out.println("Player: " + p.getHealth());
						System.out.println("Enemy: " + t.getHealth());
					}
				}
				String action = s.next();
				NonPlayableCharacter npc = en.getNonPlayableCharacter();
				if (action.equals("attack")) {
					if (npc instanceof FightableCharacter) {
						FightableCharacter t = (FightableCharacter) npc;
						// TODO:: make a function call for combat
						// combat initaited
						while (cb.fight(p, t)) {
							cb.fight(t, p);
						}
					}

				} else if (action.equals("shop")) {
					if (npc instanceof Shop) {
						Shop shop = (Shop) npc;

					}
				} else {
					System.out.println("This is not a shop");

				}

			}

		} else {
			System.out.println("What do you do?");
			String action = s.next();
			if (action.equals("saved")) {
				PlayerData pd = p.getPlayerData();
				DataAccessObject.create(pd);
				System.out.println("game saved");
			}
		}
	}

}
