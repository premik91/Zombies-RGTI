package main;

import org.lwjgl.examples.spaceinvaders.Texture;
import org.lwjgl.input.Keyboard;

public class Settings {
    // Main game settings
    public static final String version = "0.1";
    public static final int exitKey = Keyboard.KEY_ESCAPE;
    public static final int changeWindowModeKey = Keyboard.KEY_F1;
    public static final String windowTitle = "Zombies fuck you";
    public static boolean fullScreen = true;
    public static final int windowWidth = 1280;
    public static final int windowHeight = 800;

    // User object settings
    public static final String userObjectModel = "objects/userModel.obj";
    public static final int userObjectMaxHealth = 20;
    public static final int userObjectSpeed = 1;

    // Bomb settings
    public static final int bombMaxPower = 1;
    public static final int maxBombThrowingSpeed = 5;

    // Other living objects (zombies, not zombies) settings
    public static final String zombieObjectModel = "objects/zombieModel.obj";
    public static final int zombieObjectHealth = 1;
    public static final float zombieObjectSpeed = 0.1f;
    // In seconds:
    public static final int zombieIncreaseInterval = 10 * 1000;

    public static final String notZombieObjectModel = "objects/notZombieModel.obj";
    public static final int notZombieObjectHealth = 1;
    public static final int notZombieObjectSpeed = 1;

    //Houses
    public static Texture[] houseTextures = new Texture[10];
    public static final int houseHeightBounds = 10;
    public static final int minimalHouseHeight = 3;
    public static final int houseLengthBounds = 5;
    public static final int minimalHouseLength = 4;
    public static final int mainRoadWidth = 12;
    public static final int minHouseWidth = 1;
    public static final int spaceBetweenHouses = 1;
}
