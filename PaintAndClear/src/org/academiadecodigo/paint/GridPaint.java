package org.academiadecodigo.paint;
import org.academiadecodigo.paint.GridPaint;
import org.academiadecodigo.simplegraphics.graphics.Line;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.graphics.Color;

public class GridPaint {


    private Rectangle grid;


    //constructor to create and draw the grid
    public GridPaint(){
        this.grid= new Rectangle(10,10,500,500);
        this.grid.setColor(Color.BLACK);
        this.grid.draw();

        //initial spacing values
        int a = 35;  //spacing + padding which is 10;
        int b = 35;

        //create 20 lines to form the grid
        for(int i=0; (i<20) ;i++){

            Line liner=new Line(a,10,a,510); // 510 , com  o PADDING
            Line lines=new Line(10,b,510,b);

            // draw the vertical and horizontal lines on the canvas
            liner.draw();
            lines.draw();

            //increment the spacing values for the next iteration
            a=a+25;
            b=b+25;



        }




    }



}
