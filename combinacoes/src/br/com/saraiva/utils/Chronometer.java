package br.com.saraiva.utils;

public final class Chronometer {
	private static long msBegin, msEnd, msTime;

	private Chronometer() {
	}

	public static void start() {
		msTime = 0;
		msBegin = System.currentTimeMillis();
	}

	public static void stop() {
		msEnd = System.currentTimeMillis();
		msTime += msEnd - msBegin;
	}

	public static void resume() {
		msBegin = System.currentTimeMillis();
	}

	public static long time() {
		return msTime;
	}

	public static double stime() {
		return msTime / 1000.;
	}

	public static double mtime() {
		return msTime / 60000.;
	}

	public static double htime() {
		return msTime / 3600000.;
	}

	public static void main(String[] arg) {
		Chronometer.start();
		for (int i = 1; i < 1000000; i++) {
		}
		Chronometer.stop();
		Chronometer.resume();
		for (int i = 1; i < 1000000; i++) {
		}
		Chronometer.stop();
		System.out.println("ms " + Chronometer.time());
		System.out.println("s " + Chronometer.stime());
		System.out.println("m " + Chronometer.mtime());
		System.out.println("h " + Chronometer.htime());
	}
}