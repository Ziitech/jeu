package vue;

public class Lanceur {

	public Lanceur() {
	}

	public static void main(String[] args) {
		//new TestVue();
		int h = 500;
		int w = h * (16/9);
		new Cadre(w,h);
	}

}
