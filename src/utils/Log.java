package utils;

import java.lang.reflect.Array;

public abstract class Log {
	
	public static void run(IExecuter executner) {
		long t = System.currentTimeMillis();
		Object execution = executner.execute();
		if (execution.getClass().isArray()) {
			System.out.println("Resposta:");
			for(int i=0; i < Array.getLength(execution); i++){
				if (i > 0)
					System.out.print(", ");
		        System.out.print(Array.get(execution, i));
		    }
			System.out.println();
		} else {			
			System.out.println("Resposta: " + execution);
		}
        System.out.println("Tempo: " + (System.currentTimeMillis() - t) + "ms");
	}

}
