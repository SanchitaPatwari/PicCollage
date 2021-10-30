/*************************************************************************
 *  Compilation:  javac ArtCollage.java
 *  Execution:    java ArtCollage
 *
 *  @author:
 *
 *************************************************************************/

import java.awt.Color;

public class ArtCollage {

    // The orginal picture
    private Picture original;

    // The collage picture
    private Picture collage;

    // The collage Picture consists of collageDimension X collageDimension tiles
    private int collageDimension;

    // A tile consists of tileDimension X tileDimension pixels
    private int tileDimension;
    
    /*
     * One-argument Constructor
     * 1. set default values of collageDimension to 4 and tileDimension to 100
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename) 
    {
        tileDimension=100;
        collageDimension=4;
        original =new Picture(filename); //insert filename image
        for (int x = 0;x<original.width();x++){
            for (int y = 0;y<original.height();y++){
                original.set(x,y,original.get(x,y));
            }
        }
        collage= new Picture(tileDimension*collageDimension,tileDimension*collageDimension);
        for (int x = 0; x<tileDimension*collageDimension;x++)
        { //changes x value
            for (int y = 0; y<tileDimension*collageDimension;y++)
            { //changes y values
                int x1= x*original.width()/(tileDimension*collageDimension);
                int y1= y*original.height()/(tileDimension*collageDimension);
                collage.set(x,y,original.get(x1,y1));
            }
        }
    }

    /*
     * Three-arguments Constructor
     * 1. set default values of collageDimension to cd and tileDimension to td
     * 2. initializes original with the filename image
     * 3. initializes collage as a Picture of tileDimension*collageDimension x tileDimension*collageDimension, 
     *    where each pixel is black (see all constructors for the Picture class).
     * 4. update collage to be a scaled version of original (see scaling filter on Week 9 slides)
     *
     * @param filename the image filename
     */
    public ArtCollage (String filename, int td, int cd) {
        collageDimension=cd;
        tileDimension=td;
        original= new Picture (filename);
        collage= new Picture(tileDimension*collageDimension,tileDimension*collageDimension);
        for (int x = 0;x<original.width();x++){
            for (int y = 0;y<original.height();y++){
                original.set(x,y,original.get(x,y));
            }
        }
        for (int x = 0; x<tileDimension*collageDimension;x++)
        { //changes x value
            for (int y = 0; y<tileDimension*collageDimension;y++)
            { //changes y values
                int x1= x*original.width()/(tileDimension*collageDimension);
                int y1= y*original.height()/(tileDimension*collageDimension);
                collage.set(x,y,original.get(x1,y1));
            }
        }

    }

    /*
     * Returns the collageDimension instance variable
     *
     * @return collageDimension
     */
    public int getCollageDimension() {

	return collageDimension;
    }

    /*
     * Returns the tileDimension instance variable
     *
     * @return tileDimension
     */
    public int getTileDimension() {

	return tileDimension;
    }

    /*
     * Returns original instance variable
     *
     * @return original
     */
    public Picture getOriginalPicture() {

	return original;
    }

    /*
     * Returns collage instance variable
     *
     * @return collage
     */
    public Picture getCollagePicture() {

	return collage;
    }
    
    /*
     * Display the original image
     * Assumes that original has been initialized
     */
    public void showOriginalPicture() {

	original.show();
    }

    /*
     * Display the collage image
     * Assumes that collage has been initialized
     */
    public void showCollagePicture() {

	collage.show();
    }

    /*
     * Replaces the tile at collageCol,collageRow with the image from filename
     * Tile (0,0) is the upper leftmost tile
     *
     * @param filename image to replace tile
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void replaceTile (String filename,  int collageCol, int collageRow) {
        Picture lol = new Picture(filename);
            for (int x = 0; x<tileDimension;x++)
            { //changes x value
                for (int y = 0; y<tileDimension;y++)
                { //changes y values
                int x1= x*lol.width()/tileDimension;
                int y1=  y*lol.height()/tileDimension;
                collage.set((tileDimension*collageCol)+x,(tileDimension*collageRow)+y,lol.get(x1,y1));

                }
            }
    }
    
    /*
     * Makes a collage of tiles from original Picture
     * original will have collageDimension x collageDimension tiles, each tile
     * has tileDimension X tileDimension pixels
     */
    public void makeCollage () {
        Picture wow =new Picture(tileDimension,tileDimension);
            for (int x = 0; x<tileDimension;x++)
        { //changes x value
            for (int y = 0; y<tileDimension;y++)
            { //changes y values
                int x1= x*original.width()/wow.width();
                int y1= y*original.height()/wow.height();
                wow.set(x,y,original.get(x1,y1));
            }
        }
        for (int x = 0; x<collageDimension;x++)
        {
            for (int y=0; y<collageDimension;y++)
            {
                for (int collageCol=0;collageCol<tileDimension;collageCol++)
                {
                    for (int collageRow=0;collageRow<tileDimension;collageRow++)
                    {
                        collage.set(collageCol+(x*tileDimension),collageRow+(y*tileDimension),wow.get(collageCol,collageRow));
                    }

                }
            }
        }
    }

    /*
     * Colorizes the tile at (collageCol, collageRow) with component 
     * (see Week 9 slides, the code for color separation is at the 
     *  book's website)
     *
     * @param component is either red, blue or green
     * @param collageCol tile column
     * @param collageRow tile row
     */
    public void colorizeTile (String component,  int collageCol, int collageRow) {

	   for (int x=0;x<tileDimension;x++)
        {
            for (int y=0;y<tileDimension;y++)
            {
            Color color = collage.get((tileDimension*collageCol)+x,(tileDimension*collageRow)+y);
            int red = color.getRed();
            int green = color.getGreen();
            int blue = color.getBlue();
            if (component.contains("red") && component.length()==3){
                collage.set((tileDimension*collageCol)+x,(tileDimension*collageRow)+y, new Color(red,0,0));
            }
            if (component.contains("green") && component.length()==5){
                collage.set((tileDimension*collageCol)+x,(tileDimension*collageRow)+y, new Color(0,green,0));
            }
            if (component.contains("blue") && component.length()==4){
                collage.set((tileDimension*collageCol)+x,(tileDimension*collageRow)+y, new Color(0,0,blue));
            }
            }
        }
    }

    /*
     * Greyscale tile at (collageCol, collageRow)
     * (see Week 9 slides, the code for luminance is at the book's website)
     *
     * @param collageCol tile column
     * @param collageRow tile row
     */

    public void greyscaleTile (int collageCol, int collageRow) {
        for (int x=0;x<tileDimension;x++)
        {
            for (int y=0;y<tileDimension;y++)
            {
            Color gray= Luminance.toGray(collage.get((tileDimension*collageCol)+x,(tileDimension*collageRow)+y));
            collage.set((tileDimension*collageCol)+x,(tileDimension*collageRow)+y,gray);
            }
        }
    }


    // Test client 
    public static void main (String[] args) {
// Creates a collage of 3x3 tiles. Each tile dimension is 200x200 pixels
    ArtCollage art = new ArtCollage(args[0],100,4);
    art.makeCollage();
   // art.replaceTile(args[1],0,0);
   //art.colorizeTile("red",0,0);
   // art.showCollagePicture();
    //ArtCollage art1 = new ArtCollage(args[1],100,4);
    //art1.makeCollage();
   // art1.replaceTile(args[2],0,0);
   art.colorizeTile("red",0,0);
    art.showCollagePicture();
}
}

