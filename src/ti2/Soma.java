package ti2;

import java.util.Scanner;

public class Soma {

	public static void main(String[] args) {
			Scanner scanner = new Scanner(System.in);
		
			System.out.println("Digite o 1.o número: \n");
			int num1 = scanner.nextInt();
			
			System.out.println("Digite o 2.o número: \n");
			int num2 = scanner.nextInt();
			
			int resultado = num1 + num2;
			System.out.println("A soma é: "+ resultado);
			scanner.close();
		}


}
