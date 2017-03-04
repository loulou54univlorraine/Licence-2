package glaces;

public class TestArticImage {
    public static void main(String[] args) {
        ArcticImage art = new ArcticImage(300, 300);
        int[][] tab = new int[300][300];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j < tab[i].length; j++) {
                if (j % 2 == 0) {
                    tab[i][j] = 0;
                } else {
                    tab[i][j] = 1;
                }
            }
        }
        art.setColors(tab);

        //art.fermer();
    }

}
