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
                aux = call.selectorMaximo(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }
    }
    
    public int selectorMaximo(int i, int j, int imagen[][]){
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
                aux = call.selectorMediana(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
            //System.out.print("\n");
        }
    }
    
    public int selectorMediana(int i, int j, int imagen[][]){
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
    
    public void FiltroMinimo(){
        int aux;
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth();
        int color = 0;
        int colorR = 0;
        int [][] imagenSalida = new int [height][width];
        for (int x = 0; x < height; x++){
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
                aux = call.SelectorMinimo(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
            //System.out.print("\n");
        }
    }
        
    public int SelectorMinimo(int i0, int j0, int imagen[][]){
        int x,y, menor = 0;
        int k = 0;
        int []auxiliar = new int[9];
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                            x=i0+(i);
                            y=j0+(j);
                            if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;                               
                            }
                            else{
                                auxiliar[k]=imagen[x][y]; 
                                
                            }
                            k++;
                }      
            }
                            menor = auxiliar[0];
                            for (int t = 0; t < auxiliar.length; t++) {
                                if(auxiliar [t] < menor) {
                                    menor = auxiliar[t];
                                }
                            }
        return menor;
    }
        
    public void FiltroModa(){
        int aux;
        int height= ImgTemp.getHeight(); 
        int width= ImgTemp.getWidth();
        int color = 0;
        int colorR = 0;
        int [][] imagenSalida = new int [height][width];
        for (int x = 0; x < height; x++){
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
                aux = call.SelectorModa(i, j, imagenSalida);
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
            //System.out.print("\n");
        }
    }
       
    public int SelectorModa(int i0, int j0, int imagen[][]){
            int x,y,moda = 0;
        int k = 0;
        int []auxiliar = new int[9];
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                            x=i0+(i);
                            y=j0+(j);
                            if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                                auxiliar[k]=0;                               
                            }
                            else{
                                auxiliar[k]=imagen[x][y]; 
                                
                            }
                            k++;
                }      
            }
                            int cont = 0; 
                            int comp = 0;
                            int indice = 0;
                            for (int t = 0; t < auxiliar.length; t++) {
                            }
                            for (int t = 0; t < auxiliar.length; t++) {
                                for (int l = 0; l < auxiliar.length; l++) {
                                    if(auxiliar[t] == auxiliar[l]) {                                  
                                    cont++;
                                }
                            }
                            if(cont > comp){
                                comp = cont;
                                indice = t;
                                moda = auxiliar[t];
                            }
                            else if(cont == comp){
                                moda = (auxiliar[t] + auxiliar[indice])/2;
                            }
                            cont = 0;
                         }
                        
        return moda;
    
    }
    
    public void TresPorTres(int pos1, int pos2, int pos3){
        double filtro [][] = new double [3][3];
        filtro[0][0] = pos1;//Entrada teclado
        filtro[0][1] = pos2;//Entrada teclado
        filtro[0][2] = pos3;//Entrada teclado
        filtro[1][0] = pos2;//Entrada teclado
        filtro[1][1] = filtro[0][1]*filtro[1][0];
        filtro[1][2] = filtro[1][0]*filtro[0][2];
        filtro[2][0] = pos1;//Entrada teclado
        filtro[2][1] = filtro[2][0]*filtro[0][1];
        filtro[2][2] = filtro[2][0]*filtro[2][2];
        
        int divisor = (int)(filtro[0][0]+filtro[0][1]+filtro[0][2]);
        divisor = divisor*divisor;
        
        for(int i = 0; i<filtro.length;i++){
            for(int j = 0; j<filtro[0].length; j++){
                filtro[i][j] = filtro[i][j]/divisor;
            }
        }
        
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
        int ColorFinal = 0;
        ImagenEditada call = new ImagenEditada();
        double MatrizSalida [][] = new double [imagenSalida.length][imagenSalida[0].length];
        for(int i =  0; i<imagenSalida.length; i++){
            for(int j = 0; j<imagenSalida[0].length; j ++){
                MatrizSalida[i][j] = call.Convolucionador3x3(i, j, imagenSalida, filtro);
                aux = (int) MatrizSalida[i][j];
                //System.out.print(aux +"\n");
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }    
    }
    
    public double Convolucionador3x3(int i, int j, int imagen[][], double filtro[][]){
        int []auxiliar = new int[9];
        int x,y;
        double valor = 0;
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
                            valor = auxiliar[0]*filtro[2][2]+auxiliar[1]*filtro[2][1]+auxiliar[2]*filtro[2][0]+auxiliar[3]*filtro[1][2]+auxiliar[4]*filtro[1][1]+auxiliar[5]*filtro[1][0]+auxiliar[6]*filtro[0][2]+auxiliar[7]*filtro[0][1]+auxiliar[8]*filtro[0][0];
                            //System.out.print("El mayor es " + mayor + "\n ");
                        break;
                        default:
                            System.out.print("F");
                    }
                }
    return valor;
    }
    
    public void FiltroGaussiano(double num){
        
        double sigma = num;
        double normal = 0;
        double gaus = 0;
        double op = 0;
        double [][] filtroGaussiano = new double [3][3];
        for(int x = -1; x < 2; x++ ){
            for(int y = -1; y < 2; y++ ){
                normal = (1/(Math.pow(sigma,2)*2*Math.PI));
                op = (-(Math.pow(x, 2) + Math.pow(y, 2))/(2*Math.pow(sigma,2)));
                gaus =  Math.exp(op);
                filtroGaussiano[x+1][y+1] = normal*gaus;
            }
        }
        
        double suma = 0;
        for(int i = 0; i< filtroGaussiano.length;i++){
            for(int j = 0; j < filtroGaussiano[0].length; j++){
                suma = (suma + filtroGaussiano[i][j]);
            }
        }
        
        for(int i = 0; i< filtroGaussiano.length;i++){
            for(int j = 0; j < filtroGaussiano[0].length; j++){
                filtroGaussiano[i][j] = filtroGaussiano[i][j]/suma;
            }
        }
        
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
        int ColorFinal = 0;
        ImagenEditada call = new ImagenEditada();
        double MatrizSalida [][] = new double [imagenSalida.length][imagenSalida[0].length];
        for(int i =  0; i<imagenSalida.length; i++){
            for(int j = 0; j<imagenSalida[0].length; j ++){
                MatrizSalida[i][j] = call.ConvolucionadorGaussiano(i, j, imagenSalida, filtroGaussiano);
                aux = (int) MatrizSalida[i][j];
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }    
    }
        public double ConvolucionadorGaussiano(int i0, int j0, int imagen[][], double filtro[][]){
        int x,y;
        int k = 0;
        double valor = 0;
        int []auxiliar = new int[25];
            for(int i = -1; i < 2; i++){
                for(int j = -1; j < 2; j++){
                    x=i0+(i);
                    y=j0+(j);
                    if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                        auxiliar[k]=0;                               
                    }
                    else{
                        auxiliar[k]=imagen[x][y]; 
                    }
                k++;
            }      
        }
        k=0;
        for(int i = 0; i <filtro.length; i++){
            for(int j = 0; j <filtro.length; j++){
                valor = valor + (auxiliar[k]*filtro[i][j]);
                k++;  
            }      
        }
     return valor;
    }
     
    public void CincoPorCinco(){
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
        double [][] Filtro = new double [5][5];
        
        Filtro[0][0]=1/256.;
        Filtro[0][1]=4/256.;
        Filtro[0][2]=6/256.;
        Filtro[0][3]=4/256.;
        Filtro[0][4]=1/256.;
        Filtro[1][0]=4/256.;
        Filtro[1][1]=16/256.;
        Filtro[1][2]=24/256.;
        Filtro[1][3]=16/256.;
        Filtro[1][4]=4/256.;
        Filtro[2][0]=6/256.;
        Filtro[2][1]=24/256.;
        Filtro[2][2]=36/256.;
        Filtro[2][3]=24/256.;
        Filtro[2][4]=6/256.;
        Filtro[3][0]=4/256.;
        Filtro[3][1]=16/256.;
        Filtro[3][2]=24/256.;
        Filtro[3][3]=16/256.;
        Filtro[3][4]=4/256.;
        Filtro[4][0]=1/256.;
        Filtro[4][1]=4/256.;
        Filtro[4][2]=6/256.;
        Filtro[4][3]=4/256.;
        Filtro[4][4]=1/256.;
        
        ImagenEditada call = new ImagenEditada();
        int ColorFinal = 0;
        for(int i=0; i<height; i++){
            for(int j=0;j<width;j++){
                aux = (int) call.Convolucionador5x5(i, j, imagenSalida, Filtro); 
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }    
    }
    
    public double Convolucionador5x5(int i0, int j0, int imagen[][], double filtro[][]){
        int x,y;
        int k = 0;
        double valor = 0;
        int []auxiliar = new int[25];
            for(int i = -2; i < 3; i++){
                for(int j = -2; j < 3; j++){
                    x=i0+(i);
                    y=j0+(j);
                    if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                        auxiliar[k]=0;                               
                    }
                    else{
                        auxiliar[k]=imagen[x][y]; 
                    }
                k++;
            }      
        }
        k=0;
        double aux2;
        for(int i = 0; i <filtro.length; i++){
            for(int j = 0; j <filtro.length; j++){
                aux2 = auxiliar[k]*filtro[i][j];
                valor = valor + aux2;
                k++;  
            }      
        }
     return valor;
    }
    
    public void SietePorSiete(){
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
        double [][] Filtro = {
            {1/4096.,6/4096., 15/4096., 20/4096., 15/4096., 6/4096.,1/4096.},
            {6/4096.,36/4096.,90/4096.,120/4096.,90/4096.,36/4096.,6/4096.},
            {15/4096.,90/4096.,225/4096.,300/4096.,225/4096.,90/4096.,15/4096.},            
            {20/4096.,120/4096.,300/4096.,400/4096.,300/4096.,120/4096.,20/4096.}, 
            {15/4096.,90/4096.,225/4096.,300/4096.,225/4096.,90/4096.,15/4096.},
            {6/4096.,36/4096.,90/4096.,120/4096.,90/4096.,36/4096.,6/4096.},
            {1/4096.,6/4096.,15/4096.,20/4096.,15/4096.,6/4096.,1/4096.} 
        };
        
        ImagenEditada call = new ImagenEditada();
        int ColorFinal = 0;
        for(int i=0; i<height; i++){
            for(int j=0;j<width;j++){
                aux = (int) call.Convolucionador7x7(i, j, imagenSalida, Filtro); 
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }    
    }
        public double Convolucionador7x7(int i0, int j0, int imagen[][], double filtro[][]){
        int x,y;
        int k = 0;
        double valor = 0;
        int []auxiliar = new int[81];
            for(int i = -3; i < 4; i++){
                for(int j = -3; j < 4; j++){
                    x=i0+(i);
                    y=j0+(j);
                    if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                        auxiliar[k]=0;                               
                    }
                    else{
                        auxiliar[k]=imagen[x][y]; 
                    }
                k++;
            }      
        }
        k=0;
        double aux2;
        for(int i = 0; i <filtro.length; i++){
            for(int j = 0; j <filtro.length; j++){
                aux2 = auxiliar[k]*filtro[i][j];
                valor = valor + aux2;
                k++;  
            }      
        }
     return valor;
    }

    
    public void NuevePorNueve(){
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
        double [][] Filtro = {
            {1/65536.,8/65536., 28/65536., 56/65536., 70/65536., 56/65536.,28/65536.,8/65536.,1/65536.},
            {8/65536.,64/65536.,224/65536.,448/65536.,560/65536.,448/65536.,224/65536.,64/65536.,8/65536.},
            {28/65536.,224/65536.,784/65536.,1568/65536.,1960/65536.,1568/65536.,784/65536.,224/65536.,28/65536.},            
            {56/65536.,448/65536.,1568/65536.,3136/65536.,3920/65536.,3136/65536.,1568/65536.,448/65536.,56/65536.}, 
            {70/65536.,560/65536.,1960/65536.,3920/65536.,4900/65536.,3920/65536.,1960/65536.,560/65536.,70/65536.},
            {56/65536.,448/65536.,1568/65536.,3136/65536.,3920/65536.,3136/65536.,1568/65536.,448/65536.,56/65536.},
            {28/65536.,224/65536.,784/65536.,1568/65536.,1960/65536.,1568/65536.,784/65536.,224/65536.,28/65536.}, 
            {8/65536.,64/65536.,224/65536.,448/65536.,560/65536.,448/65536.,224/65536.,64/65536.,8/65536.},
            {1/65536.,8/65536., 28/65536., 56/65536., 70/65536.,56/65536.,28/65536.,8/65536.,1/65536.}
        };
        
        ImagenEditada call = new ImagenEditada();
        int ColorFinal = 0;
        for(int i=0; i<height; i++){
            for(int j=0;j<width;j++){
                aux = (int) call.Convolucionador9x9(i, j, imagenSalida, Filtro); 
                ColorFinal =(255 << 24) | (aux << 16) | (aux << 8) | aux;
                ImgTemp.setRGB(j, i, ColorFinal);
            }
        }    
    }
    
    public double Convolucionador9x9(int i0, int j0, int imagen[][], double filtro[][]){
        int x,y;
        int k = 0;
        double valor = 0;
        int []auxiliar = new int[81];
            for(int i = -4; i < 5; i++){
                for(int j = -4; j < 5; j++){
                    x=i0+(i);
                    y=j0+(j);
                    if(x < 0 || y < 0 || x>=imagen.length || y>= imagen[0].length){
                        auxiliar[k]=0;                               
                    }
                    else{
                        auxiliar[k]=imagen[x][y]; 
                    }
                k++;
            }      
        }
        k=0;
        double aux2;
        for(int i = 0; i <filtro.length; i++){
            for(int j = 0; j <filtro.length; j++){
                aux2 = auxiliar[k]*filtro[i][j];
                valor = valor + aux2;
                k++;  
            }      
        }
     return valor;
    }
}
