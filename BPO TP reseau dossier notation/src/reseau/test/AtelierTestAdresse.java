//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package reseau.test;

import reseau.adresses.Adresse;
import reseau.adresses.Octet;

public class AtelierTestAdresse {
    static int nbTests = 0;
    static int score = 0;

    public AtelierTestAdresse() {
    }

    public static void testGlobal() {
        nbTests += 5;
        int var1 = 0;

        try {
            Adresse var2 = new Adresse("192.168.0.1");

            try {
                assert var2.toString().equals("192.168.0.1");

                ++var1;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var2 = new Adresse(24);

                assert var2.getNbreOctets() == 3;

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var2 = new Adresse(new Octet[]{new Octet(10)});

                assert var2.toString().equals("10");

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                var2 = new Adresse("192.45.43.100");

                assert var2.toString().equals("192.45.43.100");

                ++var1;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }

            try {
                var2.masquer(new Adresse("255.0.0.0"));

                assert var2.toString().equals("192.0.0.0");

                ++var1;
            } catch (AssertionError var4) {
                System.err.println("error: " + var4.getMessage());
            }
        } catch (Exception var9) {
            var9.printStackTrace();
        }

        System.out.println("----------------------------");
        System.out.println("Résultat: " + var1 + "/" + 5);
        score += var1;
    }

    public static void testAdresseInt() {
        nbTests += 3;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Adresse(int nbBits)");

        try {
            Adresse var2;
            try {
                var2 = new Adresse(8);

                assert var2.size() == 8 : var2.size();

                ++var1;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                new Adresse(12);
            } catch (AssertionError var5) {
                System.err.println(var5.getMessage());
                ++var1;
            }

            try {
                var2 = new Adresse(24);

                assert var2.size() == 24 : var2.size();

                ++var1;
            } catch (AssertionError var4) {
                System.err.println("error: " + var4.getMessage());
            }
        } catch (Exception var7) {
            var7.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testAdresseOctet() {
        nbTests += 2;
        int var1 = 0;
        Octet[] var3 = new Octet[4];
        System.out.println("----------------------------");
        System.out.println("Adresse(Octet... alo)");

        try {
            var3[0] = new Octet(192);
            var3[1] = new Octet(168);
            var3[2] = new Octet(0);
            var3[3] = new Octet(1);

            try {
                Adresse var2 = new Adresse(var3);

                assert var2.getNbreOctets() == 4 : var2.getNbreOctets();

                ++var1;

                for(int var4 = 0; var4 < 4; ++var4) {
                    assert var2.getOctet(var4).toString().equals(var3[var4].toString()) : var2.getOctet(var4);
                }

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

    public static void testAdresseAdresse() {
        nbTests += 3;
        int var1 = 0;
        Octet[] var4 = new Octet[4];
        System.out.println("----------------------------");
        System.out.println("Adresse(Adresse a)");

        try {
            var4[0] = new Octet(192);
            var4[1] = new Octet(168);
            var4[2] = new Octet(0);
            var4[3] = new Octet(1);

            try {
                Adresse var2 = new Adresse(var4);
                Adresse var3 = new Adresse(var2);

                assert var3.getNbreOctets() == 4 : var3.getNbreOctets();

                ++var1;

                for(int var5 = 0; var5 < 4; ++var5) {
                    assert var3.getOctet(var5).toString().equals(var4[var5].toString()) : var3.getOctet(var5);
                }

                ++var1;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                new Adresse((Adresse)null);
            } catch (AssertionError var6) {
                ++var1;
                System.err.println("error: " + var6.getMessage());
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 3);
        score += var1;
    }

    public static void testAdresseString() {
        nbTests += 5;
        int var1 = 0;
        System.out.println("----------------------------");
        System.out.println("Adresse(String s)");

        try {
            String var3;
            try {
                var3 = "192.168.0.255";
                String[] var4 = var3.split("\\.");
                Adresse var2 = new Adresse(var3);

                assert var2.getNbreOctets() == 4 : var2.getNbreOctets();

                ++var1;

                for(int var5 = 0; var5 < 4; ++var5) {
                    assert var2.getOctet(var5).toString().equals(var4[var5]) : var2.getOctet(var5);
                }

                ++var1;
            } catch (AssertionError var9) {
                System.err.println("error: " + var9.getMessage());
            }

            try {
                var3 = "192.168.0.256";
                new Adresse(var3);
            } catch (AssertionError var8) {
                ++var1;
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var3 = "192.168.0.-1";
                new Adresse(var3);
            } catch (AssertionError var7) {
                ++var1;
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var3 = "192.168.0.1.1";
                new Adresse(var3);
            } catch (AssertionError var6) {
                ++var1;
                System.err.println("error: " + var6.getMessage());
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        System.out.println("Résultat: " + var1 + "/" + 5);
        score += var1;
    }

    public static void testAdresseInt2() {
        nbTests += 6;
        int var2 = 0;
        System.out.println("----------------------------");
        System.out.println("Adresse(int nbBits, int nbBitsUn)");

        try {
            Adresse var3;
            try {
                var3 = new Adresse(32, 0);

                assert var3.size() == 32 : var3.size();

                ++var2;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var3 = new Adresse(32, 31);

                assert var3.size() == 32 : var3.size();

                ++var2;
                String[] var1 = new String[]{"255", "255", "255", "254"};

                for(int var4 = 0; var4 < 4; ++var4) {
                    assert var3.getOctet(var4).toString().equals(var1[var4]) : var3.getOctet(var4) + ":" + var1[var4];
                }

                ++var2;
            } catch (AssertionError var9) {
                System.err.println("error: " + var9.getMessage());
            }

            try {
                new Adresse(8, 24);
            } catch (AssertionError var7) {
                System.err.println(var7.getMessage());
                ++var2;
            }

            try {
                new Adresse(16, -8);
            } catch (AssertionError var6) {
                System.err.println(var6.getMessage());
                ++var2;
            }

            try {
                new Adresse(12, 0);
            } catch (AssertionError var5) {
                System.err.println(var5.getMessage());
                ++var2;
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        System.out.println("Résultat: " + var2 + "/" + 6);
        score += var2;
    }

    public static void testMasquer() {
        nbTests += 4;
        int var2 = 0;
        System.out.println("----------------------------");
        System.out.println("masquer(Adresse masque)");

        try {
            String[] var1;
            Adresse var3;
            Adresse var4;
            int var5;
            try {
                var3 = new Adresse(32);
                var4 = new Adresse(32, 32);
                var3.masquer(var4);
                var1 = new String[]{"0", "0", "0", "0"};

                for(var5 = 0; var5 < 4; ++var5) {
                    assert var3.getOctet(var5).toString().equals(var1[var5]) : var3.getOctet(var5) + ":" + var1[var5];
                }

                ++var2;
            } catch (AssertionError var9) {
                System.err.println("error: " + var9.getMessage());
            }

            try {
                var3 = new Adresse(32, 32);
                var4 = new Adresse(32, 9);
                var3.masquer(var4);
                var1 = new String[]{"255", "128", "0", "0"};

                for(var5 = 0; var5 < 4; ++var5) {
                    assert var3.getOctet(var5).toString().equals(var1[var5]) : var3;
                }

                ++var2;
            } catch (AssertionError var8) {
                System.err.println("error: " + var8.getMessage());
            }

            try {
                var3 = new Adresse(32);
                var4 = new Adresse(64);
                var3.masquer(var4);
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
                ++var2;
            }

            try {
                var3 = new Adresse(32);
                var4 = new Adresse(24);
                var3.masquer(var4);
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
                ++var2;
            }
        } catch (Exception var10) {
            var10.printStackTrace();
        }

        System.out.println("Résultat: " + var2 + "/" + 4);
        score += var2;
    }

    public static void testInverser() {
        nbTests += 3;
        int var2 = 0;
        System.out.println("----------------------------");
        System.out.println("inverser()");

        try {
            String[] var1;
            Adresse var3;
            int var4;
            try {
                var3 = new Adresse(32);
                var3.inverser();
                var1 = new String[]{"255", "255", "255", "255"};

                for(var4 = 0; var4 < 4; ++var4) {
                    assert var3.getOctet(var4).toString().equals(var1[var4]) : var3.getOctet(var4) + ":" + var1[var4];
                }

                ++var2;
            } catch (AssertionError var7) {
                System.err.println("error: " + var7.getMessage());
            }

            try {
                var3 = new Adresse(32, 32);
                var3.inverser();
                var1 = new String[]{"0", "0", "0", "0"};

                for(var4 = 0; var4 < 4; ++var4) {
                    assert var3.getOctet(var4).toString().equals(var1[var4]) : var3;
                }

                ++var2;
            } catch (AssertionError var6) {
                System.err.println("error: " + var6.getMessage());
            }

            try {
                var3 = new Adresse(32, 12);
                var3.inverser();
                var1 = new String[]{"0", "15", "255", "255"};

                for(var4 = 0; var4 < 4; ++var4) {
                    assert var3.getOctet(var4).toString().equals(var1[var4]) : var3;
                }

                ++var2;
            } catch (AssertionError var5) {
                System.err.println("error: " + var5.getMessage());
            }
        } catch (Exception var8) {
            var8.printStackTrace();
        }

        System.out.println("Résultat: " + var2 + "/" + 3);
        score += var2;
    }

    public static void main(String... var0) {
        testGlobal();
        testAdresseInt();
        testAdresseOctet();
        testAdresseAdresse();
        testAdresseString();
        testAdresseInt2();
        testMasquer();
        testInverser();
        System.out.println("============================");
        System.out.println("Score final : " + (int)Math.round((double)score * 10.0D / (double)nbTests) + "/10");
    }
}
