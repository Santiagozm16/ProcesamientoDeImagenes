/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package PhotoshopBasico;

import java.awt.image.BufferedImage;

/**
 *
 * @author Daniel Esteban Rico C. 
 */
public class ImagenEditada {
    
     private  BufferedImage ImgTemp=null;
     private  BufferedImage ImgTemp2=null;
     
     public BufferedImage getImagen(){
         return ImgTemp;
     }
     public void setImagen(BufferedImage img){
          ImgTemp=Clon.clone(img);
     }
    
     public void BrilloSetNuevosColores(int k1){
 
            int height= ImgTemp.getHeight(); 
            int width= ImgTemp.getWidth(); 
            int k=k1;
            int ColorActual=0;
            int a,r,g,b;
            int NuevoColor=0;
            for (int y = 0; y < height; y++){
                    for (int x = 0; x < width; x++) {
                        
                        ColorActual=ImgTemp.getRGB(x, y);             
                        a = (ColorActual >> 24) & 0xff;
                        r = (ColorActual >> 16) & 0xff;
                        g = (ColorActual >> 8) & 0xff;
                        b = ColorActual & 0xff;
                       if (r + k > 255) {
                           r = 255;
                       } else if (r + k < 0) {
                           r = 0;
                       } else {
                           r = r + k;
                       }
                       if (g + k > 255) {
                           g = 255;
                       } else if (g + k < 0) {
                           g = 0;
                       } else {
                           g = g + k;
                       }
                       if (b + k > 255) {
                           b = 255;
                       } else if (b + k < 0) {
                           b = 0;
                       } else {
                           b = b + k;
                       }
                       
                        NuevoColor = (a << 24) | (r << 16) | (g << 8) | b;
                        ImgTemp.setRGB(x,y,NuevoColor);
                       
                    }
            }
    }
     
      public void ContrasteSetNuevosColores(int k1){
         
            int k=k1;
            int height= ImgTemp.getHeight(); 
            int width= ImgTemp.getWidth(); 
            int ColorActual=0;
            int PromedioR=0;
            int PromedioG=0;
            int PromedioB=0;
            int Acumulador=0;
            int NuevoColor=0;
            int a,r,g,b;
            for (int y = 0; y < height; y++){
                    for (int x = 0; x < width; x++) {
                        
                        ColorActual=ImgTemp.getRGB(x, y);
                        //System.out.print(ImgTemp.getRGB(x, y));
                        a = (ColorActual >> 24) & 0xff;
                        r = (ColorActual >> 16) & 0xff;
                        g = (ColorActual >> 8) & 0xff;
                        b = ColorActual & 0xff;
                        PromedioR += r;
                        PromedioG += g;
                        PromedioB += b;
                        Acumulador++;
                    }
            }
            PromedioR = PromedioR/Acumulador;
            PromedioG = PromedioG/Acumulador;
            PromedioB = PromedioB/Acumulador;
            
            for (int y = 0; y < height; y++){
                for (int x = 0; x < width; x++) {
                      ColorActual=ImgTemp.getRGB(x, y);   
                        a = (ColorActual >> 24) & 0xff;
                        r = (ColorActual >> 16) & 0xff;
                        g = (ColorActual >> 8) & 0xff;
                        b = ColorActual & 0xff;
                  //Rojo
                  if( (((r - PromedioR)*k) + PromedioR) >255 ){
                         r = 255;
                  }else if ( (((r - PromedioR)*k) + PromedioR) <0  ){
                       r = 0;
                  }else{
                      r = Math.round ((((r - PromedioR)*k) + PromedioR));
                  }
                  //Verde
                   if( (((g - PromedioG)*k) + PromedioG) >255 ){
                         g = 255;
                  }else if ( (((g - PromedioG)*k) + PromedioG) <0  ){
                       g = 0;
                  }else{
                      g = Math.round ((((g - PromedioG)*k) + PromedioG));
                  }
                   //Azul
                  if( (((b - PromedioB)*k) + PromedioB) >255 ){
                         b = 255;
                  }else if ( (((b - PromedioB)*k) + PromedioB) <0  ){
                       b = 0;
                  }else{
                      b = Math.round ((((b - PromedioB)*k) + PromedioB));
                  }
                  
                  NuevoColor = (a << 24) | (r << 16) | (g << 8) | b;
                  ImgTemp.setRGB(x,y,NuevoColor); 
                }
            }
    } 
      
    public void GammaSetNuevosColores(){
        double yg = 1.2;
	int c1 = 1;
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth(); 
        int ColorActual=0;
        int NuevoColor=0;
        int a,r,g,b;
        double rtemp,gtemp,btemp;
         for (int y = 0; y < height; y++){
            for (int x = 0; x < width; x++) {
                 ColorActual=ImgTemp.getRGB(x, y);   
                 a = (ColorActual >> 24) & 0xff;
                 r = (ColorActual >> 16) & 0xff;
                 g = (ColorActual >> 8) & 0xff;
                 b = ColorActual & 0xff;
                 //Rojo
                 if (c1* Math.pow(r, yg) > 255){
                     r=255;                    
                 }else if(c1* Math.pow(r, yg) < 0){
                     r=0;
                 }else{
                     rtemp=  1* Math.pow(r, 0.8) ;
                     r= Math.toIntExact(Math.round(rtemp));
                 }
                //Verde
                  if (c1* Math.pow(g, yg) > 255){
                     g=255;                    
                 }else if(c1* Math.pow(g, yg) < 0){
                     g=0;
                 }else{
                     gtemp=  c1* Math.pow(g, yg) ;
                     g= Math.toIntExact(Math.round(gtemp));
                 }
                 //Azul
                 if (c1* Math.pow(b, yg) > 255){
                     b=255;                    
                 }else if(c1* Math.pow(b, yg) < 0){
                     b=0;
                 }else{
                     btemp=  c1* Math.pow(b, yg) ;
                     b= Math.toIntExact(Math.round(btemp));
                 }
                 
                NuevoColor = (a << 24) | (r << 16) | (g << 8) | b;
                ImgTemp.setRGB(x,y,NuevoColor); 
            }
         }
      }
    
    public void FiltroMaximo(){
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth();
        int color = 0;
        int colorR = 0;
        int [][] imagenSalida = new int [height][width];
        int aux;
        for (int x = 0; x<height; x++){
            for(int y = 0; y<width; y++){
                color = ImgTemp.getRGB(y,x);
                colorR = (color >> 16) & 0xff;
                imagenSalida[x][y] = colorR;
            }
        }
        ImagenEditada call = new ImagenEditada();
        int ColorFinal = 0;
        for(int i=0; i<height; i++){
            for(int j=0;j<width;j++){
                //System.out.print(" " + imagen[i][j]+ " ");
                aux = call.selector(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }
    }
    
    public int selector(int i, int j, int imagen[][]){
        int []auxiliar = new int[9];
        int x,y, mayor = 0;
        for(int k = 0; k<=auxiliar.length;k++){
                    switch(k){
                        case 0:
                            x=i-1;
                            y=j-1;
                            if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 1:
                            x=i-1;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 2:
                            x=i-1;
                            y=j+1;
                            if(x<0 || y < 0 || x>=imagen.length || y>=imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 3:
                            x=i;
                            y=j-1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 4:
                            x=i;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 5:
                            x=i;
                            y=j+1;
                            if(x<0 || y < 0 || x >= imagen.length || y >= imagen[0].length){
                                auxiliar[k]=0; 
                            }
                            else{
                                auxiliar[k]=imagen[x][y];
                            }
                        break;
                        case 6:
                            x=i+1;
                            y=j-1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 7:
                            x=i+1;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 8:
                            x=i+1;
                            y=j+1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 9:
                            mayor = auxiliar[0];
                            for (int t = 0; t < auxiliar.length; t++) {
                                if(auxiliar [t] > mayor) {
                                    mayor = auxiliar[t];
                                }
                            }
                            //System.out.print("El mayor es " + mayor + "\n ");
                        break;
                        default:
                            System.out.print("F");
                    }
                }
    return mayor;
    }
    
    public void FiltroMediana(){
        int aux;
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth();
        int color = 0;
        int colorR = 0;
        int [][] imagenSalida = new int [height][width];
        for (int x = 0; x<height; x++){
            for(int y = 0; y<width; y++){
                color = ImgTemp.getRGB(y,x);
                colorR = (color >> 16) & 0xff;
                imagenSalida[x][y] = colorR;
            }
        }
        ImagenEditada call = new ImagenEditada();
        int ColorFinal = 0;
        for(int i=0; i<imagenSalida.length; i++){
            for(int j=0;j<imagenSalida[0].length;j++){
                //System.out.print(" " + imagen[i][j]+ " ");
                aux = call.selector2(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
            //System.out.print("\n");
        }
    }
    
    public int selector2(int i, int j, int imagen[][]){
        int []auxiliar = new int[9];
        int x,y, mediana = 0;
        for(int k = 0; k<=auxiliar.length;k++){
                    switch(k){
                        case 0:
                            x=i-1;
                            y=j-1;
                            if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 1:
                            x=i-1;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 2:
                            x=i-1;
                            y=j+1;
                            if(x<0 || y < 0 || x>=imagen.length || y>=imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 3:
                            x=i;
                            y=j-1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 4:
                            x=i;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 5:
                            x=i;
                            y=j+1;
                            if(x<0 || y < 0 || x >= imagen.length || y >= imagen[0].length){
                                auxiliar[k]=0; 
                            }
                            else{
                                auxiliar[k]=imagen[x][y];
                            }
                        break;
                        case 6:
                            x=i+1;
                            y=j-1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 7:
                            x=i+1;
                            y=j;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 8:
                            x=i+1;
                            y=j+1;
                            if(x<0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;
                            }
                            else{
                                auxiliar[k]=imagen[x][y];   
                            }
                        break;
                        case 9:
                            //Ordenar Metodo Burbuja
                            int auxBurbuja;
                            for(int a = 0; a< auxiliar.length-1; a++){
                                for(int b = 0; b< auxiliar.length-1; b++){
                                    if(auxiliar[b]>auxiliar[b+1]){
                                        auxBurbuja = auxiliar[b];
                                        auxiliar[b] = auxiliar[b+1];
                                        auxiliar[b+1] = auxBurbuja; 
                                    }
                                }
                            }
                            mediana = auxiliar[(auxiliar.length)/2];
                        break;
                        default:
                            System.out.print("F");
                    }
                }
    return mediana;
    }
    
    public void FiltroEcualizador(){
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth();
        int color = 0;
        int colorR = 0;
        int [][] imagenSalida = new int [height][width];
        int aux;
        for (int x = 0; x<height; x++){
            for(int y = 0; y<width; y++){
                color = ImgTemp.getRGB(y,x);
                colorR = (color >> 16) & 0xff;
                imagenSalida[x][y] = colorR;
            }
        }
        int histograma[] = new int [256];
        for(int i = 0; i<histograma.length; i++){
            histograma[i] = 0;
        }
        //Contar las veces que se repite un valor para llenar el histograma
        for(int i=0; i<imagenSalida.length; i++){
            for( int j=0;j<imagenSalida[0].length; j++){
                aux = imagenSalida[i][j];
                histograma[aux] += 1; 
            }
        }
        //Calculo de probabilidad de encontrar ese color en la matriz
        double probabilidad[] = new double[256];
        for(int t = 0; t<probabilidad.length; t++){
            probabilidad[t] = (double)histograma[t]/(imagenSalida.length*imagenSalida[0].length);
            //System.out.print(histograma[i]/(imagen.length*imagen[0].length));
        }
        
        //Calculo de Probabilidad Acumulada
        double probabilidadA[] = new double [256];
        for(int i = 0; i<probabilidadA.length; i++){
            if(i == 0){
                probabilidadA[i] = probabilidad[i];
            }
            else{
                probabilidadA[i] = probabilidadA[i-1]+probabilidad[i];
            }
        }
        double ecualizacion[] = new double [256];
        int ecualizacionEnt[] = new int [256];
        for(int i = 0; i<ecualizacion.length; i++){
            ecualizacion[i] = probabilidadA[i]*(256-1);
            ecualizacionEnt[i] = (int) Math.round(ecualizacion[i]);
        }
        int ColorFinal = 0;
        for(int i=0; i<imagenSalida.length; i++){
            for(int j=0;j<imagenSalida[0].length;j++){
                aux = imagenSalida[i][j];
                ColorFinal =(255 << 24) | (ecualizacionEnt[aux] << 16) | (ecualizacionEnt[aux] << 8) | ecualizacionEnt[aux];
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }
    }
}
