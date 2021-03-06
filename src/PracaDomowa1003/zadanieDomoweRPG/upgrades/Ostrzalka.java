package PracaDomowa1003.zadanieDomoweRPG.upgrades;

import PracaDomowa1003.zadanieDomoweRPG.Character;

public class Ostrzalka extends Dekorator{
	Character character;
	
	public Ostrzalka(Character character) {
		this.character = character;
	}
	
	@Override
	public int getAttack() {
		return character.getAttack() + 10;
	}

	@Override
	public void setAttack(int siema) {
		this.character.setAttack(10);
	}

	@Override
	public int getDefence() {
		return character.getDefence();
	}

	@Override
	public void setDefence(int defence) {
		
	}

	@Override
	public int getPackVolume() {
		return character.getPackVolume();
	}

	@Override
	public void setPackVolume(int packVolume) {
		
	}

	@Override
	public String getName() {
		return " naostrzony ";
	}
}
