package nl.youngcapital.atm.world;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import nl.youngcapital.atm.player.Player;

public class World {
	private Square[][][] world;
	final static public int MAX_X_SIZE_WORLD = 25;
	final static public int MAX_Y_SIZE_WORLD = 25;
	final static public int MAX_Z_SIZE_WORLD = 6;

	public Square getCurrentSquare(int x, int y, int z) {
		return world[z][y][x];

	}

	public String getPossibleDirections(int x, int y, int z) {
		StringBuilder sb = new StringBuilder();
		sb.append("The direction(s) ");

		List<String> directions = new ArrayList<String>(4);

		int southOffset = (y - 1 < 0) ? 0 : 1;
		int northOffset = (y + 1 > MAX_Y_SIZE_WORLD) ? 0 : 1;
		int westOffset = (x - 1 < 0) ? 0 : 1;
		int eastOffset = (x + 1 > MAX_X_SIZE_WORLD) ? 0 : 1;


		if (!(this.world[z][southOffset][x] instanceof LemonSquare)) {
			directions.add("south");

		}
		if (!(this.world[z][northOffset][x] instanceof LemonSquare)) {
			directions.add("north");

		}
		if (!(this.world[z][y][westOffset] instanceof LemonSquare)) {
			directions.add("west");

		}
		if (!(this.world[z][y][eastOffset] instanceof LemonSquare)) {
			directions.add("east");
		}

		sb.append(replaceLastComma(directions));
		sb.append("are open to explore");
		return sb.toString();
	}

	private String replaceLastComma(List<String> strings) {
		String s = "";

		for (String str : strings) {
			s = s + str + ", ";
		}

		s = s.substring(0, s.lastIndexOf(",")) + s.substring(s.lastIndexOf(",") + 1, s.length());
		s = s.substring(0, s.lastIndexOf(",")) + " and" + s.substring(s.lastIndexOf(",") + 1, s.length());

		return s;
	}

	public World() {
		world = new Square[MAX_Z_SIZE_WORLD][MAX_Y_SIZE_WORLD][MAX_X_SIZE_WORLD];

		Random ran = new Random();

		for (int z = 0; z < world.length; z++) {

			for (int y = 0; y < world[z].length; y++) {

				for (int x = 0; x < world[z][y].length; x++) {

					int randomInt = ran.nextInt(125) % 5;

					switch (randomInt) {

					case 0:

						world[z][y][x] = new CaveSquare();

						break;
					case 1:
						world[z][y][x] = new DarkRoomSquare();
						break;
					case 2:
						world[z][y][x] = new HotelRoomSquare();
						break;
					case 3:
						world[z][y][x] = new PlainsSquare();
						break;
					default:
						world[z][y][x] = new RoadSquare();
						break;
					}
				}
			}
		}
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();

		for (Square[][] worldSide : world) {
			for (Square[] worldSideRow : worldSide) {
				for (Square square : worldSideRow) {

					if (square instanceof DarkRoomSquare) {
						sb.append("-");

					} else if (square instanceof LemonSquare) {
						sb.append("0");

					} else if (square instanceof PlainsSquare) {
						sb.append("P");

					} else if (square instanceof HotelRoomSquare) {
						sb.append("H");

					} else if (square instanceof CaveSquare) {
						sb.append("C");

					} else if (square instanceof RoadSquare) {
						sb.append("|");
					}

				}
				sb.append("\n");
			}

			sb.append("\n\n----------------------------------\n\n");

		}

		return sb.toString();
	}

	public Square getSquare(int x, int y, int z) {
		return world[z][y][x];

	}

	public void moveCharacterNorth(Player p) {
		if (p.getPlayerData().getY() + 1 > MAX_Y_SIZE_WORLD - 1) {
			moveOnZ(p);
			p.setY(0);
		} else {
			p.setY(p.getPlayerData().getY() + 1);

		}
	}

	public void moveCharacterSouth(Player p) {
		if (p.getPlayerData().getY() - 1 < 0) {
			moveOnZ(p);
			p.setY(MAX_Y_SIZE_WORLD);
		} else {
			p.setY(p.getPlayerData().getY() - 1);
		}

	}

	public void moveCharacterEast(Player p) {
		if (p.getPlayerData().getX() + 1 > MAX_X_SIZE_WORLD - 1) {
			moveOnZ(p);
			p.setX(0);
		} else {
			p.setX(p.getPlayerData().getX() + 1);

		}
	}

	public void moveCharacterWest(Player p) {
		if (p.getPlayerData().getX() - 1 < 0) {
			moveOnZ(p);

			p.setX(MAX_X_SIZE_WORLD);
		} else {
			p.setX(p.getPlayerData().getX() - 1);
		}

	}

	private void moveOnZ(Player p) {
		if (p.getPlayerData().getZ() > MAX_Z_SIZE_WORLD) {
			p.setZ(0);
		} else if (p.getPlayerData().getZ() < 0) {
			p.setZ(MAX_Z_SIZE_WORLD);
		} else {
			p.setZ(p.getPlayerData().getZ() + 1);
		}
	}

}
