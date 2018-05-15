/*
 * Decompiled with CFR 0_123.
 */
import java.awt.Component;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

public class TitlesFrame
extends JFrame {
    /**
	 * описание отображения приложения
	 */
    public TitlesFrame() {
        this.initUI();
    }

	 /**
     * 
     * создано 2 перечисления :типы фигур и их атрибуты
     */
    public static enum ShapeTypes{ STAR_3ARMS, STAR_5ARMS, RECTANGLE, TRIANGLE, CIRCLE; }        
    public static  enum ShapeAttribute{STROKE_3,  STROKE_7, GRADIENT, COLOR_RED, NO_ATTRIBUTE; }
	
    private void initUI() {
        this.setTitle("\u041a\u0440\u0438\u0432\u044b\u0435 \u0444\u0438\u0433\u0443\u0440\u044b");
        this.setDefaultCloseOperation(3);
        //this.add(new TitlesPanel(11));
	this.add(new TitlesPanel(ShapeTypes.STAR_3ARMS, ShapeAttribute.STROKE_3));   //добавлено    
        this.setSize(350, 350);
        this.setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable(){

            @Override
            public void run() {
                TitlesFrame ps = new TitlesFrame();
                ps.setVisible(true);
            }
        });
    }

}

