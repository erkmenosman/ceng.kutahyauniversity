import java.util.Scanner;
import java.util.Vector;

public class SoruBankasiTest{
	
	static Vector<SoruBankasi> soru = new Vector<SoruBankasi>();
	static Scanner input = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(true){
			System.out.println("Soru Bankasý Programýna Hoþ Geldiniz!");
			System.out.println("1. Soru Ekle");
			System.out.println("2. Soru Listele ve Düzenle");
			System.out.println("3. Çýkýþ");
			System.out.println("Seçimizi yapýnýz: ");
			System.out.println("-------------------------");
			int secim = input.nextInt();
			
			if(secim == 1){
				SoruEkle();
			}
			else if(secim == 2)
				SoruListele();
			else if (secim == 3)
				break;
			else System.out.println("Yanlýþ Seçim");
		}
	}

	private static void SoruListele() {
		if (soru.size() == 0)
		{
			System.out.println("---Listenecek Soru Bulunmuyor Lütfen Soru Ekleyin");
		}
		else if (soru.size() != 1)
		{
	        for(int i=0; i < soru.size(); i++)
	        {
	        	System.out.println(soru.get(i));
	       	}
			System.out.println("-------------------------");
			System.out.println("---Düzenlemek Ýçin 1'e Basýnýz...");
			System.out.println("---Silmek Ýçin 2'e Basýnýz...");
		}
		
		int duzenleindex = input.nextInt();
		
		if(duzenleindex == 1) {
			soru.clear();
			SoruEkle();
		}
		else if(duzenleindex == 2){
			soru.clear();
			System.out.println("-------------------------");
			System.out.println("---Soru Baþarýyla Silindi");
		}
	}

	private static void SoruEkle() {
		System.out.println("Yeni Soruyu Giriniz");
		String yenisoru = "SORU:  "+input.next();
		SoruBankasi yeni = new SoruBankasi(yenisoru);
		yeni.setIndex(SoruBankasi.SORU);	
		soru.addElement(yeni);
		System.out.println("Soru Baþarýyla Eklendi");
		System.out.println("Lütfen Soru Þýklarýný Giriniz");
		System.out.println("---------------------------");
		
		System.out.println("A Þýkký : ");
		String asikki = "A-) "+input.next();
		SoruBankasi cevapa = new SoruBankasi(asikki);
		cevapa.setCevap(SoruBankasi.SORU);
		soru.add(cevapa);
		
		System.out.println("B Þýkký : ");
		String bsikki = "B-) "+input.next();
		SoruBankasi cevapb = new SoruBankasi(bsikki);
		cevapb.setCevap(SoruBankasi.SORU);
		soru.add(cevapb);
		
		System.out.println("C Þýkký : ");
		String csikki = "C-) "+input.next();
		SoruBankasi cevapc = new SoruBankasi(csikki);
		cevapc.setCevap(SoruBankasi.SORU);
		soru.add(cevapc);
		
		System.out.println("D Þýkký : ");
		String dsikki = "D-) "+input.next();
		SoruBankasi cevapd = new SoruBankasi(dsikki);
		cevapd.setCevap(SoruBankasi.SORU);
		soru.add(cevapd);
		
		System.out.println("Zorluk Seviyesi Seçiniz : ");
		System.out.println("1. Kolay ");
		System.out.println("2. Orta ");
		System.out.println("3. Zor ");
		String zorlukseviyesi = "ZORLUK SEVÝYESÝ: "+input.next();
		SoruBankasi zorluk = new SoruBankasi(zorlukseviyesi);
		zorluk.setZorluk(SoruBankasi.SORU);
		soru.add(zorluk);
		
		System.out.println("Soru Puaný Giriniz : ");
		String sorupuani = "SORU PUANI: "+input.next();
		SoruBankasi puan = new SoruBankasi(sorupuani);
		puan.setSoruPuani(SoruBankasi.SORU);
		soru.add(puan);
		
		System.out.println("Doðru Cevap : ");
		String dogrucevap= "DOGRU CEVAP: "+input.next();
		SoruBankasi cevap = new SoruBankasi(dogrucevap);
		puan.setSoruPuani(SoruBankasi.SORU);
		soru.add(cevap);
		
		System.out.println("Soru Baþarýyla Eklendi !");
		System.out.println("-------------------------");
	}
}
