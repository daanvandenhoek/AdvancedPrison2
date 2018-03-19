package com.example.advancedprison;

/**
 * Created by William on 19-3-2018.
 */

import android.app.Activity;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Prison {
    private ArrayList<Prisoner> prisonerList = new ArrayList<>();
    private Activity activity;

    public Prison(Activity activity) {
        this.activity = activity;
        try {
            readFile();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readFile() throws FileNotFoundException {
        InputStreamReader isr = null;
        BufferedReader reader = null;
        try {
            isr = new InputStreamReader(activity.getAssets().open("prisonerlist.csv"));
            reader = new BufferedReader(isr);
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] prisonerInfo = line.split(";");

                if (!(prisonerInfo.length < 4)) {
                    if (prisonerInfo[4].equals("yes")) {
                        prisonerList.add(new Prisoner(prisonerInfo[0], prisonerInfo[1], Integer.parseInt(prisonerInfo[2]), Integer.parseInt(prisonerInfo[3]), true));
                    } else if (prisonerInfo[4].equals("no")) {
                        prisonerList.add(new Prisoner(prisonerInfo[0], prisonerInfo[1], Integer.parseInt(prisonerInfo[2]), Integer.parseInt(prisonerInfo[3]), false));
                    }

                }
            }
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } finally {
            if (isr != null) {
                try {
                    isr.close();
                    reader.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
            }
        }
    }

    public ArrayList<Prisoner> getPrisonerList() {
        return prisonerList;
    }

    public void addPrisoner(Prisoner newPrisoner) {
        prisonerList.add(newPrisoner);
    }

    public void deletePrisoner(Prisoner deletePrisoner) {
        prisonerList.remove(deletePrisoner);
    }
}