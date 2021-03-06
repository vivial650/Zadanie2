/*
 * Decompiled with CFR 0_123.
 */
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Paint;
import java.awt.Point;
import java.awt.Shape;
import java.awt.geom.Arc2D;
import java.awt.geom.GeneralPath;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class ShapeFactory {
    /**
     * формирование фигур и их параметров
     * при делении параметра на 10
     * целая часть результата определяет форму фигуры
     * остаток от деления определяет характеристики фигур
     */
    public Shape shape;
    public BasicStroke stroke = new BasicStroke(3.0f);
    public Paint paint;
    public int width = 25;
    public int height = 25;
    
     /**
     * Добавлен конструктор. Принимает 2 объекта
     * @param type
     * @param attr
     */
    public ShapeFactory(TitlesFrame.ShapeTypes type,TitlesFrame.ShapeAttribute attr){
    	
    	switch (type){
    	case STAR_3ARMS:{
    		
    		this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0);
            break;
    	}
    	
    	case STAR_5ARMS:{
    		 this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0);
             break;    		
    	}
    	case RECTANGLE:{
    		this.shape = new Rectangle2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height);
            break;
    	}
    	case TRIANGLE:{
    		 GeneralPath path = new GeneralPath();
             double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
             path.moveTo((double)((- this.width) / 2), - tmp_height);
             path.lineTo(0.0, - tmp_height);
             path.lineTo((double)(this.width / 2), tmp_height);
             path.closePath();
             this.shape = path;
             break;
    	}
    	case CIRCLE:{
    		 this.shape = new Arc2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
             break;
    	}
    	 default: {
             throw new Error("type is unsupported");
    	}
    }
    switch(attr){
    	case STROKE_3:{
    		this.stroke = new BasicStroke(3.0f);
            break;
    	}
    	case STROKE_7:{
    		 this.stroke = new BasicStroke(7.0f);
             break;
    	}
    	case  GRADIENT:{
    		this.paint = new GradientPaint(- this.width, - this.height, Color.white, this.width, this.height, Color.gray, true);
            break;
    	}
    	case COLOR_RED:{
    		this.paint = Color.red;
            break;
    	}
    	case NO_ATTRIBUTE:{
    		 break;
    	}
    	default: {
            throw new Error("type is unsupported");
    	}
    }
    }
    /**
     * Первоначальный  конструктор. Принимает один целочисленный параметр
     * @param shape_type
     */

    public ShapeFactory(int shape_type) {
        switch (shape_type / 10) {
            case 1: {
                this.shape = ShapeFactory.createStar(3, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 2.0);
                break;
            }
            case 3: {
                this.shape = ShapeFactory.createStar(5, new Point(0, 0), (double)this.width / 2.0, (double)this.width / 4.0);
                break;
            }
            case 5: {
                this.shape = new Rectangle2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height);
                break;
            }
            case 7: {
                GeneralPath path = new GeneralPath();
                double tmp_height = Math.sqrt(2.0) / 2.0 * (double)this.height;
                path.moveTo((double)((- this.width) / 2), - tmp_height);
                path.lineTo(0.0, - tmp_height);
                path.lineTo((double)(this.width / 2), tmp_height);
                path.closePath();
                this.shape = path;
                break;
            }
            case 9: {
                this.shape = new Arc2D.Double((double)(- this.width) / 2.0, (double)(- this.height) / 2.0, this.width, this.height, 30.0, 300.0, 2);
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
        switch (shape_type % 10) {
            case 1: {
                this.stroke = new BasicStroke(3.0f);
                break;
            }
            case 3: {
                break;
            }
            case 4: {
                this.stroke = new BasicStroke(7.0f);
                break;
            }
            case 7: {
                this.paint = new GradientPaint(- this.width, - this.height, Color.white, this.width, this.height, Color.gray, true);
                break;
            }
            case 8: {
                this.paint = Color.red;
                break;
            }
            default: {
                throw new Error("type is nusupported");
            }
        }
    }

    private static Shape createStar(int arms, Point center, double rOuter, double rInner) {
        double angle = 3.141592653589793 / (double)arms;
        GeneralPath path = new GeneralPath();
        int i = 0;
        while (i < 2 * arms) {
            double r = (i & 1) == 0 ? rOuter : rInner;
            Point2D.Double p = new Point2D.Double((double)center.x + Math.cos((double)i * angle) * r, (double)center.y + Math.sin((double)i * angle) * r);
            if (i == 0) {
                path.moveTo(p.getX(), p.getY());
            } else {
                path.lineTo(p.getX(), p.getY());
            }
            ++i;
        }
        path.closePath();
        return path;
    }
}
