//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reseau.test;

import reseau.Message;
import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class AtelierTestMessage {
    static int nbTests = 0;
    static int score = 0;

    public AtelierTestMessage() {
    }

    public static void testGlobal() {
        nbTests += 6;
        int var1 = 0;

        try {
            Message var2;
            try {
                var2 = new Message(new int[]{10, 20, 30});

                assert var2.toString().equals("[0, 10, 0, 20, 0, 30]") : var2.toString();

                ++var1;
            } catch (AssertionError var12) {
                System.err.println("error: " + var12.getMessage());
            }

            var2 = new Message(new int[]{10, 20, 30});

            try {
                assert var2.extraireEntier(2) == 20 : var2.extraireEntier(2);

                ++var1;
            } catch (AssertionError var11) {
                System.err.println("error: " + var11.getMessage());
            }

            Adresse var5 = new Adresse("192.168.0.1");
            Message var3 = new Message(var5);

            try {
                assert var3.toString().equals("[192, 168, 0, 1]") : var3.toString();

                ++var1;
            } catch (AssertionError var10) {
                System.err.println("error: " + var10.getMessage());
            }

            try {
                assert var3.extraireAdresse(4).toString().equals(var5.toString()) : var3.extraireAdresse(4).toString();

                ++var1;
            } catch (AssertionError var9) {
                System.err.println("error: " + var9.getMessage());
            }

            try {
                var2.ajouter(var3);

                assert var2.toString().equals("[0, 10, 0, 20, 0, 30, 192, 168, 0, 1]");

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                String var6 = "CeciEstUnMessage";
                Message var4 = new Message(var6);

                assert var4.extraireChaine() != null && var4.extraireChaine().equals(var6) : var4.extraireChaine();

                ++var1;
            } catch (AssertionError var13) {
                System.err.println("error: " + var13.getMessage());
            }
        } catch (Exception var14) {
            var14.printStackTrace();
        }

        System.out.println("----------------------------");
        System.out.println("Résultat: " + var1 + "/" + 6);
        score += var1;
    }

    public static void testMessageShort() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Message(short... v)");

        try {
            try {
                short[] var2 = new short[]{1, 2, 3, 4};
                Message var3 = new Message(var2);

                assert var3.size() == 4 : var3.size();

                ++var1;

                assert var3.toString().equals("[1, 2, 3, 4]") : var3.toString();

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testMessageInt() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Message(int... v)");

        try {
            try {
                int[] var2 = new int[]{1, 2, 3, 4};
                Message var3 = new Message(var2);

                assert var3.size() == 8 : var3.size();

                ++var1;

                assert var3.toString().equals("[0, 1, 0, 2, 0, 3, 0, 4]") : var3.toString();

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testMessageString() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Message(String mot)");

        try {
            String var2;
            Message var3;
            try {
                var2 = "HelloWorld";
                var3 = new Message(var2);

                assert var3.size() == 10 : var3.size();

                ++var1;

                assert var3.toString().equals("[72, 101, 108, 108, 111, 87, 111, 114, 108, 100]") : var3.toString();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                var2 = "";
                var3 = new Message(var2);

                assert var3.size() == 0 : var3.size();

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testMessageAdresse() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Message(Adresse adr)");

        try {
            try {
                Adresse var2 = new Adresse(new Octet[]{new Octet(192), new Octet(168), new Octet(0), new Octet(1)});
                Message var3 = new Message(var2);

                assert var3.size() == 4 : var3.size();

                ++var1;

                assert var3.toString().equals("[192, 168, 0, 1]") : var3.toString();

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var6) {
            var6.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testMessageMessage() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Message(Message m)");

        try {
            try {
                int[] var2 = new int[]{1, 2, 3, 4};
                Message var3 = new Message(var2);
                Message var4 = new Message(var3);

                assert var4.size() == var3.size() : var4.size();

                ++var1;

                assert var4.toString().equals(var3.toString()) : var4.toString();

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                new Message((Message)null);
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
                ++var1;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testAjouterShort() {
        nbTests += 4;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("ajouter(short x)");

        try {
            try {
                int[] var3 = new int[0];
                Message var4 = new Message(var3);
                byte var2 = 0;
                var4.ajouter(var2);

                assert var4.size() == 1 : var4.size();

                ++var1;

                assert var4.toString().equals("[0]") : var4.toString();

                ++var1;
                var2 = 1;
                var4.ajouter(var2);

                assert var4.size() == 2 : var4.size();

                ++var1;

                assert var4.toString().equals("[0, 1]") : var4.toString();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 4);
        score += var1;
    }

    public static void testAjouterInt() {
        nbTests += 4;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("ajouter(int x)");

        try {
            try {
                int[] var3 = new int[0];
                Message var4 = new Message(var3);
                byte var2 = 0;
                var4.ajouter(var2);

                assert var4.size() == 2 : var4.size();

                ++var1;

                assert var4.toString().equals("[0, 0]") : var4.toString();

                ++var1;
                var2 = 1;
                var4.ajouter(var2);

                assert var4.size() == 4 : var4.size();

                ++var1;

                assert var4.toString().equals("[0, 0, 0, 1]") : var4.toString();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 4);
        score += var1;
    }

    public static void testAjouterAdresse() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("ajouter(Adresse adr)");

        try {
            Message var4;
            try {
                short[] var3 = new short[]{0, 255};
                var4 = new Message(var3);
                Adresse var5 = new Adresse(16);
                var4.ajouter(var5);

                assert var4.size() == 4 : var4.size();

                ++var1;

                assert var4.toString().equals("[0, 255, 0, 0]") : var4.toString();

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var4 = new Message();
                var4.ajouter((Adresse)null);
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
                ++var1;
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testAjouterMessage() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("ajouter(Message mess)");

        try {
            Message var4;
            try {
                short[] var3 = new short[]{0, 255};
                var4 = new Message(var3);
                Message var5 = new Message(var3);
                var4.ajouter(var5);

                assert var4.size() == 4 : var4.size();

                ++var1;

                assert var4.toString().equals("[0, 255, 0, 255]") : var4.toString();

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var4 = new Message();
                var4.ajouter((Message)null);
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
                ++var1;
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testExtraireEntier() {
        nbTests += 4;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("extraireEntier(int index)");

        try {
            int var2;
            Message var3;
            try {
                var3 = new Message(new int[]{15, 20000});
                var2 = var3.extraireEntier(0);

                assert var2 == 15 : var2;

                ++var1;
                var2 = var3.extraireEntier(2);

                assert var2 == 20000 : var2;

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var3 = new Message(new int[]{0, 0});
                var2 = var3.extraireEntier(-1);
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
                ++var1;
            }

            try {
                var3 = new Message(new int[]{0, 0});
                var2 = var3.extraireEntier(3);
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
                ++var1;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 4);
        score += var1;
    }

    public static void testExtraireAdresse() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("extraireAdresse(int nbOctets)");

        try {
            short[] var2;
            Message var3;
            Adresse var4;
            try {
                var2 = new short[]{0, 255, 255, 16};
                var3 = new Message(var2);
                var4 = var3.extraireAdresse(3);

                for(int var5 = 0; var5 < 3; ++var5) {
                    assert var4.getOctet(var5).getValue() == var2[var5] : var4.getOctet(var5).getValue();
                }

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var2 = new short[]{0, 255, 255, 16};
                var3 = new Message(var2);
                var4 = var3.extraireAdresse(5);
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
                ++var1;
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testExtraireChaine() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("extraireChaine()");

        try {
            String var2;
            String var3;
            Message var4;
            try {
                var2 = "Hello";
                var4 = new Message(var2);
                var3 = var4.extraireChaine();

                assert var3.equals(var2) : var3;

                ++var1;
            } catch (AssertionError var9) {
                System.err.println("error: " + var9.getMessage());
            }

            try {
                var2 = "Hello!";
                var4 = new Message(var2);
                var3 = var4.extraireChaine();

                assert var3 == null : var3;

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                short[] var6 = new short[]{65, 114, 103, 104};
                var4 = new Message(var6);
                var3 = var4.extraireChaine();

                assert var3.equals("Argh") : var3;

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testAugmenter() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("augmenter(int i, int bi, int bs)");

        try {
            short[] var2;
            Message var3;
            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.augmenter(3, 100, 104);

                assert var3.toString().equals("[65, 114, 106, 107]") : var3.toString();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.augmenter(3, 10, 14);

                assert var3.toString().equals("[65, 114, 103, 104]") : var3.toString();

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testSupprimer() {
        nbTests += 2;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("supprimer(int i)");

        try {
            short[] var2;
            Message var3;
            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(3);

                assert var3.toString().equals("[104]") : var3.toString();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(5);
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
                ++var1;
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 2);
        score += var1;
    }

    public static void testSupprimer2() {
        nbTests += 4;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("supprimer(int debut, int fin)");

        try {
            short[] var2;
            Message var3;
            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(1, 2);

                assert var3.toString().equals("[65, 104]") : var3.toString();

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(0, 2);

                assert var3.toString().equals("[104]") : var3.toString();

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(2, 1);
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
                ++var1;
            }

            try {
                var2 = new short[]{65, 114, 103, 104};
                var3 = new Message(var2);
                var3.supprimer(1, 4);
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
                ++var1;
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 4);
        score += var1;
    }

    public static void main(String... var0) {
        testGlobal();
        testMessageShort();
        testMessageInt();
        testMessageString();
        testMessageAdresse();
        testMessageMessage();
        testAjouterShort();
        testAjouterInt();
        testAjouterAdresse();
        testAjouterMessage();
        testExtraireEntier();
        testExtraireAdresse();
        testExtraireChaine();
        testAugmenter();
        testSupprimer();
        testSupprimer2();
        System.out.println("============================");
        System.out.println("Score final : " + (int)Math.round((double)score * 10.0D / (double)nbTests) + "/10");
    }
}
