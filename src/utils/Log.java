package utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.lang.reflect.Array;

public abstract class Log {
	
	public static void run(IExecuter executner) {
		run(executner, 100);
	}
	
	public static void run(IExecuter executner, int average) {
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
        
        System.out.println("Executando média...");
        PrintStream printStreamOriginal = System.out;
        System.setOut(new PrintStream(new OutputStream() {
			@Override
			public void write(int arg0) throws IOException {
			}
		}));
        
        double avg = 0;
        for (int i=0; i<average; i++) {
        	t = System.currentTimeMillis();
        	executner.execute();
        	avg += System.currentTimeMillis() - t;
        }
        System.setOut(printStreamOriginal);
        System.out.println("Tempo: " + (avg/average) + "ms\n-------------------");
	}

}
