package Tetris.Logica.Figuras;

import Tetris.utils.Punto2D;
import java.awt.Color;

public class Tetrimino1 implements Figura{

    private final Color fill = new Color(0,0,240);
    private final Color border = new Color(179,179,250);
    private Punto2D[] puntos0;
    private Punto2D[] puntos90;
    private Punto2D[] puntos180;
    private Punto2D[] puntos270;
    private int posicion;
    public Tetrimino1(){
	posicion=0;
	puntos0=new Punto2D[]{new Punto2D(0,0),new Punto2D(1,0),new Punto2D(2,0),new Punto2D(3,0)};
	puntos90=new Punto2D[]{new Punto2D(0,0),new Punto2D(0,1),new Punto2D(0,2),new Punto2D(0,3)};
	puntos180= new Punto2D[]{new Punto2D(0,0),new Punto2D(1,0),new Punto2D(2,0),new Punto2D(3,0)};
	puntos270=new Punto2D[]{new Punto2D(0,0),new Punto2D(0,1),new Punto2D(0,2),new Punto2D(0,3)};
    }

    public void rotateRigth(){
	posicion=(posicion+1)%4;
    }
    
    public void rotateLeft(){
	posicion--;
	if(posicion<0)
	    posicion=3;
	    }

    public Punto2D[] getPuntos(){
	return translate(new Punto2D());
    }

    public Punto2D[] translate(Punto2D dxy){
	Punto2D[] aux=new Punto2D[4];
	switch(posicion){
	case 1:               
                for(int i=0;i<4;i++){
                    aux[i]=puntos90[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            case 2:
                for(int i=0;i<4;i++){
                    aux[i]=puntos180[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            case 3:
                for(int i=0;i<4;i++){
                    aux[i]=puntos270[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
                break;
            default:
                for(int i=0;i<4;i++){
                    aux[i]=puntos0[i].clone();
                    aux[i].move(dxy.getX(), dxy.getY());
                }
        }
        return aux;
    }

    public Color getFillColor(){
        return fill;
    }

    public Color getBorderColor(){
        return border;
    }

    public void restablece() {
        posicion=0;
    }
}