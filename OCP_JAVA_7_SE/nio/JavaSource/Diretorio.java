import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class Diretorio {
	public static void main(String[] args) {
		
		Locale locBR = new Locale("pt","BR");
		Locale.setDefault(locBR);
		
		File directory = null;
		
		if (args.length < 1) {
			directory = new File(System.getProperty("user.dir"));
//			System.out.println("Uso: java Diretorio <nome do diretorio>");
//			System.exit(1);
		} else {
			directory = new File(args[0]);
		}
		
		if (!directory.exists()) {
			System.out.println("\n Arquivo/Diretório não existe");
			System.exit(0);
		}

		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy  HH:mm");
		
		if (!directory.isDirectory()) {
			System.out.printf("\n Diretório de %s\n\n", directory.getParent());
			long d = directory.lastModified();
			System.out.print(df.format(new Date(d)));
			System.out.printf("%10s", "");
			System.out.printf(" %1$,15d ", directory.length());
			System.out.println(directory.getPath());
			System.exit(0);
		}
		
		System.out.printf("\n Diretório de %s\n\n", directory.getPath());
		
		File[] files = directory.listFiles();
		for (File file : files) {
			long d = file.lastModified();
			System.out.print(df.format(new Date(d)));
			if (file.isDirectory()) {
				System.out.print("    <DIR> ");
				System.out.printf(" %1$15s ", "");
			} else {
				System.out.printf("%10s", "");
				System.out.printf(" %1$,15d ", file.length());
			}
			System.out.println(file.getPath());
		}
		
		System.exit(0);
	}
}