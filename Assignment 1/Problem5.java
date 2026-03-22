// Develop inheritance-based Cricket–Match system using command line arguments 

import java.util.Scanner;

// Base Class
class Match {
    protected String teamA;
    protected String teamB;

    Match(String teamA, String teamB) {
        this.teamA = teamA;
        this.teamB = teamB;
    }
}

// Derived Class
class CricketMatch extends Match {
    private int runsA, runsB;

    CricketMatch(String teamA, String teamB, int runsA, int runsB) {
        super(teamA, teamB);
        this.runsA = runsA;
        this.runsB = runsB;
    }

    // Only result method
    void showResult() {
        if (runsA > runsB)
            System.out.println(teamA + " wins the match!");
        else if (runsB > runsA)
            System.out.println(teamB + " wins the match!");
        else
            System.out.println("Match Drawn!");
    }
}

// Main Class
public class Problem5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Team 1: ");
        String t1 = sc.nextLine();

        System.out.print("Enter Team 2: ");
        String t2 = sc.nextLine();

        System.out.print("Enter Score of " + t1 + ": ");
        int s1 = sc.nextInt();

        System.out.print("Enter Score of " + t2 + ": ");
        int s2 = sc.nextInt();

        CricketMatch cm = new CricketMatch(t1, t2, s1, s2);

        System.out.println();
        cm.showResult(); // ✅ Only this will print

        sc.close();
    }
}