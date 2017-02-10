package norman.uva;

import norman.template.Template;

/**
 *
 * @author M Normansyah (m.normansyah@samsung.com) Arti soal : setiap dari 8
 *         queen ditaruh di kolom yang berbeda dan berarti tidak ada queen /
 *         ratu yang menyerang satu sama lain secara vertikal. tetapi beberapa
 *         ratu menyerang secara horizontal atau diagonal. kamu harus
 *         memindahkan ratu sehingga tidak ada 2 ratu salah menyerang dari arah
 *         manapun. Kamu diperbolehkan untuk menggerakkan ratu secara vertikal
 *         dan maka kamu dapat hanya mengubah baris posisi dari tiap ratu dan
 *         tidak kolom. Sebuah gerakan terdiri dari gerakan ratu dari (R1, C) ke
 *         (R2, C) dimana 1 >= R1, R2 <= 8 dan R1 != R2
 *
 *         Yang diketahui : gerak secara vertikal saja.
 *
 *         Yang dicari : menemukan jumlah gerakan yang dibutuhkan untuk
 *         menyelesaikan tugas ????
 *
 *         solution :
 *         http://saicheems.wordpress.com/2013/08/06/uva-11085-back-to
 *         -the-8-queens/
 */
public class BackToTheEightQueens extends Template {

    public static String inputNames[][] = {
            {"kolom", "baris"},
            {"valid(n, i) : "},
            {"tryrow", "queens[prevIndex]", "prevIndex",
                    "(tryrow == queens[prevIndex])"},
            {"Math.abs(col-prevIndex)", "Math.abs(tryrow-queens[prevIndex]))",
                    "(Math.abs(col-prevIndex) == Math.abs(tryrow-queens[prevIndex]))"}};
    static int count = 1;
    int[] queens,// ini untuk referensi, kalau terjadi perpindahan maka
    // 1+search.
    path;// untuk yang pindah2.

	public BackToTheEightQueens() {
		super("BackToTheEightQueens", "BackToTheEightQueens", LINUX);
	}

	@Override
	public void doSomething() {
		A: while (true) {

			queens = new int[8];
			path = new int[8];
			int temp;

			// dari 1 sampai 8
			for (int i = 0; i < queens.length; i++) {
				temp = getInput().nextInt();
				if (temp == -1) {
					break A;
				}
				temp--;
				path[i] = temp;
				queens[i] = temp;
			}

			System.out.printf("Case %d: %d\n", count, search(0));
			count++;
			if (!getInput().hasNext()) {
				break A;
			}
		}
	}

	int search(int col) {
		if (col == 8)
			return 0;
		int tot = 10000;
		// move linearly from row 0 to row 7
		for (int row = 0; row < 8; row++) {
			if (valid(col, row)) {
				path[col] = row;
				System.out.println();
				tot = Math.min(tot, row == queens[col] ? search(col + 1)
						: 1 + search(col + 1));
			}
		}
		return tot;
	}

	// The i-th integer indicates the row position of a queen in the i-th
	// column. jadi queens[col] = row;
	boolean valid(int col, int row) {
		for (int i = 0; i < col; i++) {
			if (row == path[i])
				return false;
			if (Math.abs(col - i) == Math.abs(row - path[i]))
				return false;
		}
		return true;
	}

}
