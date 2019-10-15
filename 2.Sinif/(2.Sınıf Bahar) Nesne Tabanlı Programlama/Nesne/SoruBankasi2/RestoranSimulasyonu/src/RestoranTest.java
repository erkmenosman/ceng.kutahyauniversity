import java.util.Scanner;
import java.util.Vector;

public class RestoranTest {
	
	static Vector<Kullanici> kullanicilar = new Vector<Kullanici>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		while(true){
			System.out.println("Restoran sim�lasyonuna ho� geldiniz!!");
			System.out.println("1. Yeni Kay�t");
			System.out.println("2. Giri� Yap");
			System.out.println("3. ��k��");
			System.out.print("Se�imizi yap�n�z: ");
			int secim = input.nextInt();
			
			if(secim == 1){
				yeniKayit();
			}
			else if(secim == 2)
				girisYap();
			else if (secim == 3)
				break;
			else System.out.println("Adam ak�ll� giri� yap !!!");
		}
	}

	private static void girisYap() {
		// TODO Auto-generated method stub
		
		System.out.print("�sminizi giriniz: ");
		String isim = input.next();
		for(int i = 0; i < kullanicilar.size(); i++){
			Kullanici k = kullanicilar.get(i);
			if(k.getIsim().equals(isim)){
				if(k.getTip() == Kullanici.MUSTERI)
					musteriMen�s�neYonledir();
				else restoranSahibiMen�s�neY�nlendir();
				break;
			}
		}
	}

	private static void restoranSahibiMen�s�neY�nlendir() {
		// TODO Auto-generated method stub
		System.out.println("RESTORAN SAH�B� MEN�S�");
		System.out.println("----------------------");
	}

	private static void musteriMen�s�neYonledir() {
		// TODO Auto-generated method stub
		System.out.println("M��TER� MEN�S�");
		System.out.println("----------------------");
	}

	private static void yeniKayit() {
		System.out.print("�sminizi Giriniz: ");
		String isim = input.next();
		Kullanici yeni = new Kullanici(isim);
		do{
			System.out.println("Tip se�iniz");
			System.out.println("--------------");
			System.out.println("1. M��teri: ");
			System.out.println("2. Restoran Sahibi: ");
			
			int tip = input.nextInt();
			
			if(tip == 1) {
				yeni.setTip(Kullanici.MUSTERI);
				kullanicilar.add(yeni);
				System.out.println(yeni +"artislikyapma");
				break;
			}
			else if(tip == 2){
				yeni.setTip(Kullanici.SAHIP);
				kullanicilar.add(yeni);
				System.out.println("Kayd�n�z ger�ekle�ti");
				break;
			}
			else System.out.println("Yanl�� tip se�imi!!!");
		}while(true);
	}

}
