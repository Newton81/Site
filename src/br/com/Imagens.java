package br.com;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
 
@ManagedBean
public class Imagens {
     
	
	 /** M�todo para listar as imagens
	   * @return images
	    */
	
    private List<String> images;
   
    @PostConstruct
    public void init() {
        images = new ArrayList<String>();
        for (int i = 1; i <= 7; i++) {
            images.add("imagens" + i + ".png");
        }
    }
 
    public List<String> getImages() {
        return images;
    }
}