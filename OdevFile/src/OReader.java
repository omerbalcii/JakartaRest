import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class OReader {
    private String dosyaYolu;

    // OReader sınıfının constructor, dosya yolunu alır.
    public OReader(String dosyaYolu) {
        this.dosyaYolu = dosyaYolu;
    }

    
    public ArrayList<String> readWords() throws IOException {// Dosyadan kelimeleri okumak için kullanılan method.
       
        ArrayList<String> kelimeler = new ArrayList<>(); // Dosyadan okunan kelimeleri saklamak için bir ArrayList oluşturuyoruz.

        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) { // Dosyayı okumak için bir BufferedReader kullanıyoruz.

            int karakter;
            StringBuilder kelime = new StringBuilder(); // Kelimeyi geçici olarak saklamak için bir StringBuilder kullanıyoruz.

            while ((karakter = reader.read()) != -1) {
                if (Character.isWhitespace(karakter)) {
                    // Eğer boşluk karakteri ise, kelimeyi ArrayList'e ekliyoruz.
                    if (kelime.length() > 0) {
                        kelimeler.add(kelime.toString());
                        // Kelimeyi sıfırlayarak bir sonraki kelimeyi almak için hazır hale getiriyoruz.
                        kelime.setLength(0);
                    }
                } else {
                    // Boşluk karakteri değilse, kelimeyi oluşturan karakteri ekliyoruz.
                    kelime.append((char) karakter);
                }
            }
            // Son kelimeyi eklemek için, dosyanın sonunda olduğumuzda bu adımı kullanıyoruz.
            if (kelime.length() > 0) {
                kelimeler.add(kelime.toString());
            }
        }
        // Okunan kelimeleri içeren ArrayList'i döndürüyoruz.
        return kelimeler;
    }

    // Belirli bir satırı okumak için kullanılan method.
    public String readLineAt(int satirNo) throws IOException {
        String satir = null;
        int currentLine = 0;
        // Dosyayı satır satır okumak için bir BufferedReader kullanıyoruz.
        try (BufferedReader reader = new BufferedReader(new FileReader(dosyaYolu))) {
            while (currentLine < satirNo) {
                satir = reader.readLine();
                if (satir == null) {
                    break;
                }
                currentLine++;
            }
        }
        // Okunan satırı döndürüyoruz.
        return satir;
    }

    public static void main(String[] args) {
        try {
            // OReader sınıfını kullanarak bir örnek oluşturun ve belirtilen dosyayı açıyoruz
        	OReader myReader = new OReader("C:\\Users\\omer\\Desktop\\dosya.txt");
            ArrayList<String> kelimeler = myReader.readWords();
            String satir = myReader.readLineAt(1);

            // Okunan kelimeleri yazdır
            for (String kelime : kelimeler) {
                System.out.print(kelime + " ");
            }
            System.out.println(); // Boş bir satır ekle

            // Okunan satırı yazdır
            System.out.println("Okunan Satır: " + satir);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
