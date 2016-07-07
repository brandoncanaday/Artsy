package cs1302.p2;

import cs1302.effects.Artsy;
import javafx.scene.image.Image;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.PixelReader;
import javafx.scene.image.WritableImage;

public class MyArtsy implements Artsy {
	
	public enum OperationType {
		CHECKERS,
		H_STRIPES,
		V_STRIPES,
		ROTATE
	} // for use with user input view, helps determine label names and operations to perform
	
	public Image doCheckers(Image src1, Image src2, int size) { 
		
	    int width = (int) src1.getWidth();
	    int height = (int) src1.getHeight();
		
	    WritableImage ret = new WritableImage(width, height);
	    PixelReader pr = src1.getPixelReader();
	    PixelWriter pw = ret.getPixelWriter();
	    PixelReader pr2 = src2.getPixelReader();
	    PixelReader prSwap = null; // used to take in either the PixelReader for the first or the second image
	    PixelReader prSwap2 = null; // use to take in either the PixelReader for the first or the second image

	    int count = 0, reverseCount = 0, yCount = 1, storedX = 0, storedY = 0;
	    int originalSize = size;
	    boolean alternate = true, // get the pixels from the other image & set the pixels
	    	    proceed = false, // assists in the transitions from one image to the other 
	    	    reverse = false; // uses the other picture to start off instead of the previous
	    
	    while(count<width) { 
	    		    	
		    if(reverse) // starts off getting the pixels from the second image
		    {
		    	prSwap=pr2;
		    	prSwap2=pr;
		    } // if
		    else if(!reverse) // starts off getting the pixels from the first image
		    { 
		    	prSwap=pr;
		    	prSwap2=pr2;
		    } // else
		    		    	   		    
		    for (int x = storedX; x < size; ++x) {
		    	
		    	if(storedY==height-1) {
		    		alternate = true; // resets the boolean for the selection of images to form checkers
		    		proceed = false; // resets the boolean for the transitions from one image to the other
		    		yCount = 1; // rests the count y for the next checkered column
		    	} // if
		    			    	
		        for (int y = 0; y < height; ++y) {		        	
		        	
		        	if(alternate) {
		            	pw.setArgb(x, y, prSwap.getArgb(x, y));
		            	if(yCount%originalSize==0) {
		            		alternate = false;
		            	} // if
		        	} // if	        
		     	           
		        	if(!alternate && proceed) {
		            	pw.setArgb(x, y, prSwap2.getArgb(x, y));
		            	if(yCount%originalSize==0) {
		            		alternate = true;
		            	} // if
		            } // if
		           
		        	if(!alternate && yCount%originalSize==0) {
		        	   proceed=true;
		        	} // if
		           
		        	if(alternate && yCount%originalSize==0) {
		        	   proceed=false;
		        	} // if	
				        				        	
		        yCount++; // used in the modulo if statements to determine when to alternate & proceed with the images
		        storedX = x; 
		        storedY = y;
		        
		        } // for
		      
		    } // for 
		    
		    storedX+=1; // used to keep storedX updated as the increment of x in the for loop
		    
		    count+=originalSize; // used to know when the image is completed, to end the while loop
	
		    reverseCount++; // used for the if statements as an even & odd to determine when to reverse the start of the checkered images	    
		    if(reverseCount%2!=0) {
		    	reverse = true;
		    } // if
		    if(reverseCount%2==0) {
		    	reverse = false;
		    } // if
		    
		    size+=originalSize; // increases the width, so the for loop can reiterate the checkered image until it's complete
		    if(size>width) {
	        	size=width; // set size equals to the width to end the loop inbounds
	        } // if
	    
	    } // while
	  	    
	    return ret;
	} // doCheckers

	
	public Image doHorizontalStripes(Image src1, Image src2, int size) {
		
	    int width = (int) src1.getWidth();
	    int height = (int) src1.getHeight();
		
	    WritableImage ret = new WritableImage(width, height);
	    PixelReader pr = src1.getPixelReader();
	    PixelWriter pw = ret.getPixelWriter();
	    PixelReader pr2 = src2.getPixelReader();
	    
	    boolean alternate = true, // get the pixels from the other image & set the pixels
	    	    proceed = false; // assists in the transitions from one image to the other 
	    int yCount = 1; // start off at 1 so the use of % allows for the transition from the use of pixels of one image to the other
	    
	    for (int x = 0; x < width; ++x) {
	    	
	    	alternate = true; // resets the boolean for the next horizontal stripe row
	    	proceed = false; // resets the boolean for the next horizontal stripe row
	    	yCount = 1; // resets the yCount for the next horizontal stripe row
	    	
	        for (int y = 0; y < height; ++y) {
	        	
		    if(alternate) {
	         	pw.setArgb(x, y, pr.getArgb(x, y));
	            	if(yCount%size==0) {
			    alternate = false;
	            	} // if
	            } // if	        
	     	           
	           if(!alternate && proceed) {
	            	pw.setArgb(x, y, pr2.getArgb(x, y));
	            	if(yCount%(size)==0) {
			    alternate = true;
	            	} // if
	            } // if
	           
	           if(!alternate && yCount%size==0) {
		       proceed=true;
	           } // if
	           
	           if(alternate && yCount%size==0) {
		       proceed=false;
	           } // if
	   
	           yCount++;

	        } // for
	        
	    } // for	 
	 
		return ret; 
	} // doHorizontalStripes
	
	
	public Image doVerticalStripes(Image src1, Image src2, int size) { 

	    int width = (int) src1.getWidth();
	    int height = (int) src1.getHeight();
		
	    WritableImage ret = new WritableImage(width, height);
	    PixelReader pr = src1.getPixelReader();
	    PixelWriter pw = ret.getPixelWriter();
	    PixelReader pr2 = src2.getPixelReader();
	    
	    boolean alternate = true, // get the pixels from the other image & set the pixels
	            proceed = false; // assists in the transitions from one image to the other
	    int yCount = 1;
	    
	    for (int x = 0; x < height; ++x) {
	    		    	
	    	alternate = true; // resets the boolean for the next vertical stripe row
	    	proceed = false; // resets the boolean for the next vertical stripe row
	    	yCount = 1; // resets the yCount for the next vertical stripe row
	    	
	        for (int y = 0; y < width; ++y) {
	        	
		    if(alternate) {
			pw.setArgb(y, x, pr.getArgb(y, x));
	                if(yCount%size==0) {
			    alternate = false;
	            	} // if
	            } // if	        
	     	           
	           if(!alternate && proceed) {
	            	pw.setArgb(y, x, pr2.getArgb(y, x));
	            	if(yCount%size==0) {
			    alternate = true;
	            	} // if
	            } // if
	           
	           if(!alternate && yCount%size==0) {
		       proceed=true;
	           } // if
	           
	           if(alternate && yCount%size==0) {
		       proceed=false;
	           } // if
        	
        	yCount++;
    
	        } // for
	        
	    } // for
	    
		return ret; 
	} // doVerticalStripes
	
	
	public Image doRotate(Image src, double degrees) {

	    int width = (int) src.getWidth();
	    int height = (int) src.getHeight();

	    WritableImage ret = new WritableImage(width, height);
      	    PixelReader pr = src.getPixelReader();
	    PixelWriter pw = ret.getPixelWriter();
		
	    double radians = degrees*(Math.PI/180), interpolationXX = 0, interpolationYY = 0;
	    int interpolationAverageX = 0, interpolationAverageY = 0, finalX = 0, finalY = 0;
	    
	    for (int x = 0; x < width; ++x) {
	    	
	        for (int y = 0; y < height; ++y) {
	        	
		    double rotateX = x-(width/2), rotateY = y-(height/2); // translate the pixel to be rotated from the image origin
	        	
		    double xx = rotateX * Math.cos(radians) + rotateY * Math.sin(radians); // rotates x coordinate pixel
		    double yy = -rotateX * Math.sin(radians) + rotateY * Math.cos(radians); // rotates y coordinate pixel
	    	  
	    	    rotateX = xx+(width/2); rotateY = yy+(height/2); // translate the rotated pixel back

	    	    if((xx%1!=0 || yy%1!=0) && (xx>=0 && xx<width && yy>=0 && yy<height)) { // % to check if the pixel needs to be interpolated
	    	    	interpolationXX=Math.ceil(xx);
		        for(double interpolationX = xx-1; interpolationX < xx+1; interpolationX += 0.01) {		     	    	
			    interpolationXX+=interpolationX; // add the pixels from the left to the right by one hundredth
		        } // for
		    	    
		        interpolationAverageX = (int)(interpolationXX/100); // average the pixels & then cast it to an int
		        finalX = interpolationAverageX;
		        finalX = (int)rotateX; // the translated back x coordinate

	    	    	interpolationYY=Math.ceil(yy);
		        for(double interpolationY = yy-1; interpolationY < yy+1; interpolationY += 0.01) {	    	    	
			    interpolationYY+=interpolationY;
	    	    	} // for
		    	    
		        interpolationAverageY = (int)(interpolationYY/100); // average the pixels & then cast it to an int
		        finalY = interpolationAverageY;	 	    	    
	    	    	finalY = (int)rotateY; // the translated back y coordinate
	    	    	
	    	    } // if
	    	    else {
	    	    	finalX = (int)rotateX;
	    	    	finalY = (int)rotateY;	    	    	
	    	    } // else
	    	    
	        	
	    	    if(finalX>=0 && finalX<width && finalY>=0 && finalY<height) { // check if the x & y coordinates of the pixels is in bounds	    	    	
    	    		pw.setArgb(x, y, pr.getArgb(finalX, finalY));	    	   
		    } // if	    
	    	   
	        } // for
	        
	    } // for
	
	    return ret; 
	} // doRotate
	
} // MyArtsy

