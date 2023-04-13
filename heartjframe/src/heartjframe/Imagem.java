package heartjframe;

import java.awt.Color;
import javax.swing.JFrame;

public class Imagem {
	// executa o aplicativo

	public static void main(String args[]) {
		// cria o frame
		JFrame jf = new JFrame("Avaliação 2UND");
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ImgJPainel imgJPainel = new ImgJPainel();
		imgJPainel.setBackground(Color.WHITE);
		jf.add(imgJPainel);//adiciona o painel ao frame
		jf.setSize(656,520);//define o tamanho do frame
		jf.setVisible(true);//exibe o frame
	}
}
