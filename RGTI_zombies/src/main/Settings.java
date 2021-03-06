package main;

import org.lwjgl.input.Keyboard;

public class Settings {
    // Main game settings
    public static final boolean godMode = false;
    public static final String version = "0.1";
    public static final int exitKey = Keyboard.KEY_ESCAPE;
    public static final int changeWindowModeKey = Keyboard.KEY_F1;
    public static final String windowTitle = "Zombies fuck you";
    public static final int windowWidth = 1024;
    public static final int windowHeight = 768;

    // User object settings
    public static final float userObjectSpeed = 0.1f;
    public static final float[] userSize = {1.8f, 0.5f, 1.2f};

    // Bomb settings
    public static final int bombMaxPower = 1;
    public static final int maxBombThrowingSpeed = 20;
    public static float bombSize = 0.5f;
    public static final int maxBombs = 20;
    // Special weapons in order 0 -> N
    public static float nukeSize = 2f;
    public static int maxNukes = 5;

    // Other living objects (zombies, not zombies) settings
    public static final int zombieObjectHealth = 1;
    public static final float zombieObjectSpeed = 0.01f;
    public static final float zombieSize = 0.3f;
    // In seconds:
    public static final int zombieIncreaseInterval = 60 * 1000;
    public static final int zombieIncreaseSizeInterval = 5;

    //Houses
    public static final int houseHeightBounds = 10;
    public static final int minimalHouseHeight = 3;
    public static final int houseLengthBounds = 5;
    public static final int minimalHouseLength = 4;
    public static final int mainRoadWidth = 12;
    public static final int minHouseWidth = 1;
    public static final int spaceBetweenHouses = 1;
}
