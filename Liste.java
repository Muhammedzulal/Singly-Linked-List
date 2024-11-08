package LinkedList;

//&Tek Yönlü Doğrusal Bağlı Liste
public class Liste {
    Node head = null;
    Node tail = null;

    void sonaekle(int x) {// ^ Sona Ekle
        Node eleman = new Node(); // Yeni bir düğüm oluşturulur.
        eleman.data = x; // Düğümün verisi, parametre olarak gelen x olur.
        eleman.next = null; // Yeni düğümün işaretçisi (sonraki düğümü gösteren kısım) şimdilik null olur.

        if (head == null) { // Eğer liste boşsa, yeni düğüm hem head hem de tail olur.
            head = eleman;
            tail = eleman;
            System.out.println("<Liste başarıyla oluşturulup ilk elemanı eklendi.>");
        } else {
            tail.next = eleman; // Eğer liste boş değilse, mevcut son düğümün next işaretçisini yeni düğüme
                                // bağlarız.
            tail = eleman; // Yeni düğüm, listenin sonuna eklendiği için tail güncellenir.
            System.out.println("<Listenin sonuna eleman eklendi.>");
        }
    }

    void basaEkle(int x) {// ^ Başa Ekle
        Node eleman = new Node(); // Yeni düğüm oluşturulur.
        eleman.data = x; // Yeni düğümün verisi parametre olarak gelen x olur.

        if (head == null) { // Eğer liste boşsa, yeni düğüm hem head hem de tail olur.
            head = eleman;
            tail = eleman;
            System.out.println("<Liste oluşturulup ilk eleman başa eklendi.>");
        } else {
            eleman.next = head; // Yeni düğümün next işaretçisi, eski head'i gösterecek.
            head = eleman; // Yeni düğüm head olur.
            System.out.println("<Eleman listenin başına eklendi.>");
        }
    }

    void arayaEkle(int position, int x) {// ^Araya Ekle
        if (position < 0) {
            System.out.println("<Geçersiz pozisyon.>");
            return;
        }
        Node eleman = new Node();
        eleman.data = x;
        if (position == 0) { // Pozisyon 0 ise başa ekleme yapılır.
            basaEkle(x);
            return;
        }
        Node temp = head;// Başlangıçta temp değişkeni head'e (ilk düğüme) işaret eder.
        for (int i = 0; i < position - 1; i++) { // Pozisyona kadar ilerleriz.
            if (temp == null) {
                System.out.println("<Pozisyon listenin sınırları dışında.>");
                return;
            }
            temp = temp.next;// temp'i bir sonraki düğüme taşırız.
        }
        // Burada elemanı ekliyoruz:
        eleman.next = temp.next; // Yeni elemanın next'ini, temp'in bir sonraki düğümüne işaret ettiriyoruz.
        temp.next = eleman; // Temp'in next'ini yeni eleman olarak ayarlıyoruz.
        System.out.println("<Eleman pozisyona eklendi: " + position + ">");
    }

    void bastanSil() {// ^Baştan Sil
        if (head == null) {
            System.out.println("<Liste boş, silinecek eleman yok.>");
            return; // Eğer liste boşsa, işlem yapmadan çık.
        }

        head = head.next; // İlk düğümü silmek için head'i bir sonraki düğüme güncelliyoruz.

        if (head == null) {
            tail = null; // Eğer yeni head null olduysa, tail'i de null yap.
        }

        System.out.println("<Listenin başındaki eleman silindi.>");
    }

    void sondanSil() {// ^Sondan Sil
        if (head == null) {
            System.out.println("<Liste boş, silinecek eleman yok.>");
            return; // Eğer liste boşsa, işlem yapmadan çık.
        }

        if (head == tail) {
            // Eğer sadece bir düğüm varsa, onu sil.
            head = null; // head'i null yap
            tail = null; // tail'i null yap
        } else {
            Node temp = head; // İlk düğümü geçici olarak tutuyoruz.

            // Sondan bir önceki düğümü bulalım.
            while (temp.next != tail) {
                temp = temp.next; // temp'i bir sonraki düğüme taşırız.
            }

            tail = temp; // tail'i sondan bir önceki düğüme güncelleriz.
            tail.next = null; // Yeni tail'in next'ini null yaparak son düğümü silmiş oluruz.
        }

        System.out.println("<Listenin sonundaki eleman silindi.>");
    }

    void aradanSil(int position) {// ^Aradan Sil
        if (head == null) {
            System.out.println("<Liste boş, silinecek eleman yok.>");
            return; // Eğer liste boşsa, işlem yapmadan çık.
        }

        if (position == 0) {
            // Eğer silinecek düğüm baştaysa sil baştan metodu ile sil.
            bastanSil();
            return;
        }

        Node temp = head; // İlk düğümü geçici olarak tutuyoruz.

        // Pozisyona kadar ilerle.
        for (int i = 0; i < position - 1; i++) {
            if (temp == null || temp.next == null) {
                System.out.println("<Pozisyon listenin sınırları dışında.>");
                return; // Pozisyon sınırların dışındaysa çık.
            }
            temp = temp.next; // temp'i bir sonraki düğüme taşırız.
        }

        // Temp, silinecek düğümün bir önceki düğümünü işaret eder.
        if (temp.next == null) {
            System.out.println("<Pozisyon listenin sınırları dışında.>");
            return; // Eğer temp.next null ise, belirtilen pozisyon yoktur.
        }

        // Silinecek düğümü temp.next'ten al.
        Node silinecekDugum = temp.next; // Silinecek düğüm.
        temp.next = silinecekDugum.next; // Temp'in next'ini, silinecek düğümün bir sonraki düğümüne ayarlıyoruz.

        if (silinecekDugum == tail) {
            tail = temp; // Eğer silinen düğüm tail ise, tail'i güncelle.
        }

        System.out.println("<İndeksteki eleman silindi.>");
    }

    void yazdir() {// ^Yazdır
        if (head == null) { // Eğer liste boşsa, mesaj basılır.
            System.out.println("<Liste boş>");
        } else {
            Node temp = head; // Geçici düğüm ile listenin başından itibaren elemanlar gezilir.
            System.out.print("[");
            while (temp != null) {
                System.out.print(" " + temp.data + " "); // Her düğümün verisi yazdırılır.
                temp = temp.next; // Bir sonraki düğüme geçilir.
            }
            System.out.print("]\n");
        }
    }
}
