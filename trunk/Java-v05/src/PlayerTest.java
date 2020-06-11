
public class PlayerTest {

	public static void main(String[] args) {
		Weapon w1 = new Weapon("菜刀", 10, 20);
		Weapon w2 = new Weapon("霜之哀伤", 3000, 4500);

		Player p1 = new Player("张辽", 3000, 1500, w2);
		Player p2 = new Player("张飞", 3400, 1700, w1);
		
		p2.attack(p1);
		System.out.println(p1.getHp());
	}

}
