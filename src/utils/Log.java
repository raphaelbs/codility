package utils;

public abstract class Log {
	
	public static void run(IExecuter executner) {
		long t = System.currentTimeMillis();
		System.out.println("Resposta: " + executner.execute());
        System.out.println("Tempo: " + (System.currentTimeMillis() - t) + "ms");
	}

}
