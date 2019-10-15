import java.util.Scanner;
import java.util.Vector;

public class RestoranTest {
	
	static Vector<Kullanici> kullanicilar = new Vector<Kullanici>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		while(true){
			System.out.println("Restoran simülasyonuna hoþ geldiniz!!");
			System.out.println("1. Yeni Kayýt");
			System.out.println("2. Giriþ Yap");
			System.out.println("3. Çýkýþ");
			System.out.print("Seçimizi yapýnýz: ");
			int secim = input.nextInt();
			
			if(secim == 1){
				yeniKayit();
			}
			else if(secim == 2)
				girisYap();
			else if (secim == 3)
				break;
			else System.out.println("Adam akýllý giriþ yap !!!");
		}
	}

	private static void girisYap() {
		// TODO Auto-generated method stub
		
		System.out.print("Ýsminizi giriniz: ");
		String isim = input.next();
		for(int i = 0; i < kullanicilar.size(); i++){
			Kullanici k = kullanicilar.get(i);
			if(k.getIsim().equals(isim)){
				if(k.getTip() == Kullanici.MUSTERI)
					musteriMenüsüneYonledir();
				else restoranSahibiMenüsüneYönlendir();
				break;
			}
		}
	}

	private static void restoranSahibiMenüsüneYönlendir() {
		// TODO Auto-generated method stub
		System.out.println("RESTORAN SAHÝBÝ MENÜSÜ");
		System.out.println("----------------------");
	}

	private static void musteriMenüsüneYonledir() {
		// TODO Auto-generated method stub
		System.out.println("MÜÞTERÝ MENÜSÜ");
		System.out.println("----------------------");
	}

	private static void yeniKayit() {
		System.out.print("Ýsminizi Giriniz: ");
		String isim = input.next();
		Kullanici yeni = new Kullanici(isim);
		do{
			System.out.println("Tip seçiniz");
			System.out.println("--------------");
			System.out.println("1. Müþteri: ");
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
				System.out.println("Kaydýnýz gerçekleþti");
				break;
			}
			else System.out.println("Yanlýþ tip seçimi!!!");
		}while(true);
	}

}
