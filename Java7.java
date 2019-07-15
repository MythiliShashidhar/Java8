package myPrograms;


interface Diagram1{
	void draw();
}

public class Java7 {

	public static void main(String[] args) {
		
		Diagram1 diagram = new Diagram1() {
			public void draw() {
				System.out.println("Hello World");
			}
		};
	diagram.draw();
	}

}
