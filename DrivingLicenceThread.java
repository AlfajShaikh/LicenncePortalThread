import java.lang.Runnable;
import java.util.Scanner;

class OnlineTest implements Runnable {
    private int ans;
    private int marks = 0;
    private String str;

    Scanner sc = new Scanner(System.in);

    public void run() {
        System.out.println("\t\t\t\t\t******* Driving Licence Portal ********");
        try {
            System.out.println("Start Online Test Start/Not");
            str = sc.nextLine();
            if (str.equals("start")) {
                System.out.print("\nStart test after 5 sec :");
                for (int i = 0; i <= 5; i++) {
                    System.out.print("\t" + i);
                    Thread.sleep(2000);
                }
                System.out.println("\nA.Verify the Sign ->");
                System.out.println("\n1.left\t\t" + "2.right\n" + "3.up\t\t" + "4.down");
                System.out.print("\nEnter Your Answer :");
                ans = sc.nextInt();
                if (ans == 2) {
                    marks++;
                }

                System.out.println("Done");
                Thread.sleep(1000);

                System.out.println("\nB.Verify the Sign <-");
                System.out.println("\n1.left\t\t" + "2.right\n" + "3.up\t\t" + "4.down");
                System.out.print("\nEnter Your Answer :");
                ans = sc.nextInt();

                if (ans == 1) {
                    marks++;

                }
                System.out.println("Done");
                Thread.sleep(1000);

                System.out.println("\nC.Verify the Sign P");
                System.out.println("1.stop\t\t" + "2.crossing\n" + "3.parking\t\t" + "4.traffic");
                System.out.print("\nEnter Your Answer :");
                ans = sc.nextInt();

                if (ans == 3) {
                    marks++;
                }

                System.out.println("Done");
                Thread.sleep(1000);

                System.out.println("\nD.Verify the Sign |||");
                System.out.println("1.bridge\t\t" + "2.three lines\n" + "3.stop\t\t" + "4.zebra crossing");
                System.out.print("\nEnter Your Answer :");
                ans = sc.nextInt();

                if (ans == 4) {
                    marks++;

                }
                System.out.println("Done");
                Thread.sleep(1000);
                System.out.println("\nD.Verify the Sign //");
                System.out.println("1.bridge\t\t" + "2.three lines\n" + "3.stop\t\t" + "4.zebra crossing");
                System.out.print("\nEnter Your Answer :");
                ans = sc.nextInt();

                if (ans == 1) {
                    marks++;
                }

                System.out.println("Done");
                Thread.sleep(1500);
                System.out.println("Finish Test !!!");

            }

        } catch (Exception e) {

        }

    }

    public int getMarks() {
        return marks;
    }
}

class DrivingTest implements Runnable {
    Scanner sc = new Scanner(System.in);
    private String str;

    public void run() {
        System.out.println("\n!.....Driving Test Status....!");
        System.out.println("\nEnter driving status pass/fail ");
        str = sc.nextLine();

    }

    public String getStatus() {
        return str;
    }
}

class Verification implements Runnable {
    Scanner sc = new Scanner(System.in);
    private String str1;

    public void run() {
        System.out.println("\n!.....Document Varification....!");
        System.out.println("document Verification prosesss status done/Not :");
        str1 = sc.nextLine();

    }

    public String getDocumentstatus() {
        return str1;
    }
}

public class DrivingLicenceThread {
    public static void main(String[] args) throws InterruptedException {
        OnlineTest onlineTest = new OnlineTest();
        DrivingTest drivingTest = new DrivingTest();
      Verification verification =  new Verification();
        Thread t1 = new Thread(onlineTest);
        Thread t2 = new Thread(drivingTest);
        Thread t3 = new Thread(verification);

        try {
            t1.start();
            t1.join();

            if (onlineTest.getMarks() < 3) {
                System.out.println("You are Fail ** again you are repeat test");
              
               

            } else {
                System.out.println("Cogratulation..!!  You are Elegible to next Process");
                Thread.sleep(1500);
                t2.start();
                t2.join();
                if (drivingTest.getStatus().equals("pass")) {
                    System.out.println("You are passed Eligible next process ");
                    Thread.sleep(1500);
                    t3.start();
                    t3.join();
                    if (verification.getDocumentstatus().equals("done")) {
                        System.out.println("Done..!! Licence Genrated ");
                    } else {
                        System.out.println("Process is Running State...@@");
                    }
                } else {
                    System.out.println("You are Failed ** Again get Appointment ");
                }

            }

        } catch (Exception e) {

        }

        System.out.println("Successfully processes !!!!!!!!!!!!!");
    }
}
